<!DOCTYPE html>
<html>
<head>
    <title>FurryFinder</title>
</head>
<body>
<h1>FURRYFINDER</h1><hr>
<h4>Найди себе питомца</h4> 
<form action="/" method="get">
    Поиск по кличке: <input type="text" name="name"><br> 
    <input type="submit" value="Поиск"/>
</form>
<#list animals as animal>
    <div>
        <p><b>${animal.type}</b> ${animal.name} | <a href="/animal/${animal.id}">Подробнее…</a></p>
    </div>
    <#else>
    <h3>Животных нет</h3>
</#list>
<hr>
<h3>Создать новую карточку</h3>
<form action="/animal/create" method="post">
    Вид животного: <input type="text" name="type"/><br><br>
    Кличка: <input type="text" name="name"/><br><br> 
    Название ветклиники: <input type="text" name="point"/><br><br> 
    Описание: <input type="text" name="description"/><br><br>  
    <input type="submit" value="Добавить карточку"/>
</form>
</body>
</html>