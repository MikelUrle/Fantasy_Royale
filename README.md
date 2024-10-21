# Fantasy_Royale
Proyecto personal de un fantasy creado por Mikel, con una lógica aleatoria en partidos, resultados y asignación de goles y asistencias

# Tecnologias

· HTML 5

· CSS 3

· JavaScript

· Java

· Spring Boot

# Manual de uso

· Descargar java (Recomendable una version superior a 1.8.0_421)

· Descargar Spring Boot (En mi caso recomiendo el eclipse adaptado a este (https://spring.io/tools))

· Ejecutar la sql que esta en el proyecto desde, en mi caso, utilizando MySQL Workbench

· Tendremos que crear un proyecto nuevo, recomendable con java 17, type Maven y con las librerias de "Spring Boot DevTools" / "Spring Data JPA" / MySQL Driver / Thymeleaf / Spring Web

· Dentro de resources/aplication.properties, tendremos que añadir las lineas del usuario y contraseña de la base de datos que tengamos, sumandole tambien el nombre de la base de datos en el caso qeu le hayamos cambiado el nombre a otro

· Por ultimo importaremos el proyecto y copiaremos los archivos de su interior con el mismo formato de carpetas que hayamos puesto

· Para tener un ejemplo, el mio seria, dentro de src/main/java estarian los paquetes, con el padre y debajo el de controler / model / repository / service (donde habria que copiar los archivos del proyecto), despues estaria el src/main/resources donde estarian "estatic" para las imagenes y los styles, y templates para los archivos html.
