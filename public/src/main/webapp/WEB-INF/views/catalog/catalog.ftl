<#include "../template/template.ftl">
<@mainTemplate/>
<#macro m_body>
<div class="container well-md">
    <!--Start filters-->
    <div class="container-fluid">
        <div class="row">
            <div id="filter-panel" class="collapse filter-panel">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form class="form-inline" role="form">
                            <div class="form-group">
                                <label class="filter-col" style="margin-right:0;" for="pref-perpage">Rows per
                                    page:</label>
                                <select id="pref-perpage" class="form-control">
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option selected="selected" value="10">10</option>
                                    <option value="15">15</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="40">40</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                    <option value="200">200</option>
                                    <option value="300">300</option>
                                    <option value="400">400</option>
                                    <option value="500">500</option>
                                    <option value="1000">1000</option>
                                </select>
                            </div>
                            <!-- form group [rows] -->
                            <div class="form-group">
                                <label class="filter-col" style="margin-right:0;" for="pref-orderby">Order by:</label>
                                <select id="pref-orderby" class="form-control">
                                    <option>Релевантность</option>
                                    <option>Рейтинг</option>
                                    <option>Год выпуска</option>
                                </select>
                            </div>
                            <!-- form group [order by] -->
                            <div class="form-group">
                                <div class="checkbox" style="margin-left:10px; margin-right:10px;">
                                    <label><input type="checkbox"> Remember parameters</label>
                                </div>
                                <button type="submit" class="btn btn-default filter-col">
                                    <span class="glyphicon glyphicon-record"></span> Save Settings
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#filter-panel">
                <span class="glyphicon glyphicon-cog"></span> Advanced Search
            </button>
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
                                <a data-toggle="collapse" href="#collapse0">
                                    <i class="indicator fa fa-caret-down" aria-hidden="true"></i> Год выпуска
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

                        <div class="panel-heading ">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse1">
                                    <i class="indicator fa fa-caret-down" aria-hidden="true"></i> Название
                                </a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse in">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            citroen
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            benz
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            bmw
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse3"><i class="indicator fa fa-caret-down"
                                                                               aria-hidden="true"></i> Жанр</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse in">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            red
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            blue
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            green
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            green
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            green
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse2"><i class="indicator fa fa-caret-right"
                                                                               aria-hidden="true"></i> Актёры
                                </a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            7
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            8
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            9
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse2"><i class="indicator fa fa-caret-right"
                                                                               aria-hidden="true"></i> Режиссёры
                                </a>
                            </h4>
                        </div>
                        <div id="collapse4" class="panel-collapse collapse">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            7
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            8
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            9
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-8">
                <!--End filters-->
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-xs-4 col-sm-4">
                        <div class="thumbnail">
                            <img src="/resources/i/page-1_img02_original.jpg" alt="">

                            <div class="caption">
                                <h5><a href="#">Second Product</a>
                                </h5>

                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing
                                    elit.</p>
                            </div>
                            <div class="ratings">
                                <!--<p class="pull-right">12 reviews</p>-->
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4 col-sm-4">
                        <div class="thumbnail">
                            <img src="/resources/i/page-1_img02_original.jpg" alt="">

                            <div class="caption">
                                <h5><a href="#">Second Product</a>
                                </h5>

                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing
                                    elit.</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">12 reviews</p>

                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 col-lg-4 col-md-4 col-sm-4">
                        <div class="thumbnail">
                            <img src="/resources/i/page-1_img02_original.jpg" alt="">

                            <div class="caption">
                                <h5><a href="#">Third Product</a>
                                </h5>

                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing
                                    elit.</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">12 reviews</p>

                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</#macro>