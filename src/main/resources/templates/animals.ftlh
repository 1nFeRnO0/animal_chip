<!DOCTYPE html>
<html>
<head>
    <title>FURRYFINDER</title>
</head>
<body>
<h1>FURRYFINDER</h1><hr>
<h4>Найди себе питомца</h4>
<form action="/" method="get">
    Поиск по типу животного: <input type="text" name="type"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list animals as animal>
    <div>
        <p><b>${animal.type}</b> ${animal.name} | <a href="/animal/${animal.id}">Подробнее….</a></p>
    </div>
    <#else>
    <h3>Животных нет</h3>
</#list>
<hr>
<h3>Создать карточку животного</h3>
<form action="/animal/create" method="post" enctype="multipart/form-data">
    Тип животного: <input type="text" name="type"/><br><br>
    Кличка: <input type="text" name="name"/><br><br>
    Название ветклиники: <input type="text" name="point"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить карточку"/>
</form>
</body>
</html>