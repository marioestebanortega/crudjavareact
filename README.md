### Este proyecto corresponde a la prueba técnica del Departamento Administrativo del Servicio Civil Distrital  

## Componente BackEnd (Java, Spring boot , Tomcat)

### Importante: Ya que es un servicio springboot el contenedor WEB esta inmerso en el .jar, en este caso ya está inmerso un tomcat con ayuda de la tecnología spring boot para el despliegue del backend. Ademas usa JDK 1.8 y Maven por lo cual estas dos deben estar instaladas

### Instalación

### ir a la carpeta ./backend y ejecutar el siguiente comando:
### `mvn clean install -Dmaven.test.skip `
### `java -jar target/comsiontest-0.0.1-SNAPSHOT.jar`
### Este último comando corre la aplicacion y la despiega gracias a Springboot y tomcat (!!!IMPORTANTE NO CERRAR LA CONSOLA!!!)

### Este componente situado en la carpeta ./backend contiene un proyecto basado en Spring boot de java (Java, Spring, SpringData, Servicios Rest) con 4 servicios Rest para las operaciones crud:

### Servicio Post guardar
### `http://localhost:8095/api/guardarPersona`

### Servicio Post editar
### `http://localhost:8095/api/editarPersona`

### Servicio Post borrar
### `http://localhost:8095/api/borrarPersona`

### Servicio get consultar todas las personas
### `http://localhost:8095/api/obtenerPersonas`


### Servicio get consultar tipos de documento
### `http://localhost:8095/api/obtenerTiposDocumento`


### La Api se expone por el puerto 8095 (Configuración application.properties)

### Se instaló una base de datos en memoria H2 para las transacciones del CRUD

## Componente FrontEnd (React, Css y Javascript)

### Importante: Se usa React, CSS y javascript para la ejecución de un frontend. Importante debe estar instalado node para la ejecución de este front

### Instalación

### En una nueva consola (Importante no cerrar la consola del backend) ir a la carpeta ./frontend y ejecutar el siguiente comando

### `npm install`  Este comnado puede demorar un tiempo
### `npm run start`

### Una vez se ejecuten los comandos se puede ingresar a la aplicación en el siguiente link:
### `http://localhost:3010/`

