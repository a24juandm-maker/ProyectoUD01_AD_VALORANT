# ProyectoUD01_AD_VALORANT

Introducción:

Nuestra aplicacion esta inspirada en la seleccion de agenetes del Videojuego Valorant en el cual cada persona puede elegir el personaje que quiera dependiendo del rol del personaje, en este caso nuestra aplicaion muestra las caras de los personajes y una vez clicamos encima de ellos aparece una foto de cuerpo completo del mismo, junto con su descripcion y habilidades, toda esta informacion esta sacada de la API de Valorant, en el programa se puede buscar tanto por nombre del personaje o por el rol que tiene en la partida dependiendo del tipo de rol podemos diefrenciar cuatro grandes grupos : Duelista, Iniciador, Controlador y Centinela.

Ahora explicaremos que funcion tiene cada rol en una partida: 

Duelista: Su funcion principal es la de abrir camino al resto del equipo para entrar al site(lugar donde se planta la bomba), por eso las habilidades que tienen son de caracter agresivo para hacer movimientos rapidos y inesperados por parte del rival para poner la superioridad numerica respecto al otro equipo.

Iniciador: La funcion principal es ayudar al duelista a entar al site con sus habilidades puede recaudar informacion de los enemigos para que todo su equipo sepa en cada caso lo que tiene que hacer para ayudarle a tomar el control de las areas de cada mapa.

Controlador: Este tiene una de las mayores dificultades del juego puesto que es el unico rol que juega de forma mas lenta al resto de sus compañeros ya que dependiendo de lo que el haga el ritmo de la partida sera mas lenta o mas frenetica.

Centinela: Es el rol mas defensivo del juego todas o la mayor parte de sus habilidades estan centradas en defender el area o las areas que pueda tener ese personaje dependiendo del rango de alcance de cada habilidad.

El programa cuenta con un registro de usuarios mediante el cual nospodemos registrar o iniciar sesion.

Postman:
Hemos utilizado Postman para ver el contenido de la API y poder definir uan esctructura clara para poder empezar a diseñar la aplicaicon


Estructura:
Nuestro proyecto esta planteado siguiendo el patron MVC(Modelo,Vista,Controlador)
<img width="517" height="558" alt="image" src="https://github.com/user-attachments/assets/62fd7099-406e-49dd-a0ca-7c3293be3fd3" />

Modelo:
El modelo contiene los datos del programa y define cómo estos deben ser manipulados, es decir, contiene la lógica que se necesita. Interactúa respondiendo a las solicitudes del controlador para acceder o actualizar los datos. Notifica indirectamente a la vista cuando los datos han cambiado para que se actualice la presentación.

Controlador
El controlador recibe las entradas del usuario desde la vista y las traduce en acciones que el modelo debe ejecutar. Se encarga de interpretar las acciones del usuario, manejar los eventos, y de actualizar tanto el modelo como la vista.

Vista
Se encarga de la visualización de los datos del modelo de manera que el usuario los entienda. No contiene lógica de negocio, solo muestra lo que el modelo le proporciona.. La vista recibe entradas del usuario (clics, teclas, etc.) y las envía al controlador.

Metodología
Uso de Git

Este proyecto usa metodología de desarrollo basado en ramas, lo que facilita la gestión de versiones y la colaboración entre desarrolladores. Las ramas principales del proyecto son main y develop, mientras que el desarrollo se llevó a cabo en paralelo en las ramas controller, service y model.

El flujo de trabajo del desarrollo es el siguiente:

Añadir Nuevas Funcionalidades: Cuando implementamos una nueva funcionalidad, se trabaja en la rama propia al paquete que pertenece. Cada uno trabaja en una única rama, permitiendo que el trabajo avance de manera independiente.

Testeo: Una vez que se ha completado la funcionalidad, se realizan pruebas para asegurar que todo funciona correctamente y cumple con los requisitos establecidos.

Merge a Develop: Realizamos un "merge" de la rama de funcionalidad a develop. Este paso comprueba la integración de la nueva funcionalidad con el resto del código del proyecto.

Merge a Main: Finalmente, cuando la versión en develop ha sido probada y se confirma que es estable, se realiza un "merge" a la rama main. Esto marca el lanzamiento de una nueva versión del proyecto.

Este forma de trabajo permite una colaboración fluida entre los todos desarrolladores, asegurando que el código sea de alta calidad y esté bien integrado antes de ser lanzado.

Aqui mostramos el todas las ramas que creamos para trabajar cada uno en su parte del proyecto 

<img width="1390" height="582" alt="image" src="https://github.com/user-attachments/assets/e1a17400-f43c-4b5f-925c-64092ea6b48a" />

Configuracion de Maven 

Nuestro archivo pom.xml incluye la siguiente dependencia importante:
<img width="1390" height="578" alt="image" src="https://github.com/user-attachments/assets/5a6fd10e-00ec-46df-bc44-d4e6988a8970" />


Manual de Usuario:

Lanzamiento de la aplicacion:

Menu principal de nuestra aplicacion 
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/bfb5e5db-ac46-4546-b072-2e2307e551fc" />
Esta aplicacion admite la busqueda por nombre de personaje o por rol del personaje dependiendo de el rol la aplicacion mostrara todos los agentes que pertenecen a ese rol

Busqueda de agente por nombre:
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/a767ef2b-af2e-46e9-8c98-9416fe8d83ac" />

Busqueda de agente por rol:
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d4bc8f35-782c-428f-8d7c-5a906e440826" />


Distincion de mayusculas y minusculas es decir que detecta los personajes que contienen los caracteres que escriba el usuario en caso de lo contrario no se marcara ningun personaje:
<img width="1922" height="1034" alt="image" src="https://github.com/user-attachments/assets/8530a1ef-a329-48b0-beba-e77f1ce342de" />

Consultar la información del Personaje

Al presionar en cada agente aparecera una foto de su cuerpo entero, una descripcion del personaje y sus correpondientes habilidades con sus respectivas imagenes de cada habildad junto a lo que hace cada habilidad
<img width="1922" height="1034" alt="image" src="https://github.com/user-attachments/assets/c5d153cc-4521-423d-aef6-c9e02017a61f" />


















# Creditos:
  
  Christian Castro Iglesias(ChristianCastro-dev)
  
  Juan José Dorado Maquieira(a24juandm)

  Axel Torreiro Lodeiro(a24axeltl)
