<#include "../template/template.ftl">
<@mainTemplate title="Home"/>
<#macro m_body>
    <#include "../template/components/slider.ftl">
<main class="page-content text-center text-md-left">
    <!-- Featured movies -->
    <div class="container-fluid">
        <div class="row row-md-bottom">
            <div class="col-xs-12 col-md-6 ">
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
                                         style="transform: translate3d(0px, 0px, 0px); transition: 0s; width: 1400px;">

                                        <div id="root"></div>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>


</main>
</#macro>