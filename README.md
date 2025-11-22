# ProyectoUD01_AD_VALORANT

# Introducción:

Nuestra aplicacion esta inspirada en la seleccion de agenetes del Videojuego Valorant en el cual cada persona puede elegir el personaje que quiera dependiendo del rol del personaje, en este caso nuestra aplicaion muestra las caras de los personajes y una vez clicamos encima de ellos aparece una foto de cuerpo completo del mismo, junto con su descripcion y habilidades, toda esta informacion esta sacada de la API de Valorant, en el programa se puede buscar tanto por nombre del personaje o por el rol que tiene en la partida dependiendo del tipo de rol podemos diefrenciar cuatro grandes grupos : Duelista, Iniciador, Controlador y Centinela.

Ahora explicaremos que funcion tiene cada rol en una partida: 

# Duelista:
Su funcion principal es la de abrir camino al resto del equipo para entrar al site(lugar donde se planta la bomba), por eso las habilidades que tienen son de caracter agresivo para hacer movimientos rapidos y inesperados por parte del rival para poner la superioridad numerica respecto al otro equipo.

# Iniciador: 
La funcion principal es ayudar al duelista a entar al site con sus habilidades puede recaudar informacion de los enemigos para que todo su equipo sepa en cada caso lo que tiene que hacer para ayudarle a tomar el control de las areas de cada mapa.

# Controlador:
Este tiene una de las mayores dificultades del juego puesto que es el unico rol que juega de forma mas lenta al resto de sus compañeros ya que dependiendo de lo que el haga el ritmo de la partida sera mas lenta o mas frenetica.

# Centinela:
Es el rol mas defensivo del juego todas o la mayor parte de sus habilidades estan centradas en defender el area o las areas que pueda tener ese personaje dependiendo del rango de alcance de cada habilidad.

El programa cuenta con un registro de usuarios mediante el cual nospodemos registrar o iniciar sesion.

# Postman:
Hemos utilizado Postman para ver el contenido de la API y poder definir uan esctructura clara para poder empezar a diseñar la aplicaicon


# Estructura:
Nuestro proyecto esta planteado siguiendo el patron MVC(Modelo,Vista,Controlador)
<img width="517" height="558" alt="image" src="https://github.com/user-attachments/assets/62fd7099-406e-49dd-a0ca-7c3293be3fd3" />


# Modelo:
El modelo contiene los datos del programa y define cómo estos deben ser manipulados, es decir, contiene la lógica que Interactúa respondiendo a las solicitudes del controlador para acceder o actualizar los datos. Notifica indirectamente a la vista cuando los datos han cambiado para que se actualice la presentación.


# Controlador:
El controlador recibe las entradas del usuario desde la vista y las traduce en acciones que el modelo debe ejecutar. Se encarga de interpretar las acciones del usuario, manejar los eventos, y de actualizar tanto el modelo como la vista.


# Vista:Se encarga de la visualización de los datos del modelo de manera que el usuario los entienda es decir lo entienda.

# Metodología

Uso de Git

Este proyecto sigue una metodología de desarrollo incremental basado en ramas, lo que facilita la gestión de versiones y la colaboración de todos nosotros.

El flujo de trabajo que ha tenido nuestra Aplicacion es:

<img width="424" height="686" alt="image" src="https://github.com/user-attachments/assets/d2ffa574-d4bc-4cfe-af1c-1c9b2c0dbeba" />


Añadir Nuevas Funcionalidades: Cuando implementamos una nueva funcionalidad, se trabaja en la rama propia al paquete que pertenece. Cada uno de nosotros trabaja en una única rama, permitiendo que el trabajo avance de manera independiente.

Testeo: Una vez que se ha completado la funcionalidad, se realizan pruebas para asegurar que todo funciona correctamente y cumple con los requisitos establecidos.

Merge a Develop: Después de las pruebas exitosas, se realiza un "merge" de la rama de funcionalidad a develop. Esto es importante para comprobar la integración de la nueva funcionalidad con el resto del código del proyecto.

Merge a Main: Finalmente, cuando la versión en develop ha sido probada y es estable, se realiza un "merge" a la rama main. Esto marca el lanzamiento de una nueva versión del proyecto.

Este enfoque permite una colaboración fluida entre los dos desarrolladores, asegurando que el código sea de alta calidad y esté bien integrado antes de ser lanzado.


# Funcionamiento del Programa:

El funcionamiento de la aplicacion es el siguiente, nos permite buscaar tanto por nombre de personaje como por el rol que tenga este en la partida, una vez entramos al programa este nos preguntara si deseamos recuperar algun dato anterior y dependiendo de la opicon que selecionemos dejara todo default o cargara los archivos que han sido modificados a mayores por otro uso anterior de la apilcacion
<img width="2559" height="1392" alt="Captura de pantalla 2025-11-19 193109" src="https://github.com/user-attachments/assets/897a61f3-1035-49e4-a788-e81072996385" />
<img width="2559" height="1387" alt="Captura de pantalla 2025-11-19 193119" src="https://github.com/user-attachments/assets/b931f2d8-2b00-4d8e-b746-c47388184060" />
<img width="2559" height="1387" alt="Captura de pantalla 2025-11-19 192720" src="https://github.com/user-attachments/assets/ef1c35a7-df02-4b94-b401-77a2f29d0b01" />


