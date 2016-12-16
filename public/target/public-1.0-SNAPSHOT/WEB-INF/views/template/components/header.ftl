<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<header class="page-header">
    <!-- RD Navbar -->
    <div class=rd-navbar-wrap" style="height: 70px;">
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
                            <a href="/">Главная</a>
                            <span class="rd-navbar-submenu-toggle"></span>
                            <span class="rd-navbar-submenu-toggle"></span></li>
                        <li>
                            <a href="/mostpopular">Самые популярные</a>
                        </li>
                    <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                        <li><a class="login" href="/login">Войти</a></li>
                        <li><a class="login" href="/reg">Зарегистрироваться</a></li>
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
        </nav>
    </div>
    <!-- END RD Navbar -->
</header>