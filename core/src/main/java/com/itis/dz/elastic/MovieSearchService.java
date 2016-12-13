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
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    //находит где точное совпадение
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
    public List<Movie> findAll() {
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setQuery(QueryBuilders.matchAllQuery())
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
    public List<Movie> matchPhrasePrefixQuery(String q) {

        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchPhrasePrefixQuery(DESCRIPTION_FIELD, q))
                .execute()
                .actionGet();


        return getResult(response);
    }
//неточный зарос(исправление опечаток
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
//автокомплит
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
   //
    @Override
    public List<Movie> fullFilterQuery(List<String>values, String from, String before){
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("genres.name", values)).must(QueryBuilders.rangeQuery("year").from(from).to(before)))
                .execute()
                .actionGet();

        return getResult(response);
    }

    @Override
    public List<Movie> yearFilterQuery(String year) {
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("year", year))
                .execute()
                .actionGet();

        return getResult(response);

    }
    @Override
    public List<Movie> genresFilterQuery(List<String>values){
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                //.addSort("year", SortOrder.ASC)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termsQuery("genres.name", values))
                .execute()
                .actionGet();

        return getResult(response);
    }

    @Override
    public List<Movie> rangeYearFilterQuery(String from, String before){
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.rangeQuery("year").from(from).to(before))
                .execute()
                .actionGet();
       return getResult(response);
}
    @Override
    public  List<Movie> genresYearFilterQuery(List<String>values, String year){
        SearchResponse response = client.prepareSearch(MOVIE_CORP_INDEX)
                .setTypes(MOVIE_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("genres.name", values)).must(QueryBuilders.termQuery("year",year)))
                .execute()
                .actionGet();
        return getResult(response);
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
