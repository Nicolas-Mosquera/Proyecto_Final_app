Integrantes:
Nicolas Estiven Mosquera Ortiz


1. Definición del problema

En muchas fundaciones y refugios de animales, el proceso de adopción aún se realiza de forma manual o mediante redes sociales, dificultando la visibilidad de las mascotas y la comunicación con los posibles adoptantes.
Esta falta de digitalización genera:

Dificultad para encontrar mascotas disponibles.

Información incompleta o dispersa.

Retrasos en el proceso de contacto con los encargados.

Poca interacción con los adoptantes potenciales.

AdoptAPet surge como solución digital que permita visualizar mascotas, filtrar opciones y obtener información de contacto de forma rápida y centralizada.


2.Objetivo general.

Desarrollar una aplicación móvil que facilite la visualización y búsqueda de mascotas disponibles para adopción, permitiendo a los usuarios acceder fácilmente a la información y datos de contacto del encargado.


#Objetivos específicos.


Implementar una interfaz clara y amigable que muestre las mascotas registradas en la base de datos.

Integrar un buscador que permita filtrar mascotas por nombre o raza.

Desarrollar una pantalla de información de contacto con datos del responsable.

Conectar la aplicación con Firebase Firestore para la carga dinámica de datos.

Optimizar la navegación para que sea rápida, sencilla y accesible para los usuarios.


3. Requerimientos funcionales.

La aplicación debe mostrar una lista de mascotas obtenidas desde Firebase Firestore.

La aplicación debe permitir buscar mascotas por nombre o raza.

El sistema debe actualizar la lista en tiempo real mientras el usuario escribe en el buscador.

La aplicación debe permitir acceder a una vista de información de contacto.

La vista de contacto debe mostrar nombre, correo y teléfono del encargado.

La aplicación debe permitir navegar de la vista de contacto a la principal usando un botón de retorno.

El sistema debe cargar automáticamente las mascotas al iniciar la aplicación.

La aplicación debe usar un RecyclerView para visualizar la lista de mascotas.

El sistema debe manejar adecuadamente si no hay datos en la base de datos, mostrando mensajes por defecto.

La aplicación debe permitir visualizar las imágenes de las mascotas (si las hay) mediante Glide o mostrar un ícono por defecto.


4. Requerimientos no funcionales.

Usabilidad: La interfaz debe ser clara, intuitiva y fácil de navegar para cualquier usuario.

Rendimiento: La carga de datos desde Firestore debe realizarse en menos de 3 segundos (según la conexión).

Escalabilidad: El sistema debe permitir agregar más mascotas o usuarios sin afectar el rendimiento.

Mantenibilidad: El código debe ser modular y organizado para facilitar futuras mejoras.

Compatibilidad: La aplicación debe funcionar correctamente en dispositivos Android 8.0 (API 26) o superior.

5. Historias de usuario.

Como usuario, quiero ver una lista de mascotas para conocer cuáles están disponibles para adopción.

Como usuario, quiero usar un buscador para encontrar mascotas según su nombre.

Como usuario, quiero poder filtrar mascotas por raza.

Como usuario, quiero que la lista se actualice mientras escribo, para encontrar más rápido lo que busco.

Como usuario, quiero ver una foto de la mascota para identificarla visualmente.

Como usuario, quiero que la app cargue los datos automáticamente sin tener que actualizar manualmente.

Como usuario, quiero poder acceder a la información del encargado para comunicarme fácilmente.

Como usuario, quiero ver el nombre del encargado del refugio para saber con quién hablar.

Como usuario, quiero ver el teléfono del encargado para pedir información sobre el proceso de adopción.

Como usuario, quiero ver el correo del encargado para contacto alternativo.

Como usuario, quiero un botón para volver atrás sin cerrar la aplicación.

Como usuario, quiero que la interfaz sea cómoda de usar y fácil de entender.

Como usuario, quiero que la app sea rápida y no se quede cargando por mucho tiempo.

Como usuario, quiero que la app funcione en mi celular sin importar el modelo (Android compatible).

Como usuario, quiero que los datos que veo sean reales y provengan de una base confiable como Firebase.
