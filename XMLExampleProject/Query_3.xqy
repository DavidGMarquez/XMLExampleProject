<html>
<body>

<h1>Bookstore</h1>

<ul>
{
for $x in doc("Biblioteca.xml")/Biblioteca/libro
order by $x/titulo
return <li class="{data($x/@categoria)}">{data($x/titulo)}</li>
}
</ul>

</body>
</html>