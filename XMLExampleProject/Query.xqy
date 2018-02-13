for $x in doc("Biblioteca.xml")/Biblioteca/libro
where $x/precio>30
order by $x/titulo
return $x