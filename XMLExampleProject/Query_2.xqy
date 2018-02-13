for $x in doc("Biblioteca.xml")/Biblioteca/libro
return if ($x/@categoria="Children")
then <child>{data($x/titulo)}</child>
else <adult>{data($x/titulo)}</adult>