<!DOCTYPE html>
<html>
<head>
    <title>FURRYFINDER</title>
</head>
<body>
<h1>FURRYFINDER</h1><hr>
<h4>Подробная информация о животном</h4>
<#list images as image>
    <img src="/images/${image.id}" height="60px" alt="MISSING JPG"/><br><br>
</#list>
<b>Вид животного: </b>${animal.type}<br>
<b>Кличка: </b>${animal.name}<br>
<b>Название ветклиники: </b>${animal.point}<br>
<b>Описание: </b>${animal.description}<br>
<hr>
<form action="/animal/delete/${animal.id}" method="post"> 
    <input type="submit" value="Удалить карточку"/>
</form>
</body>
</html>