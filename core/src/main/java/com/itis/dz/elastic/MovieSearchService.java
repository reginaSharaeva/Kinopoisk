package com.itis.dz.elastic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itis.dz.entities.Movie;
import org.apache.commons.lang.NotImplementedException;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.itis.dz.config.ElasticConfig.MOVIE_CORP_INDEX;
import static com.itis.dz.config.ElasticConfig.MOVIE_TYPE;


/**
 * Created by Aydar Farrakhov on 11.09.16.
 */
@Service
public class MovieSearchService implements IMovieSearchService {


    private static final String DESCRIPTION_FIELD = "description";
    private static final String NAME_FIELD = "name";
    private static final String ALL_FIELD = "_all";
    private static final String PERSON_NAME_FIELD= "persons.firstName";
    private static final String GENRES_NAME_FIELD="genres.name";
    private static final String YEAR_FIELD="year";
    private static final String RAITING_FIELD="totalraiting";

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private Client client;


    //добавление
    @Override
    public void add(Movie movie) {
        try {
            client.prepareIndex(MOVIE_CORP_INDEX, MOVIE_TYPE, String.valueOf(movie.getId()))
                    .setSource(mapper.writeValueAsString(movie))
                    .get();

           } catch (JsonProcessingException ignored) {
        }
    }

    @Override
    public void delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public void update(Movie movie) {
        throw new NotImplementedException();
    }



    @Override
    public List<Movie> matchQuery(String q, Pageable page) {

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery(DESCRIPTION_FIELD, q))
                .setSize(page.getPageSize())
                .setFrom((page.getPageNumber() - 1) * page.getPageSize())
                .execute()
                .actionGet();
        return getResult(response);
    }

    @Override
    public List<Movie> matchNameQuery(String q) {

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery(NAME_FIELD, q))
                .execute()
                .actionGet();
        return getResult(response);
    }


       @Override
    public List<Movie> matchDescriptionQuery(String description) {
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery(DESCRIPTION_FIELD, description))
                .execute()
                .actionGet();
        return getResult(response);
    }

    @Override
    public List<Movie> matchPhraseQuery(String q) {
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchPhraseQuery(DESCRIPTION_FIELD, q))
                .execute()
                .actionGet();

        return getResult(response);
    }


    @Override
    public List<Movie> findAll(String sort) {
        if(sort.isEmpty()&&(!sort.equals(YEAR_FIELD)^!sort.equals(RAITING_FIELD))){
            sort=YEAR_FIELD;
        }
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .addSort(sort, SortOrder.ASC)
                .setQuery(QueryBuilders.matchAllQuery())
                .execute()
                .actionGet();
        return getResult(response);
    }



    @Override
    public List<Movie> matchPhrasePrefixQuery(String q) {

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchPhrasePrefixQuery(DESCRIPTION_FIELD, q))
                .execute()
                .actionGet();


        return getResult(response);
    }

    @Override
    public List<Movie> fuzzyQuery(String q) {

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.fuzzyQuery(NAME_FIELD, q).fuzziness(Fuzziness.TWO))
                .execute()
                .actionGet();
        return getResult(response);
    }

    @Override
    public String autocomplete(String q) {
        return client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery(ALL_FIELD, q).operator(MatchQueryBuilder.Operator.AND))
                .addHighlightedField(NAME_FIELD)
                .setHighlighterPreTags("")
                .setHighlighterPostTags("")
                .setHighlighterRequireFieldMatch(false)
                .execute()
                .actionGet()
                .toString();

    }
//name and persons.name
    @Override
    public List<Movie> fullSearsh(String search, String searchBy, List<String>values, String from, String to, String sort) {
        QueryBuilder query = QueryBuilders.matchQuery("", "");
        if(!checkWithRegExp(from)){
            from="";
        }
        if(!checkWithRegExp(to)){
            to="";
        }
        if (!search.isEmpty() && ((searchBy.equals(NAME_FIELD) ^ searchBy.equals(PERSON_NAME_FIELD))^searchBy.equals(DESCRIPTION_FIELD))) {
            if (!values.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to(to));
            } else if (values.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to(to));
            } else if (!values.isEmpty() && from.isEmpty() && to.isEmpty()) {
                query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values));
            } else if (!values.isEmpty() && (from.isEmpty() ^ to.isEmpty())) {
                if (from.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from("0").to(to));
                } else if (to.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to("2020"));
                }

            } else if (values.isEmpty() && (from.isEmpty() ^ to.isEmpty())) {
                if (from.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from("0").to(to));
                } else if (to.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(searchBy, search)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to("2020"));
                }
            } else if(values.isEmpty() && from.isEmpty() && to.isEmpty()){
                query= QueryBuilders.matchQuery(searchBy, search);
            }
        } else if(search.isEmpty()){
            if (!values.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                query = QueryBuilders.boolQuery().must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to(to));
            } else if (values.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                query = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to(to));
            } else if (!values.isEmpty() && from.isEmpty() && to.isEmpty()) {
                query = QueryBuilders.boolQuery().must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values));
            } else if (!values.isEmpty() && (from.isEmpty() ^ to.isEmpty())) {
                if (from.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from("0").to(to));
                } else if (to.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.termsQuery(GENRES_NAME_FIELD, values)).must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to("2020"));
                }

            } else if (values.isEmpty() && (from.isEmpty() ^ to.isEmpty())) {
                if (from.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(YEAR_FIELD).from("0").to(to));
                } else if (to.isEmpty()) {
                    query = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(YEAR_FIELD).from(from).to("2020"));
                }
            }
        }
        if(sort.isEmpty()&&(!sort.equals(YEAR_FIELD)^!sort.equals(RAITING_FIELD))){
            sort=YEAR_FIELD;
        }

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .addSort(sort, SortOrder.ASC)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(query)
                .execute()
                .actionGet();

        return getResult(response);
    }


    @Override
    public List<Movie> searsh(String search, String searchBy, String sort){
        QueryBuilder query = QueryBuilders.matchQuery("", "");


        if (!search.isEmpty() && ((searchBy.equals(NAME_FIELD) ^ searchBy.equals(PERSON_NAME_FIELD))^searchBy.equals(DESCRIPTION_FIELD))&&(sort.equals(YEAR_FIELD)^sort.equals(RAITING_FIELD))) {

            query= QueryBuilders.matchQuery(searchBy, search);

        }

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .addSort(sort, SortOrder.ASC)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(query)
                .execute()
                .actionGet();

        return getResult(response);


    }


    public static boolean checkWithRegExp(String str){
        Pattern p = Pattern.compile("^[1-2][0-9]{3}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }


    private List<Movie> getResult(SearchResponse response) {
        List<Movie> result = new ArrayList<>();
        response.getHits().forEach(h -> {
            try {
                result.add(mapper.readValue(h.getSourceAsString(), Movie.class));
            } catch (IOException ignored) {
            }
        });
        return result;
    }

}
