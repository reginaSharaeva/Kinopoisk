<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "../template/template.ftl">
<#macro m_body>
    <div id="main">
        <div class="cabinet-title">
            <span>Личный кабинет</span>
        </div>
        <a href="/cabinet/change"><input type="submit" value="Настройки"></a>
        <span class="cabinet-user">Пользователь: ${currentUser.name}</span>
    </div>
</#macro>