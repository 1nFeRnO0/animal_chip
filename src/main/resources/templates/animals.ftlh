<!DOCTYPE html>
<html>
<head>
    <title>Chips</title>
</head>
<body>
<H1>Animal Chip</H1><hr>
<H4>Виды, имеющиеся в наибольшем количестве</H4>
<#list animals as animal>
    <div>
        <p><b>${animal.animalSpecie}</b> ${animal.animalType}</p>
    </div>
</#list>
</body>
</html>