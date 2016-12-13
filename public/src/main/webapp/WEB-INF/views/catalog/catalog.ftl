<#-- @ftlvariable name="movies" type="java.util.List<com.itis.dz.entities.Movie>" -->
<#include "../template/template.ftl">
<@mainTemplate title="Most popular"/>
<#macro m_body>
<div class="container well-md">
    <div class="container-fluid">
        <div class="row">
                    <#list movies as movie>
                        <div class="col-lg-4 col-md-4 col-xs-4 col-sm-4">
                            <div class="thumbnail">
                                <span class="movie_rating">${movie.totalraiting}</span>
                                <img src="${movie.img}" alt="">

                                <div class="caption">
                                    <h5><a href="/movie/${movie.id}">${movie.name}</a>
                                    </h5>
                                    <p>${movie.description}</p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
    </div>
</#macro>