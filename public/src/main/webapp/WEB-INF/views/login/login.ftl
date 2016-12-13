<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "../template/template.ftl">
<@mainTemplate title="Авторизация" />
<#macro m_body>
<div class = "container">
    <div class="wrapper">
        <#if error?has_content>
            <div style="color: red;">Ошибка! Пожалуйста проверьте Ваш e-mail и пароль!</div>
        </#if>
        <form action="/j_spring_security_check" method="post" name="authForm" id="authForm" class="form-signin">
            <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
            <hr class="colorgraph"><br>

            <div>
                <span>Email</span>
                <input type="text" class="form-control" name="j_username" required=""/>
            </div>
            <div>
                <span class="pass">Password</span>
                <input type="password" class="form-control" name="j_password" placeholder="Password" required=""/>
            </div>
            <div>
                <input id="remember_me" name="j_spring_security_remember_me" type="checkbox"/>
                <label for="remember_me" class="inline">Запомнить меня</label>
            </div>
            <a href="/"><input type="submit" value="Вход" class="btn btn btn-lg btn-primary btn-block"/></a>
            <a href="/reg" style="margin-left: 15px;">Зарегистрироваться</a>
        </form>
    </div>
</div>
</#macro>








