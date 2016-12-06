
<!DOCTYPE HTML>
<html>
<head>
    <title>Movies</title>
    <meta charset="UTF-8">

</head>
<body>

    <#list movieList as movie>
<h1>
${movie.getName()}
</h1>
    ${movie.getYear()}

        <#list  movie.getPersons() as person >
   <p>${person.getFirstName()}</p>
         </#list>

    </#list>


</body>
</html>
