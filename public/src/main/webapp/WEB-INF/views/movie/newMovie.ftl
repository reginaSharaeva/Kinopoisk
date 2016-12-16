<#include "../template/template.ftl">
<@mainTemplate title="New movie" />
<#macro m_body>
<div class="container well-md">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-xs-4">
            <div class="movie_image" style="    border: none;">
                <form enctype="multipart/form-data" method="post">
                    <p>Загрузить фото </p>

                    <p><input type="file" name="photo" multiple accept="image/*,image/jpeg">
                </form>
            </div>
        </div>
        <div class="col-lg-8 col-md-8 col-xs-8">
            <div class="panel panel-default">
                <table class="table info">
                    <tbody>
                    <tr>
                        <td>Возраст</td>
                        <td><input type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Продолжительность</td>
                        <td><input type="text" class="form-control">
                    </tr>
                    <tr>
                        <td>год</td>
                        <td>
                            <input type="text" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>жанры</td>
                        <td>
                            <input type="text" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>страна</td>
                        <td>
                            <input type="text" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>актёры</td>
                        <td><input type="text" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>режиссер</td>
                        <td>
                            <input type="text" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>режиссер</td>
                        <td>
                            <input type="text" class="form-control">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <p>Описание:</p>

            <p><input type="text" class="form-control"></p>
        </div>
    </div>
    <div class="row">
        <a href="#" class="btn btn-xs btn-primary">Добавить фильм</a>
    </div>
</div>
</#macro>