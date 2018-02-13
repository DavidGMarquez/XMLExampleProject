for $x at $i in doc("Biblioteca.xml")/Biblioteca/libro/titulo
return <libro>{$i}. {data($x)}</libro>