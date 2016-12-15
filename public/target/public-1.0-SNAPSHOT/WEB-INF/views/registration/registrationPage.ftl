<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Регистрация"/>
<#macro m_body>
<div class="container well-md">
    <div class="row">
    <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form">
                <h3 class="form-signin-heading">Please Sign Up <small>It's free and always will be.</small></h3>
                <hr class="colorgraph">
                <div class="form-group">
                    <span>NickName<label>*</label></span>
                        <@form.input cssClass="form-control input-lg" path="name"/>
                        <@form.errors path="name" cssStyle="color: red;" />
                        <p class="help-block">Введите имя (имя может содержать любые символы кроме пробела)</p>
                </div>
                <div class="form-group">
                    <span>E-Mail<label>*</label></span>
                    <@form.input cssClass="form-control input-lg" path="email"/>
                    <@form.errors path="email" cssStyle="color: red;" />
                    <p class="help-block">Введите Ваш E-Mail</p>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <span>Password<label>*</label></span>
                            <@form.password cssClass="form-control input-lg" path="password" />
                            <@form.errors path="password" cssStyle="color: red;" />
                            <p class="help-block">Введите пароль (пароль должен содержать не менее 7 символов)</p>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <span>Confirm Password<label>*</label></span>
                            <@form.password cssClass="form-control input-lg" path="confirmPassword" />
                            <@form.errors path="confirmPassword" cssStyle="color: red;" />
                            <p class="help-block">Подтвердите пароль</p>
                        </div>
                    </div>
                </div>
                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
                    <div class="col-xs-12 col-md-6"><a href="/login" class="btn btn-success btn-block btn-lg">Sign In</a></div>
                </div>
            </form>
        </div>
    </@form.form>
        <#if contains?has_content>
            <span style="color: red"> Возможно Вы уже регистрировались по этому E-Mail</span>
        </#if>
    </div>
</div>
</#macro>