# Hacemos una busqueda por nombre:

<img width="2559" height="1389" alt="Captura de pantalla 2025-11-19 192743" src="https://github.com/user-attachments/assets/82787240-0d60-4bbc-8d43-a076dcd5659b" />
El progrma detecta cuales de los pesonajes emiezan o contienen las letras que escribimos en el buscador y va deshabilitando al resto 

Hacemos una busqueda por el rol del personaje:
<img width="2559" height="1391" alt="Captura de pantalla 2025-11-19 192754" src="https://github.com/user-attachments/assets/470b77d8-24b8-4a40-ab82-387f7fad0d9e" />

En este caso solo saldran los personajes que tienen dicho rol 

Importante antes de hacer ninguna modificacion el cualquier de los personajes es necesario el registrarse y logearse para poder realizar modificaciones en cualquier personaje

<img width="280" height="221" alt="Captura de pantalla 2025-11-19 192820" src="https://github.com/user-attachments/assets/1fdbb5ef-2881-4a7d-b47b-16298cf69096" /> 
<img width="260" height="214" alt="Captura de pantalla 2025-11-19 192830" src="https://github.com/user-attachments/assets/e79ad5b0-5071-40b7-8856-6bb272738955" />
<img width="262" height="208" alt="Captura de pantalla 2025-11-19 192852" src="https://github.com/user-attachments/assets/42a69998-eaad-4186-ba9a-9de927d0934f" />
<img width="266" height="121" alt="Captura de pantalla 2025-11-19 192908" src="https://github.com/user-attachments/assets/aa200cfd-d371-4d86-870f-37aa849e8d25" />




# Consultar la información del Personaje

Al presionar en cada agente aparecera una foto de su cuerpo entero, una descripcion del personaje y sus correpondientes habilidades con sus respectivas imagenes de cada habildad junto a lo que hace cada habilidad
<img width="1922" height="1034" alt="image" src="https://github.com/user-attachments/assets/c5d153cc-4521-423d-aef6-c9e02017a61f" />
<img width="2552" height="1389" alt="Captura de pantalla 2025-11-18 200107" src="https://github.com/user-attachments/assets/13a48d32-a719-48f9-b440-4c91da79217b" />

# Creacion de personaje:
Pulsamos en el boton de crear y se nos abre la siguente ventana para la creacion del nuevo personaje
<img width="2556" height="1389" alt="Captura de pantalla 2025-11-18 200821" src="https://github.com/user-attachments/assets/eb41ba9d-9dd2-4024-9288-63ffe7a32d1b" />

falta otra imagen de creacion 

# Edicion de personaje:
Clicamos en el personaje que deseamos editar y se nos abrira una ventana con todos los datos inicales del personaje para que nosotros podamos modificarlo
<img width="2552" height="1385" alt="Captura de pantalla 2025-11-18 200251" src="https://github.com/user-attachments/assets/d347c722-f35e-44d1-bd63-c063d2c8f887" />

Una vez acabamos de modificar el personaje aparecera una ventana que guardara los cambios que hayamos hecho 
<img width="2551" height="1391" alt="Captura de pantalla 2025-11-18 200335" src="https://github.com/user-attachments/assets/9c6fe838-9a2a-455b-9936-991c276eaf20" />

Si volvemos a clicar en el personaje este aparecera con los cambios realizados anteriormente
<img width="2552" height="1391" alt="Captura de pantalla 2025-11-18 200348" src="https://github.com/user-attachments/assets/c6c1e21a-9057-404c-8371-e1a9c44a0c32" />

# Eliminar Personaje:
Pulsamos en el boton de eliminar, aparece una ventana en la cual se nos pide que introduzcamos un nombre para borrar ese personaje
<img width="2552" height="1390" alt="Captura de pantalla 2025-11-18 200407" src="https://github.com/user-attachments/assets/d9931464-eb9e-459c-b9aa-5ac47847cd24" />

Pulsamos en el boton de eliminar en caso de querer borrarlo y si no lo queremos borar en cancelar 
<img width="2555" height="1390" alt="Captura de pantalla 2025-11-18 200419" src="https://github.com/user-attachments/assets/142abddb-85f4-4a26-8be5-240f1f5b280c" />


# Reparto de tareas:
A la hora de dividir el trabajo nos repartimos de la siguiente manera: 
Juanjo hizo las vistas y el readme del github
Axel hizo la lectura de la Api y algunos controladores
Christian hizo el modelo y otros controladores

De esta manera cada uno fue haciendo los commits necesarios para que la aplicacion fuera avanzando al mismo tiempo que se seguia trabajando en ella.


# Mejoras:








# Conclusiones: 
En total cada uno del grupo ha invertido mas o menos x horas, teniendo en cuenta de que la mayoria del tiempo ha sido correguir errores del programa tanto de la interfaz como del codigo del programa, ya que es la primera vez que hacemos algo asi a nivel de programacion tanto de creacion de interfaces, lo que mas dificil nos ha parecido ha sido entender como funciona el manejo de la informacion de la api para nosotros poder manejarla 



# Creditos:
  
  Christian Castro Iglesias(ChristianCastro-dev)
  
  Juan José Dorado Maquieira(a24juandm)

  Axel Torreiro Lodeiro(a24axeltl)
