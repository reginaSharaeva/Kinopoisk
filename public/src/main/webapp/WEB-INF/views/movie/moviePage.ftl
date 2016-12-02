<#include "../template/template.ftl">
<@mainTemplate title="" />
<#macro m_body>
<div class="container well-md">
    <div class="col-lg-4 col-md-4 col-xs-4">
        <div class="movie_image">
            <span class="movie_rating">5.0</span>
            <img src="/resources/i/iphone360_681503.jpg" class="img-responsive" alt="������ �� ���������">
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
            <div class="panel-heading">Шпионы по соседству</div>
            <table class="table info">
                <tbody>
                <tr>
                    <td>год</td>
                    <td>
                        <div>
                            <a href="#">2016</a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>страна</td>
                    <td>
                        <div>
                            <a href="#">США</a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>актёры</td>
                    <td><a href="#">Грег Моттола</a></td>
                </tr>
                <tr>
                    <td>режиссер</td>
                    <td><a href="#">Грег Моттол</a></td>
                </tr>
                <tr>
                    <td>��������</td>
                    <td><a href="#">����� ������</a></td>
                </tr>
                <tr>
                    <td>����</td>
                    <td>
                        <span><a href="#">������</a>, <a href="#">�������</a></span>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <p>Супружеская пара из пригорода оказывается втянутой в международный шпионский заговор,
            когда обнаруживает, что их, казалось бы, идеальные новые соседи являются правительственными
            агентами.</p>
    </div>
</div>
<div class="container com">
    <div class="comments-section-head-text">
        <h3>25 Comments</h3>
    </div>
    <div class="clearfix"></div>
    <div class="comments-section-grids">
        <div class="comments-section-grid">
            <div class="col-md-2 comments-section-grid-image">
                <img src="/resources/i/eye-brow.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-10 comments-section-grid-text">
                <h4><a href="#">MARWA ELGENDY</a></h4>
                <label>5/4/2014 at 22:00 </label>

                <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was
                    born and I will give you a complete account of the system, and expound but because those who do
                    not know how to pursue pleasure rationally encounter consequences.</p>

            </div>
            <div class="clearfix"></div>
        </div>
        <div class="comments-section-grid">
            <div class="col-md-2 comments-section-grid-image">
                <img src="/resources/i/stylish.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-10 comments-section-grid-text">
                <h4><a href="#">MARWA ELGENDY</a></h4>
                <label>5/4/2014 at 22:00 </label>

                <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was
                    born and I will give you a complete account of the system, and expound but because those who do
                    not know how to pursue pleasure rationally encounter consequences.</p>

            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="reply-section">
        <h3>Leave Reply</h3>

        <div class="clearfix"></div>
    </div>
    <div class="container comts">
        <form method="post" action="#">
            <div class="to">
                <input type="text" class="text" value="Name" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Name';}">
                <input type="text" class="text" value="Email" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Email';}" style="margin-left:3%">
            </div>
            <div class="text">
                    <textarea value="Message:" onfocus="this.value = '';"
                              onblur="if (this.value == '') {this.value = 'Message';}">Message:</textarea>
            </div>
            <div class="form-submit1">
                <input name="submit" type="submit" id="submit" value="Submit Your Message"><br>
            </div>
            <div class="clearfix"></div>
        </form>
    </div>
</div>
</#macro>