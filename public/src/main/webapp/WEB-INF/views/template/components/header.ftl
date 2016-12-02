<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<header class="page-header">
    <!-- RD Navbar -->
    <div class="rd-navbar-wrap" style="height: 70px;">
        <nav class="rd-navbar rd-navbar--is-stuck rd-navbar-static" data-rd-navbar-lg="rd-navbar-static">
                <!-- RD Navbar Panel -->
                <div class="col-lg-2 col-md-2 col-xs-2">
                    <div class="rd-navbar-panel">
                        <!-- RD Navbar Toggle -->
                        <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar"><span></span></button>
                        <!-- END RD Navbar Toggle -->

                        <!-- RD Navbar Brand -->
                        <div class="rd-navbar-brand">
                            <a href="/" class="brand-name">
                                Online Movies
                            </a>
                        </div>
                        <!-- END RD Navbar Brand -->
                    </div>
                    <!-- END RD Navbar Panel -->
                </div>
                <div class="col-lg-10 col-md-10 col-xs-10">
                    <div class="rd-navbar-nav-wrap menu">
                        <!-- RD Navbar Nav -->
                        <ul class="rd-navbar-nav">
                            <li class="active rd-navbar--has-megamenu rd-navbar-submenu">
                                <a href="/">Home</a>
                                <!-- RD Navbar Megamenu -->
                                <ul class="rd-navbar-megamenu">

                                    <li>
                                        <h3>Top 4 Movies</h3>
                                    </li>

                                    <li>
                                        <div class="rating rating-sm">
                                            <img src="/resources/i/megamenu_img01.jpg" alt="" width="250" height="160">
                                        </div>
                                        <h5><a class="text-secondary" href="/">The Expanse (2015)</a></h5>
                                        <ul class="list-variant-1">
                                            <li>
                                                <span class="text-primary">Description: </span>
                                                The crew of the Rocinante discovers a derelict vessel which holds
                                                a
                                                secret that may be devastating to human existence.
                                            </li>
                                        </ul>
                                        <a href="#" class="btn btn-sm btn-default">Read more</a>
                                    </li>
                                    <li>
                                        <div class="rating rating-sm">
                                            <img src="/resources/i/megamenu_img02.jpg" alt="" width="250" height="160">
                                        </div>
                                        <h5><a class="text-secondary" href="#">CSI: Cyber (2015)</a></h5>
                                        <ul class="list-variant-1">
                                            <li>
                                                <span class="text-primary">Description: </span>
                                                Special agent Avery Ryan works to solve crimes as
                                                a CyberPsychologist for the
                                                FBI.
                                            </li>
                                        </ul>
                                        <a href="#"
                                           class="btn btn-sm btn-default">Read more</a>
                                    </li>
                                    <li>
                                        <div class="rating rating-sm">
                                            <img src="/resources/i/megamenu_img03.jpg" alt="" width="250" height="160">
                                        </div>
                                        <h5><a class="text-secondary"
                                               href="#">Into the Badlands
                                            (2015)</a></h5>
                                        <ul class="list-variant-1">
                                            <li>
                                                <span class="text-primary">Description: </span>
                                                A mighty warrior and a young boy search for enlightenment in a
                                                ruthless
                                                territory controlled by feudal barons.
                                            </li>
                                        </ul>
                                        <a href="#"
                                           class="btn btn-sm btn-default">Read more</a>
                                    </li>
                                    <li>
                                        <div class="rating rating-sm">
                                            <img src="/resources/i/megamenu_img04.jpg" alt="" width="250" height="160">
                                        </div>
                                        <h5><a class="text-secondary"
                                               href="#">The Affair
                                            (2014)</a></h5>
                                        <ul class="list-variant-1">
                                            <li>
                                                <span class="text-primary">Description: </span>
                                                The psychological effects of an affair between a married
                                                waitress at
                                                a
                                                Hamptons
                                            </li>
                                        </ul>
                                        <a href="http://livedemo00.template-help.com/wt_57702/#"
                                           class="btn btn-sm btn-default">Read more</a>
                                    </li>
                                </ul>
                                <!-- END RD Navbar Megamenu -->
                                <span class="rd-navbar-submenu-toggle"></span>
                                <span class="rd-navbar-submenu-toggle"></span></li>
                            <li class="rd-navbar--has-dropdown rd-navbar-submenu">
                                <a href="#">New Releases</a>
                                <!-- RD Navbar Dropdown -->
                                <ul class="rd-navbar-dropdown">
                                    <li>
                                        <a href="#">Our Mission</a>
                                    </li>
                                    <li class="rd-navbar--has-dropdown rd-navbar-submenu">
                                        <a href="#">Genres</a>
                                        <!-- RD Navbar Dropdown -->
                                        <ul class="rd-navbar-dropdown">
                                            <li>
                                                <a href="#">Drama</a>
                                            </li>
                                            <li>
                                                <a href="#">Comedy</a>
                                            </li>
                                            <li>
                                                <a href="#">Horror</a>
                                            </li>
                                        </ul>
                                        <!-- END RD Navbar Dropdown -->
                                        <span class="rd-navbar-submenu-toggle"></span><span
                                            class="rd-navbar-submenu-toggle"></span>
                                    </li>
                                </ul>
                                <!-- END RD Navbar Dropdown -->

                                <span class="rd-navbar-submenu-toggle"></span>
                                <span class="rd-navbar-submenu-toggle"></span>
                            </li>
                            <li>
                                <a href="#">Most Popular</a>
                            </li>
                            <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                                <li><a class="login" href="/login">Sign in</a></li>
                                <li><a class="login" href="/reg">Sign up</a></li>
                            </@sec.authorize>

                            <#-- Если уже авторизован, то ссылки в личный кабинет и на выход -->
                            <@sec.authorize access="isAuthenticated()">

                                <li>
                                    <a class="login" href="/cabinet">
                                        <@sec.authentication property="principal.username" />
                                    </a>
                                </li>
                                <li><a class="login" href="/logout">Sign out</a></li>
                            </@sec.authorize>

                        </ul>
                        <!-- END RD Navbar Nav -->
                    </div>
                <!-- RD Navbar Search -->
                <div class="rd-navbar-search-wrap">
                    <div class="rd-navbar-search">
                        <form class="rd-navbar-search-form" action="#" method="GET">
                            <div class="input-group">
                                <input type="text" id="search" class="form-control" placeholder="Search for...">

      <span class="input-group-btn">
        <button class="btn btn-default" type="button"><i class="fa fa-search" aria-hidden="true"></i></button>
      </span>
                            </div>
                            <!-- /input-group -->


                            <!--
                               <label class="rd-navbar-search-form-input">
                                   <input type="text" name="s" placeholder="search" autocomplete="off">
                               </label>
                               <button class="rd-navbar-search-form-submit" type="submit"><i
                                       class="material-icons"></i>
                               </button>-->
                        </form>
                        <span class="rd-navbar-live-search-results"></span>
                        <button class="rd-navbar-search-toggle" data-rd-navbar-toggle=".rd-navbar-search"></button>
                    </div>
                </div>

                </div>
                <!-- END RD Navbar Search -->
        </nav>
    </div>
    <!-- END RD Navbar -->
</header>