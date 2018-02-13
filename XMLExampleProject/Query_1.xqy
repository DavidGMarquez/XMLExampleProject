<ul>
{
for $x in doc("Biblioteca.xml")/Biblioteca/libro/autor
order by $x
return <li>{$x}</li>
}
</ul>