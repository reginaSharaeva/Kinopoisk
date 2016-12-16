<#-- @ftlvariable name="comment" type="com.itis.dz.entities.Comment" -->
<div class="comments-section-grid">

    <div class="col-md-10 comments-section-grid-text">
         <label>${comment.date.get(5)}/${comment.date.get(2)}/${comment.date.get(1)}
         at ${comment.date.get(11)}:<#if comment.date.get(12) lt 10>0</#if>${comment.date.get(12)}</label>
        <p>${comment.text}</p>
    </div>
    <div class="clearfix"></div>
</div>