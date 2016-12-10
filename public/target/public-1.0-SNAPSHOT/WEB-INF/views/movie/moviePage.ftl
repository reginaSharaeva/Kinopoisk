<#-- @ftlvariable name="movie" type="com.itis.dz.entities.Movie" -->
<#include "../template/template.ftl">
<@mainTemplate title="" />
<#macro m_body>
<div class="container well-md">
    <div class="col-lg-4 col-md-4 col-xs-4">
        <div class="movie_image">
            <span class="movie_rating">${movie.getTotalraiting()}</span>
            <img src="${movie.getImg()}" class="img-responsive" alt="${movie.getName()}">
        </div>
        <div class="movie_rate">
            <div class="rating_desc"><p>Your Vote :</p></div>
            <form action="" class="sky-form">
                <fieldset>
                    <section>
                        <div class="rating">
                            <input type="radio" name="stars-rating" id="stars-rating-5">
                            <label for="stars-rating-5"><i class="icon-star"></i></label>
                            <input type="radio" name="stars-rating" id="stars-rating-4">
                            <label for="stars-rating-4"><i class="icon-star"></i></label>
                            <input type="radio" name="stars-rating" id="stars-rating-3">
                            <label for="stars-rating-3"><i class="icon-star"></i></label>
                            <input type="radio" name="stars-rating" id="stars-rating-2">
                            <label for="stars-rating-2"><i class="icon-star"></i></label>
                            <input type="radio" name="stars-rating" id="stars-rating-1">
                            <label for="stars-rating-1"><i class="icon-star"></i></label>
                        </div>
                    </section>
                </fieldset>
            </form>
            <div class="clearfix"></div>
        </div>

    </div>
    <div class="col-lg-8 col-md-8 col-xs-8">
        <div class="panel panel-default">
            <div class="panel-heading">${movie.getName()}</div>
            <table class="table info">
                <tbody>
                <tr>
                    <td>Возраст</td>
                    <td>${movie.age} +</td>
                </tr>
                <tr>
                    <td>Продолжительность</td>
                    <td>${movie.time} мин</td>
                </tr>
                <tr>
                    <td>год</td>
                    <td>
                    ${movie.year}
                    </td>
                </tr>
                <tr>
                    <td>жанры</td>
                    <td>
                        <#assign x=false>
                        <#list movie.genres as genre>
                            <#if x==true>,
                            </#if>
                        ${genre.name}
                            <#assign x=true>
                        </#list>
                    </td>
                </tr>
                <tr>
                    <td>страна</td>
                    <td>
                    ${movie.country.name}
                    </td>
                </tr>
                <tr>
                    <td>актёры</td>
                    <td>
                        <#assign x=false>
                        <#list movie.persons as person>
                            <#list person.roles as role>
                                <#if role.name=="Актер">
                                    <#if x==true>,
                                    </#if>
                                    <a href="/person/${person.id}">${person.secondName} ${person.firstName} ${person.lastName}</a>
                                    <#assign x=true>
                                </#if>
                            </#list>
                        </#list>
                    </td>
                </tr>
                <tr>
                    <td>режиссер</td>
                    <td>
                        <#assign x=false>
                        <#list movie.persons as person>
                            <#list person.roles as role>
                                <#if role.name=="Режиссер">
                                    <#if x==true>,
                                    </#if>
                                    <a href="/person/${person.id}">${person.secondName} ${person.firstName} ${person.lastName}</a>
                                    <#assign x=true>
                                </#if>
                            </#list>
                        </#list>
                    </td>
                </tr>
                <tr>
                    <td>режиссер</td>
                    <td>
                        <#assign x=false>
                        <#list movie.persons as person>
                            <#list person.roles as role>
                                <#if role.name=="Сценарист">
                                    <#if x==true>,
                                    </#if>
                                    <a href="/person/${person.id}">${person.secondName} ${person.firstName} ${person.lastName}</a>
                                    <#assign x=true>
                                </#if>
                            </#list>
                        </#list>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <p>${movie.description}</p>
    </div>
</div>
<#if movie.comments??>
<div class="container com">
    <#if comments_count??>
    <div class="comments-section-head-text">
        <h3>${comments_count} Comments</h3>
    </div>
        </#if>
    <div class="clearfix"></div>
    <div class="comments-section-grids">
    <#list movie.comments as comment>
        <#include "comment.ftl">
    </#list>
    </div>
    <@sec.authorize access="isAuthenticated()">
    <div class="reply-section">
        <h3>Leave Reply</h3>

        <div class="clearfix"></div>
    </div>
    <div class="container comts">
        <form action="/movie/addComment">
            <div class="text">
                    <textarea name="text" value="Message:" onfocus="this.value = '';"
                              onblur="if (this.value == '') {this.value = 'Message';}">Message:</textarea>
            </div>
            <div class="form-submit1">

                <input name="submit" type="submit" id="submit" value="Submit Your Message" class="js_addComment"
                       data-film_id="${movie.id}" >

            </div>
            <div class="clearfix"></div>
        </form>
    </div>
    </@sec.authorize>
</div>
</#if>
</#macro>