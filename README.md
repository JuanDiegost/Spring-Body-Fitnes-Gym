# Spring-Body-Fitnes-Gym

## URL JSON
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

- /entrenadores GET
- /entrenador/{id} GET , DELET
- /entrenador POST PUT

- /entrenadores GET
- /entrenador/{id} GET , DELET
- /entrenador/todos borra todos los entrenadores DELET
- /entrenador POST PUT

- /movimientos GET
- /movimiento/todos DELET borra todos
- /movimiento/{id} GET , DELET
- /movimiento POST PUT

- /preguntas GET
- /pregunta/{id} GET , DELET
- /pregunta POST PUT

- /progresos/alumno/{id} GET  (el id es del alumno)
- /progreso/{id} GET  (el id es del progreso)
- /progreso POST PUT , DELET
- /progreso/{id} POST   (el id es del alumno)

- /progresoImagen/alumno/{id} GET  (el id es del alumno)
- /progresoImagen/{id} GET  (el id es del progreso)
- /progresoImagen POST PUT , DELET
- /progresoImagen/{id} POST   (el id es del alumno)

- /progresoImagen/alumno/{id} GET  (el id es del alumno)
- /progresoImagen/{id} GET  (el id es del progreso)
- /progresoImagen POST PUT , DELET
- /progresoImagen/{id} POST   (el id es del alumno)

- /suscripciones/alumno/{id} GET  (el id es del alumno)
- /suscripciones GET  
- /suscripciones/{id} GET  (el id es de la suscripcion)
- /suscripciones/ POST PUT , DELET
- /suscripcion/alumno/{id}/servicio/{idServicio} POST   (el id es del alumno)
