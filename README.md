# Prueba Tecnica

## Como ejecutar la aplicacion:
Asegurate de tener instalado:
* Java 21 JDK
* Maven

1. Clona el repostorio <pre> ```git clone https://github.com/albhernandezag/Prueba-Tecnica-Alberto-Hernandez.git``` </pre>

2. Compila el proyecto <pre> ```mvn clean install``` </pre>

3. Ejecuta la aplicación
Para ejecutar la aplicación utiliza el comando <pre>```mvn spring-boot:run```</pre>
La aplicación se levantará en el puerto 8080 <pre>```http://localhost:8080```</pre>

## ENDPOINT GET /prices:
Para comprobar que el endpoint funciona puedes ir a: <pre>```http://localhost:8080/prices?brandId=1&productId=35455&applicationDate=2020-06-14-16.00.00```</pre>
Este endpoint acepta como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.

Y devuelve como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

## TEST
Para ejecutar los test utiliza el comando <pre>```mvn test```</pre>

## BASE DE DATOS
* Se utiliza H2 en memoria
* La estructura se define en schema.sql 
* Los datos iniciales están en data.sql
* No es necesaria configuración externa

La consola H2 se puede activar en <pre>```http://localhost:8080/h2-console```</pre>
Para acceder a la consola, usuario "sa", sin contraseña
