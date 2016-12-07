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
                                            <#list movieList as movie>
                                                <#if movie_index<=3>
                                                    <div class="owl-item active"
                                                         style="width: 270px; margin-right: 30px;">
                                                        <div class="owl-item">
                                                            <a href="${movie.getImg()}" class="thumb mfp-image">
                                                                <img src="${movie.getImg()}" alt="">
                                                                <span class="thumb__overlay"></span>
                                                            </a>
                                                            <h5><a href="/movie/${movie.getId()}"
                                                                   class="text-secondary">${movie.getName()}</a></h5>
                                                        </div>
                                                    </div>
                                                </#if>
                                            </#list>
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

                <div class="col-xs-12 col-md-6 col-md-push-2 offset-2 text-md-right">
                    <a href="/movie" class="btn btn-sm btn-default">View all movies</a>
                </div>
            </div>
        </div>
    </section>
    <!-- END Featured movies -->

    <!-- Highest rated videos
    <section class="well-xs">
        <div class="container">
            <h3>Highest rated videos</h3>

            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <div class="relative bg-grayscale-darken">
                        <a href="/movie/1" class="product">
                            <div class="rating rating-md rating-4">
                                <img src="/resources/i/page-1_img05.jpg" alt="" width="570" height="340">
                            </div>

                            <div class="product__meta">
                                <p class="text-primary">Sci-Fi</p>

                                <p class="big">After Earth (2015)</p>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="col-xs-6 col-md-3 offset-2">
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="/movie/1" class="product">
                                <div class="rating rating-sm rating-4">
                                    <img src="/resources/i/page-1_img06.jpg" alt="" width="270" height="160">
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 offset-3">
                            <a href="/movie/1" class="product">
                                <div class="rating rating-sm rating-4">
                                    <img src="/resources/i/page-1_img08.jpg" alt="" width="270" height="160">
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-md-3 offset-2">
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="/movie/1" class="product">
                                <div class="rating rating-sm rating-4">
                                    <img src="/resources/i/page-1_img07.jpg" alt="" width="270" height="160">
                                </div>
                            </a>
                        </div>

                        <div class="col-xs-12 offset-3">
                            <a href="/movie/1" class="product">
                                <div class="rating rating-sm rating-4">
                                    <img src="/resources/i/page-1_img09.jpg" alt="" width="270" height="160">
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>-->
    <!-- END Highest rated videos -->

    <!-- Coming soon
    <section class="well-xs">
        <div class="container">
            <h3>Coming soon</h3>

            <div class="row">
                <div class="owl-carousel col-xs-12 owl-theme owl-loaded" data-lightbox="gallery" data-items="1"
                     data-xs-items="2" data-sm-items="3" data-md-items="6" data-margin="20" data-sm-margin="30"
                     data-stage-padding="30" data-xs-stage-padding="45" data-md-stage-padding="0" data-loop="false">
                    <div class="owl-stage-outer">
                        <div class="owl-stage"
                             style="transform: translate3d(0px, 0px, 0px); transition: 0s; width: 400px;">
                            <div class="owl-item active" style="width: 170px; margin-right: 30px;">
                                <div class="owl-stage-outer">
                                    <div class="owl-stage"
                                         style="transform: translate3d(0px, 0px, 0px); transition: 0s; width: 1200px;">
                                        <div class="owl-item active" style="width: 170px; margin-right: 30px;">
                                            <div class="owl-item">
                                                <a href="/resources/i/page-1_img10_original.jpg"
                                                   data-lightbox="image" class="thumb mfp-image">
                                                    <img src="/resources/i/page-1_img10.jpg" alt="" width="170" height="220">
                                                    <span class="thumb__overlay"></span>
                                                </a>

                                                <p class="heading-6"><a
                                                        href="/movie/1"
                                                        class="text-secondary">The dark knight (2016)</a></p>
                                            </div>
                                        </div>
                                        <div class="owl-item active" style="width: 170px; margin-right: 30px;">
                                            <div class="owl-item">
                                                <a href="/resources/i/page-1_img11_original.jpg"
                                                   data-lightbox="image" class="thumb mfp-image">
                                                    <span class="thumb__overlay"></span>
                                                </a>

                                                <p class="heading-6"><a
                                                        href="/movie/1"
                                                        class="text-secondary">The hunger games (2016)</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="owl-item active" style="width: 170px; margin-right: 30px;">
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
    </section>-->
    <!-- END Coming soon -->
</main>
</#macro>