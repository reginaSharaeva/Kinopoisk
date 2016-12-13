<#include "../template/template.ftl">
<@mainTemplate title="Home"/>
<#macro m_body>
    <#include "../template/components/slider.ftl">
<main class="page-content text-center text-md-left">
    <!-- Featured movies -->
    <section class="well-md">
        <div class="container">
            <div class="row row-md-bottom">
                <div class="col-xs-12 col-md-6 col-md-push-1">
                    <h3>Featured movies</h3>
                </div>

                <div class="col-xs-12 col-md-push-3 offset-4">
                    <div class="owl-carousel owl-theme owl-loaded" data-lightbox="gallery" data-items="1"
                         data-xs-items="2" data-md-items="4" data-margin="20" data-sm-margin="30"
                         data-stage-padding="45" data-md-stage-padding="0" data-loop="false" data-nav="false">
                        <div class="owl-stage-outer">
                            <div class="owl-stage"
                                 style="transform: translate3d(0px, 0px, 0px); transition: 0s; width: 600px;">
                                <div class="owl-item active" style="width: 270px; margin-right: 30px;">
                                    <div class="owl-stage-outer">
                                        <div class="owl-stage"
                                             style="transform: translate3d(0px, 0px, 0px); transition: 0s; width: 1200px;">

                                            <div id="root"></div>

                                        </div>
                                    </div>
                                </div>
                                <div class="owl-item active" style="width: 270px; margin-right: 30px;">
                                    <div class="owl-controls">
                                        <div class="owl-nav">
                                            <div class="owl-prev" style="display: none;"></div>
                                            <div class="owl-next" style="display: none;"></div>
                                        </div>
                                        <div class="owl-dots" style="display: none;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="owl-controls">
                            <div class="owl-nav">
                                <div class="owl-prev" style="display: none;"></div>
                                <div class="owl-next" style="display: none;"></div>
                            </div>
                            <div class="owl-dots" style="display: none;"></div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </section>



    <!--Start filters-->

    <#--<div class="container-fluid">-->
        <#--<div class="row">-->
            <#--<div class="col-xs-8 col-xs-offset-2">-->
                <#--<div class="input-group">-->
                    <#--<div class="input-group-btn search-panel">-->
                        <#--<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">-->
                            <#--<span id="search_concept">Фильтровать по</span> <span class="caret"></span>-->
                        <#--</button>-->
                        <#--<ul class="dropdown-menu" role="menu">-->
                            <#--<li><a href="#name">Названию</a></li>-->
                            <#--<li><a href="#actors">Актёрам</a></li>-->
                            <#--<li><a href="#directors">Режиссёрам</a></li>-->
                        <#--</ul>-->
                    <#--</div>-->
                    <#--<input type="hidden" name="search_param" value="all" id="search_param">-->
                    <#--<input type="text" class="form-control" name="x" placeholder="Search term...">-->
                <#--<span class="input-group-btn">-->
                    <#--<button class="btn btn-default" type="button"><i class="fa fa-search" aria-hidden="true"></i></button>-->
                <#--</span>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="row">-->

        <#--<div id="filter-panel" class="filter-panel">-->
            <#--<div class="panel panel-default">-->
                <#--<div class="panel-body">-->
                    <#--<form class="form-inline" role="form">-->
                        <#--<!-- form group [rows] &ndash;&gt;-->
                        <#--<div class="form-group">-->
                            <#--<label class="filter-col" style="margin-right:0;" for="pref-orderby">Сортировать по:</label>-->
                            <#--<select id="pref-orderby" class="form-control">-->
                                <#--<option>Релевантность</option>-->
                                <#--<option>Рейтинг</option>-->
                                <#--<option>Год выпуска</option>-->
                            <#--</select>-->
                        <#--</div>-->
                        <#--<!-- form group [order by] &ndash;&gt;-->
                    <#--</form>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
            <#--<a href="/movie/add" style="    margin-left: 700px;" class="btn btn-xs btn-primary">Добавить фильм</a>-->
        <#--<div class="row">-->
            <#--<div class="col-lg-4 col-md-4 col-xs-4">-->
                <#--<div id="accordion" class="panel panel-primary behclick-panel">-->
                    <#--<div class="panel-heading">-->
                        <#--<h3 class="panel-title">Search Filter Film</h3>-->
                    <#--</div>-->
                    <#--<div class="panel-body">-->
                        <#--<div class="panel-heading ">-->
                            <#--<h4 class="panel-title">-->
                                <#--<a data-toggle="collapse" href="#collapse0"> Год выпуска-->
                                <#--</a>-->
                            <#--</h4>-->
                        <#--</div>-->
                        <#--<div id="collapse0" class="panel-collapse collapse in">-->
                            <#--<ul class="list-group">-->
                                <#--<li class="list-group-item">-->
                                    <#--<div class="checkbox">-->
                                        <#--<label>-->
                                            <#--<input type="checkbox" value="">-->
                                            <#--2000 - 2005-->
                                        <#--</label>-->
                                    <#--</div>-->
                                <#--</li>-->
                                <#--<li class="list-group-item">-->
                                    <#--<div class="checkbox">-->
                                        <#--<label>-->
                                            <#--<input type="checkbox" value="">-->
                                            <#--2005 - 2010-->
                                        <#--</label>-->
                                    <#--</div>-->
                                <#--</li>-->
                                <#--<li class="list-group-item">-->
                                    <#--<div class="checkbox">-->
                                        <#--<label>-->
                                            <#--<input type="checkbox" value="">-->
                                            <#--2010 - 2016-->
                                        <#--</label>-->
                                    <#--</div>-->
                                <#--</li>-->
                            <#--</ul>-->
                        <#--</div>-->
                        <#--<div class="panel-heading">-->
                            <#--<h4 class="panel-title">-->
                                <#--<a data-toggle="collapse" href="#collapse3"> Жанр</a>-->
                            <#--</h4>-->
                        <#--</div>-->
                        <#--<div id="collapse3" class="panel-collapse collapse in">-->
                            <#--<ul class="list-group">-->
                                <#--<#list genres as genre>-->
                                <#--<li class="list-group-item">-->
                                    <#--<div class="checkbox">-->
                                        <#--<label>-->
                                            <#--<input type="checkbox" value="${genre}">-->
                                        <#--${genre}-->
                                        <#--</label>-->
                                    <#--</div>-->
                                <#--</li></#list>-->
                            <#--</ul>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="col-lg-8 col-md-8 col-xs-8">-->
                <#--<!--End filters&ndash;&gt;-->
                <#--<div class="row">-->
                    <#--<#list movieList as movie>-->
                        <#--<#if movie_index<=6>-->
                    <#--<div class="col-lg-4 col-md-4 col-xs-4 col-sm-4">-->
                        <#--<div class="thumbnail">-->
                            <#--<img src="${movie.getImg()}" alt="">-->

                            <#--<div class="caption">-->
                                <#--<h5><a href="/movie/${movie.getId()}">${movie.getName()}</a>-->
                                <#--</h5>-->

                                <#--<p>${movie.getDescription()}</p>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                        <#--</#if>-->
                    <#--</#list>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
</main>
</#macro>