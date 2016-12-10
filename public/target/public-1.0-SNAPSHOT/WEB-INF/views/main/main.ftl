<#include "../template/template.ftl">
<@mainTemplate title="Home"/>
<#macro m_body>
    <#include "../template/components/slider.ftl">
<main class="page-content text-center text-md-left">
    <!--Start filters-->

    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <div class="input-group">
                    <div class="input-group-btn search-panel">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <span id="search_concept">Filter by</span> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#name">Название</a></li>
                            <li><a href="#actors">Актёры</a></li>
                            <li><a href="#directors">Режиссёры</a></li>
                        </ul>
                    </div>
                    <input type="hidden" name="search_param" value="all" id="search_param">
                    <input type="text" class="form-control" name="x" placeholder="Search term...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button"><i class="fa fa-search" aria-hidden="true"></i></button>
                </span>
                </div>
            </div>
        </div>
        <div class="row">

            <!-- RD Navbar Search
            <div class="rd-navbar-search-wrap">
                <div class="rd-navbar-search">
                    <form class="rd-navbar-search-form" action="#" method="GET">
                        <div class="input-group">
                            <input type="text" id="search" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button"><i class="fa fa-search" aria-hidden="true"></i></button>
      </span>
                        </div>
                    </form>
                    <span class="rd-navbar-live-search-results"></span>
                    <button class="rd-navbar-search-toggle" data-rd-navbar-toggle=".rd-navbar-search"></button>
                </div>
            </div>

        </div>
        <!-- END RD Navbar Search -->
        <div id="filter-panel" class="collapse filter-panel">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" role="form">
                        <!-- form group [rows] -->
                        <div class="form-group">
                            <label class="filter-col" style="margin-right:0;" for="pref-orderby">Сортировать по:</label>
                            <select id="pref-orderby" class="form-control">
                                <option>Релевантность</option>
                                <option>Рейтинг</option>
                                <option>Год выпуска</option>
                            </select>
                        </div>
                        <!-- form group [order by] -->
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-4 col-xs-4">
                <div id="accordion" class="panel panel-primary behclick-panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Search Filter Film</h3>
                    </div>
                    <div class="panel-body">
                        <div class="panel-heading ">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse0"> Год выпуска
                                </a>
                            </h4>
                        </div>
                        <div id="collapse0" class="panel-collapse collapse in">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            2000 - 2005
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            2005 - 2010
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            2010 - 2016
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse3"> Жанр</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse in">
                            <ul class="list-group">
                                <#list genres as genre>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="${genre}">
                                        ${genre}
                                        </label>
                                    </div>
                                </li></#list>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-8">
                <!--End filters-->
                <div class="row">
                    <#list movieList as movie>
                        <#if movie_index<=6>
                    <div class="col-lg-4 col-md-4 col-xs-4 col-sm-4">
                        <div class="thumbnail">
                            <img src="${movie.getImg()}" alt="">

                            <div class="caption">
                                <h5><a href="/movie/${movie.getId()}">${movie.getName()}</a>
                                </h5>

                                <p>${movie.getDescription()}</p>
                            </div>
                        </div>
                    </div>
                        </#if>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</main>
</#macro>