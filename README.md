
# Validación de formularios

Este es un ejemplo de la implementación de validaciones a nivel interfaz de usuario y nivel servicio. Buenas prácticas de cómo prevenir errores de usuario en el registro de datos a través de formularios.

# Librerías:

### Back-end:
spring-boot-starter-data-jpa\
spring-boot-starter-data-rest\
spring-boot-starter-web\
spring-boot-devtools\
spring-boot-configuration-processor\
lombok\
spring-boot-starter-test\
mysql-connector-java\
spring-boot-starter-validation

### Front-end:

vue-bootstrap\
axios\
vuelidate

# Requisitos

Java SDK 17 o superior.\
Nodejs 20.11.1\
npm 10.50

# Datos

Text: De 10 a 20 caracteres sin espacios en blanco al inicio o al final, o que el contenido entero sean espacios en blanco.

Card number: Solo 16 números sin espacios.

RFC: Formato de rfc especificado
[aquí](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwjspcy9seaEAxUYlu4BHUhUBkEQFnoECBAQAQ&url=https%3A%2F%2Fwww.sat.gob.mx%2Fcs%2FSatellite%3Fblobcol%3Durldata%26blobkey%3Did%26blobtable%3DMungoBlobs%26blobwhere%3D1461175045755%26ssbinary%3Dtrue&usg=AOvVaw2fUKrURceighjcMUGiXZYQ&opi=89978449)

CURP: Formato explicado [aquí](https://conecta.tec.mx/es/noticias/nacional/emprendedores/que-es-la-curp-descubre-como-se-conforma-y-para-que-sirve#:~:text=“Es%20un%20código%20alfanumérico%20de,vive%20en%20México”%2C%20destaca.)

Email: Dirección de email válida ejemplo: nombre@domino.do

Number: Número de 10 a 30.

Date: Fecha de nacimento mayor a 18 años.

