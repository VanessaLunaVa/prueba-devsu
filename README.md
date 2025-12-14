# prueba-devsu

Para dar solución a la prueba Java 

## Backend -- Java
Lo realice usando el IDE Intellij 2025.2 Community Edition. Es un proyecto gradle, version de java 21 y he usado Docker Desktop.
## Deployment
En la raiz del proyecto se encuentra un docker-compose.yaml para levantar los dos microservicios y levantar kafka. 
Si el proyecto es clonado desde este repositorio, se deben ejecutar los comandos clean build en cada proyecto para generar los .jar y luego si correr el docker.

Tambien se encuentra un archivo .json que lo genere con postman Collection v2.1 con los endpoint disponibles para las pruebas.

Las url quedan asi:
cliente-persona = localhost:8081/cliente
movimiento-cuenta = localhost:8082/cuenta  --- localhost:8082/movimiento
kafka queda por el 9092
No se utiliza localhost para comunicación interna entre contenedores.

## Comentarios
He usado en ambos proyectos arquitectura microservicios y arquitectura hexagonal.
Para la base de datos use H2
Para la comunicacion asincrona use Apache kafka y Spring kafka

Para el evento asincrono, use el eliminar de cliente, para que cuando se elimine un cliente se publique el evento cliente-eliminado y la cuenta cuando escuche este evento, actualice el estado de las cuentas del cliente a CANCELADA.


👤 Autor
Vanessa Luna
Prueba técnica – Desarrollo Backend
