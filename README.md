# Spring-Body-Fitnes-Gym

## URL JSON

- Servicio de login

- /login/{usuario}/{contrasenia}   este devuelve un alumno, entrenador o admin, lo que encuentre primero con esas credenciales

- /login/alumno/{usuario}/{contrasenia}   login especifico para alumnos
- /login/admin/{usuario}/{contrasenia}    login especifico para admins
- /login/entrenador/{usuario}/{contrasenia} login especifico para entrenadores

- https://spring-body-fitness-gym.herokuapp.com/alumnos  Devuelve la lista de alumnos [GET]
- https://spring-body-fitness-gym.herokuapp.com/alumno/{ID} devuelve el alumno con el id {ID} [G]
- https://spring-body-fitness-gym.herokuapp.com/alumno Guarda un alumno con peticion [POST]
- https://spring-body-fitness-gym.herokuapp.com/alumno/{ID} Borrar una alumno de id {ID} con una peticion [DELET]
- https://spring-body-fitness-gym.herokuapp.com/alumno/todos Borrar todos los alumnos con una peticion [DELET]
-https://spring-body-fitness-gym.herokuapp.com/alumno Editar un alumno con una peticion [PUT]

- /servicios obtener todos los servicios
- /servicio/{ID} obtener el servicio con el {ID} con [GET], y para borrarlo con [DELET]
- /servicio para agregarlo [POST] o editarlo [PUT]

- /clases GET
 - /clase/{id} GET , DELET
- /clase/servicio/{idServicio}/entrenador/{idEntrenador} POST 

- /horarios GET
- /horario/filtro/{diaInicial}/{diaFinal} filtrar por dias (se tiene que ingresar la fecha con el formato completo
 - /horario/{id} GET , DELET
- /horario/clase/{idClase} POST 

- /entrenadores GET
- /entrenador/{id} GET , DELET
- /entrenador POST PUT

- /movimientos GET
- /movimientos/{filtro}/{fechaInicial}/{fechaFinal}     filtro puede ser igual a = "todos" o por tipo p.ej: "ingreso" o "egreso" y las fechas vienen en el formato establecido (yyyy-MM-dd HH:mm:ss)
- /movimiento/todos DELET borra todos
- /movimiento/{id} GET , DELET
- /movimiento POST PUT

- /preguntas GET
- /pregunta/{id} GET , DELET
- /pregunta POST PUT

- /progresos GET 
- /progreso/{id} GET  (el id es del progreso)
- /progreso POST PUT , DELET

- /progresosImagen GET
- /progresoImagen/alumno/{id} GET  (el id es del alumno)
- /progresoImagen/{id} GET  (el id es del progreso)
- /progresoImagen POST PUT , DELET
- /progresoImagen/{id} POST   (el id es del alumno)

- /suscripciones/alumno/{id} GET  (el id es del alumno)
- /suscripciones GET  
- /suscripciones/{id} GET  (el id es de la suscripcion)
- /suscripciones/ POST PUT , DELET
- /suscripcion/alumno/{id}/servicio/{idServicio} POST   (el id es del alumno)

- /noticias GET
- /noticia/{id} GET , DELET
- /noticia POST PUT

- /elementos GET
- /elemento/{id} GET , DELET
- /elemento POST PUT

- /historialProgresos/{id} GET, DELETE
- /historialProgresos POST PUT

//Todos-
Relaciones Many To Many
- Alumno - historial medico
- alumno - asistencia
- Entrenador - entrenador servicio
