<#-- @ftlvariable name="movie" type="com.itis.dz.entities.Movie" -->
<#include "../template/template.ftl">
<@mainTemplate title="" />
<#macro m_body>
<div class="container well-md">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-xs-4">
            <div class="movie_image">
                <img src="${movie.getImg()}" class="img-responsive" alt="${movie.getName()}">

                <form enctype="multipart/form-data" method="post">
                    <p>Сменить фото </p>

                    <p><input type="file" name="photo" multiple accept="image/*,image/jpeg">
                </form>
            </div>
        </div>
        <div class="col-lg-8 col-md-8 col-xs-8">
            <div class="panel panel-default">
                <div class="panel-heading"><input type="text" class="form-control" value="${movie.getName()}"></div>
                <table class="table info">
                    <tbody>
                    <tr>
                        <td>Возраст</td>
                        <td><input type="text" class="form-control" value="${movie.getAge()}"></td>
                    </tr>
                    <tr>
                        <td>Продолжительность</td>
                        <td><input type="text" class="form-control" value="${movie.getTime()}"></td>
                    </tr>
                    <tr>
                        <td>год</td>
                        <td>
                            <input type="text" class="form-control" value="${movie.year}">
                        </td>
                    </tr>
                    <tr>
                        <td>жанры</td><#assign x=false>
                        <td><input type="text" class="form-control" value="<#list movie.genres as genre><#if x==true>,</#if>${genre.name}<#assign x=true></#list>">
                        </td>
                    </tr>
                    <tr>
                        <td>страна</td>
                        <td><input type="text" class="form-control" value="${movie.country.name}">

                        </td>
                    </tr>
                    <tr>
                        <td>актёры</td><#assign x=false>
                        <td><input type="text" class="form-control" value="<#list movie.persons as person><#list person.roles as role><#if role.name=="Актер"><#if x==true>,</#if>${person.secondName} ${person.firstName} ${person.lastName}<#assign x=true></#if></#list></#list>">
                        </td>
                    </tr>
                    <tr>
                        <td>режиссер</td><#assign x=false>
                        <td><input type="text" class="form-control" value="<#list movie.persons as person><#list person.roles as role><#if role.name=="Режиссер"><#if x==true>,</#if>${person.secondName} ${person.firstName} ${person.lastName}<#assign x=true></#if></#list></#list>">

                        </td>
                    </tr>
                    <tr>
                        <td>режиссер</td> <#assign x=false>
                        <td><input type="text" class="form-control" value="<#list movie.persons as person><#list person.roles as role><#if role.name=="Сценарист"><#if x==true>,</#if>${person.secondName} ${person.firstName} ${person.lastName}<#assign x=true></#if></#list></#list>">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <p><input type="text" class="form-control" value="${movie.description}"></p>
        </div>
    </div>
    <div class="row">
        <a href="#" class="btn btn-xs btn-primary">Сохранить изменения</a>
    </div>
</div>
</#macro>