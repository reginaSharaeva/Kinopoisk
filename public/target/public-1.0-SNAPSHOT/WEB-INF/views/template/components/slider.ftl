<section class="bg-default-variant-1">
    <div class="swiper-layout">
        <div class="swiper-container swiper-container--overflow-caption swiper-slider swiper-container-horizontal"
             data-height="41.875%" data-min-height="300px" data-autoplay="false" style="height: 564.894px;">

            <div class="swiper-wrapper"
                 style="transition-duration: 0ms; transform: translate3d(-1349px, 0px, 0px);">

<#list movies as movie>
    <#if movie_index==5>
                <div class="swiper-slide swiper-slide-duplicate swiper-slide-prev"
                     data-slide-bg="${movie.getImg()}"
                     style="background-image: url(&quot;${movie.getImg()}&quot;); background-size: cover; width: 1349px;"
                     data-swiper-slide-index="2">
                    <div class="swiper-slide-caption container">
                        <div class="swiper-slide-caption_box">

                            <h2>${movie.getName()}</h2>

                            <p class="big">${movie.getDescription()}</p>

                            <p>
                                <a href="/movie/${movie.getId()}"
                                   class="btn btn-xs btn-primary">Read more</a>
                            </p>
                        </div>
                    </div>
                </div>
    </#if><#if movie_index==1 >
                <div class="swiper-slide swiper-slide-active" data-slide-bg="${movie.getImg()}"
                     style="background-image: url(&quot;${movie.getImg()}&quot;); background-size: cover; width: 1349px;"
                     data-swiper-slide-index="0">
                    <div class="swiper-slide-caption container">
                        <div class="swiper-slide-caption_box">

                            <h2>${movie.getName()}</h2>

                            <p class="big">${movie.getDescription()}</p>

                            <p>
                                <a href="/movie/${movie.getId()}"
                                   class="btn btn-xs btn-primary">Read more</a>
                            </p>
                        </div>
                    </div>
                </div>
</#if>
    <#if movie_index gt 1 && movie_index lt 5>
                <div class="swiper-slide swiper-slide-next" data-slide-bg="${movie.getImg()}"
                     style="background-image: url(&quot;${movie.getImg()}&quot;); background-size: cover; width: 1349px;"
                     data-swiper-slide-index="1">
                    <div class="swiper-slide-caption container">
                        <div class="swiper-slide-caption_box">

                            <h2>${movie.getName()}</h2>

                            <p class="big">${movie.getDescription()}</p>

                            <p>
                                <a href="/movie/${movie.getId()}"
                                   class="btn btn-xs btn-primary">Read more</a>
                            </p>
                        </div>
                    </div>
                </div>
    </#if>
    <#if movie_index==5>
                <div class="swiper-slide" data-slide-bg="${movie.getImg()}"
                     style="background-image: url(&quot;${movie.getImg()}&quot;); background-size: cover; width: 1349px;"
                     data-swiper-slide-index="2">
                    <div class="swiper-slide-caption container">
                        <div class="swiper-slide-caption_box">

                            <h2>${movie.getName()}</h2>

                            <p class="big">${movie.getDescription()}</p>

                            <p>
                                <a href="/movie/${movie.getId()}"
                                   class="btn btn-xs btn-primary">Read more</a>
                            </p>
                        </div>
                    </div>
                </div>
    </#if>
    <#if movie_index==1>
                <div class="swiper-slide swiper-slide-duplicate" data-slide-bg="${movie.getImg()}"
                     style="background-image: url(&quot;${movie.getImg()}&quot;); background-size: cover; width: 1349px;"
                     data-swiper-slide-index="0">
                    <div class="swiper-slide-caption container">
                        <div class="swiper-slide-caption_box">

                            <h2>${movie.getName()}</h2>

                            <p class="big">${movie.getDescription()}</p>

                            <p>
                                <a href="/movie/${movie.getId()}"
                                   class="btn btn-xs btn-primary">Read more</a>
                            </p>
                        </div>
                    </div>
                </div>
    </#if>
</#list>
            </div>

            <!-- Swiper Navigation -->
            <div class="swiper-button-prev"><i class="fa fa-chevron-left" aria-hidden="true"></i></div>
            <div class="swiper-button-next"><i class="fa fa-chevron-right" aria-hidden="true"></i>
            </div>

        </div>
    </div>
</section>
<!-- END Swiper -->