<#include "../template/template.ftl">
<@mainTemplate title="" />
<#macro m_body>
<div class="container well-md">
    <div class="col-lg-3 col-md-3 col-xs-3">
        <div class="movie_image">
            <img src="/resources/i/iphone360_415350.jpg" class="img-responsive" alt="Дени Вильнёв">
        </div>
    </div>
    <div class="col-lg-6 col-md-6 col-xs-6">
        <div class="panel panel-default">
            <div class="panel-heading">Дени Вильнёв</div>
            <table class="table info">
                <tbody>
                <tr>
                    <td>карьера</td>
                    <td><a href="#director">Режиссер</a>,
                        <a href="#writer">Сценарист</a>,
                        <a href="#actor">Актер</a>,
                        <a href="#editor">Монтажер</a>,
                        <a href="#operator">Оператор</a></td>
                </tr>
                <tr>
                    <td class="type">дата рождения</td>
                    <td>
                        3 октября,
                        1967 49 лет
                    </td>
                </tr>
                <tr>
                    <td>фильмы</td>
                    <td>
                        Прибытие
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-xs-3">
        <div class="panel panel-default">
            <div class="panel-heading">Награды</div>
            <table class="table info">
                <thead>
                <tr>
                    <td>год</td>
                    <td>номинация</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>2016</td>
                    <td>Лучший актёр</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</#macro>