# Spring-Body-Fitnes-Gym
 
## URL JSON
- Servicio de login

- /errores muiestra todos los errores del sistema

- /login/{usuario}/{contrasenia}   este devuelve un alumno, entrenador o admin, lo que encuentre primero con esas credenciales
- /login/alumno/{usuario}/{contrasenia}   login especifico para alumnos
- /login/admin/{usuario}/{contrasenia}    login especifico para admins
- /login/entrenador/{usuario}/{contrasenia} login especifico para entrenadores

- /cambiarContrasenia/{usuario}/{oldPassord}/{newPassord} este devuelve un alumno, entrenador o admin, lo que encuentre primero con esas credenciales pero con la contrasenia ya cambiada, si no encuentra a nadie con esas credenciales devuelve mensaje de usuario no encontrado

- https://spring-body-fitness-gym.herokuapp.com/alumnos  Devuelve la lista de alumnos [GET]
- https://spring-body-fitness-gym.herokuapp.com/alumno/{ID} devuelve el alumno con el id {ID} [G]
- https://spring-body-fitness-gym.herokuapp.com/alumno Guarda un alumno con peticion [POST]
- https://spring-body-fitness-gym.herokuapp.com/alumno/{ID} Borrar una alumno de id {ID} con una peticion [DELET]
- https://spring-body-fitness-gym.herokuapp.com/alumno/todos Borrar todos los alumnos con una peticion [DELET]
-https://spring-body-fitness-gym.herokuapp.com/alumno Editar un alumno con una peticion [PUT]
- /alumnos Actualiza la lista de alumnos [PUT]

- /servicios obtener todos los servicios
- /servicio/{ID} obtener el servicio con el {ID} con [GET], y para borrarlo con [DELET]
- /servicio para agregarlo [POST] o editarlo [PUT]

- /clases GET
 - /clase/{id} GET , DELET
- /clase/servicio/{idServicio}/entrenador/{idEntrenador} POST 
- /clase/{idClase}/getHorarios GET obtiene los horarios de una clase

- /horarios GET
- /horario/filtro/{diaInicial}/{diaFinal} filtrar por dias (se tiene que ingresar la fecha con el formato completo) y devuelve objetos de texto con el siguiente formato: hora_inicio, hora_fin, descripcion_clase, nombre_servicio, entrenador_nombre
- /horario/filtroSinFechas filtrar por dias sin fecha inicial ni final (cupos disponibles, hora_inicio, hora_fin, descripcion_clase, nombre_servicio, entrenador_nombre)
- /horario/filtroSinFechas/entrenador/{idEntrenador} filtrar por dias sin fecha inicial ni final (cupos disponibles, hora_inicio, hora_fin, descripcion_clase, nombre_servicio, entrenador_nombre) por entrenador
- /horario/{id} GET , DELET
- /horario/clase/{idClase} POST 
- /horario/suscribirAlumnos/{idHorario} [PUT] Enviando una lista de alumnos se setea en la asistencia de un horario
- /horario/cuposDisponibles/{id} GET obtiene el numero de cupos disponibles


- /entrenadores GET
- /entrenador/{id} GET , DELET
- /entrenador POST PUT

- /movimientos GET
- /movimientos/{filtro}/{fechaInicio}/{fechaFinal}/generarReporte metodo de filtrar pero obtiene el reporte en pdf
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
- /alumno/{id}/reporte.pdf GET (el id es del alumno) descarga un pdf con los reportes

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

- /addErrors GET agregar todos los errores del sistema en caso de que esten vacios

//Todos-
Relaciones Many To Many
- Alumno - historial medico
- alumno - asistencia
- Entrenador - entrenador servicio



