# Proyecto-CVDS-2022
**Documentación Plataforma de Gestión de Recursos Biblioteca**



**LUIS FELIPE ANDRÉS GIRALDO RODRÍGUEZ**** ​**

**SERGIO ANDRÉS ROZO PULIDO**

​ **ENRIQUE GONZÁLEZ SUAREZ​**

**NICOLE VANESSA MONTAÑA GÓMEZ**



**Presentado a:**

**HERNAN DARIO TENJO MATEUS**  (Product Owner)



**Universidad Escuela Colombiana de Ingeniería Julio Garavito**

**Ciclos de Vida del Desarrollo de Software - CVDS**

**Programa de Ingeniería de Sistemas**

**Bogotá D.C.**

**17 de mayo de 2022**

Tabla de Contenido

Descripción del producto ……………………………………… 3

Descripción general ……………………………………… 3

Manual de usuario ………………………………………... 4

Arquitectura y diseño …………………………………………..

Modelo E-D ………………………………………………..

Diagrama de clases ………………………………………

Descripción de la arquitectura ………………………….

Enlace Heroku ……………………………………………

Enlace al sistema de integración continua …………….

# Descripción del producto

#
Descripción general

El presente documento se realiza con el fin de presentar toda la información relevante sobre el proyecto realizado en la materia el cual trata sobre una plataforma que permita la gestión de diferentes recursos que hacen parte de la biblioteca, ofreciendo distintas funcionalidades las cuales permitan una correcta administración de dichos recursos.

Este proyecto fue realizado principalmente en los lenguajes de JAVA y HTML, para la base de datos se empleó PostgreSQL también para el apartado de la seguridad fue utilizado el framework de apache shiro lo que permitió tener dos principales usuarios uno de administrador y el otro como un usuario perteneciente a la comunidad de estudiantes.

A lo largo de este documento veremos un resumen de las funcionalidades de la página en el apartado de Manual de usuario, después el cómo se ordena la base de datos, las diferentes clases de JAVA que pertenecen al proyecto, una descripción de cómo esta implementado todo y finalmente el link a la página.

Manual de usuario

Al ingresar al enlace de la aplicación se muestra la pantalla de inicio de sesión. En el cual se muestran los espacios para ingresar los datos correspondientes (correo y contraseña) y dos botones uno para ingresar cuando se diligencien los datos y el otro para poder consultar los recursos disponibles actualmente.

![](RackMultipart20220519-1-k5gdcm_html_206c4aa83e4566ad.png)

Al dar en Consultar recursos se muestra la pantalla de los recursos consultados.

![](RackMultipart20220519-1-k5gdcm_html_1e4018b5fd1eda0f.png)

En este podemos observar cada uno de los recursos que se encuentran activos actualmente, en la parte de arriba nos da la opción de buscar los recursos según tres filtros los cuales nos permiten clasificar los distintos tipos de recursos de acuerdo con las necesidades del usuario.

![](RackMultipart20220519-1-k5gdcm_html_f609606c7db90a43.png)

El filtro de la izquierda nos indica la capacidad del recurso, se pueden seleccionar un número entre 1 y 5. Una vez seleccionado se da en el botón Buscar y nos muestra todos los recursos que posean esa característica.

El usuario podrá darle click a cualquiera de las opciones para seleccionar la capacidad del recurso que quiera buscar, en caso de que no quiera filtrar por capacidad se deja la opción seleccione capacidad.

![](RackMultipart20220519-1-k5gdcm_html_f902a50e6667f826.png)

![Inserting image...](RackMultipart20220519-1-k5gdcm_html_f832257b8ccd2544.png)

En el filtro del centro podemos seleccionar uno de los tres tipos de recursos que posee la biblioteca (libro, equipo de cómputo y sala de estudio). Una vez seleccionado el tipo deseado le damos en Buscar para que muestre los recursos correspondientes.

![](RackMultipart20220519-1-k5gdcm_html_a8118072e941de76.png)

En el filtro de la derecha podemos escribir el edificio en el cual queremos buscar un recurso (del bloque A hasta el bloque I), una vez digitado el bloque deseado se da en Buscar para que aparezcan los recursos en la ubicación deseada.

![](RackMultipart20220519-1-k5gdcm_html_4071652c3f18b4fe.png)

Si se desea buscar un recurso con características combinadas (una capacidad específica, con un tipo deseado o en una ubicación esperada), se deben seleccionar las opciones queridas en el filtro correspondiente y darle en el botón de Buscar para que aparezcan los recursos designados.

![](RackMultipart20220519-1-k5gdcm_html_96f00fd98888e6f3.png)

El botón de ver reservas permite ver todos los momentos en que un recurso esta siendo ocupado por alguien de la comunidad en un formato de un calendario

![](RackMultipart20220519-1-k5gdcm_html_500857ea18ca2860.png)

![](RackMultipart20220519-1-k5gdcm_html_3283417a8ad55bf0.png)

Esta vista muestra todas las reservas en caso dado de ser un administrador o un usuario no registrado y solo las reservas relacionadas a un usuario en caso dado de ser un usuario logeado.

Desde la vista anterior, para volver atrás y poder iniciar sesión le damos al botón de Atrás el cual nos redirigirá directamente a la pantalla de inicio de sesión.

En este debemos diligencias los datos correspondientes (correo del usuario y su respectiva contraseña), y le damos en el botón de Ingresar. (El usuario prueba es de carácter administrador).

![](RackMultipart20220519-1-k5gdcm_html_9c93663357d581dd.png)

Los perfiles de usuario que maneja la plataforma son dos:

- Administrador.
- Estudiante.

Según el rol del usuario ira a una de las 2 siguientes vistas:

Administrador:

![](RackMultipart20220519-1-k5gdcm_html_d8df91d9fd3e9d0f.png)

Comunidad:

![](RackMultipart20220519-1-k5gdcm_html_35d990722643f4ca.png)

ADMINISTADOR:

Este rol tiene la capacidad de agregar un recurso y consultar los recursos (vista que ya fue explicada)

![](RackMultipart20220519-1-k5gdcm_html_14b71627b435bdc0.png)

Al seleccionar la opción de agregar recurso aparece la siguiente vista:

![](RackMultipart20220519-1-k5gdcm_html_3739dbc31f1c841d.png)

La cual al completar la información requerida permite agregar un nuevo recurso que puede ser visto y reservado por la comunidad.

COMUNIDAD:

Un usuario perteneciente a dicha categoría puede consultar recursos vista que ya fue explicada, aunque tiene la posibilidad de reservar un recurso al seleccionarlo y darle al botón de reservar

![](RackMultipart20220519-1-k5gdcm_html_f1c67f235e22986a.png)

Tras esto se abrirá la siguiente vista:

![](RackMultipart20220519-1-k5gdcm_html_ba6817cf4a7cd406.png)

Donde siempre y cuando el recurso cuente con horarios disponibles, se podrá reservar, seleccionando el horario deseado y dando en el botón de reservar

![](RackMultipart20220519-1-k5gdcm_html_a3cd9f82f0a98458.png)

Tras esto veremos la siguiente vista donde se podrá elegir el día en el cual se desea hacer la reserva

![](RackMultipart20220519-1-k5gdcm_html_5216b3eafee7065c.png)

# Arquitectura y diseño

#
Modelo E-D

![](RackMultipart20220519-1-k5gdcm_html_8a70889ae297096f.png)

Las tablas principales son las de reservas y las de recursos, de ellas se desprenden las demás tablas las cuales sirven como complementos a las dos principales.

Horarios permiten saber en qué franjas en las cuales los recursos se podrán reservar o tienen reservas activas

Reservas permite visualizar la información de las reservas que se han realizado en la biblioteca

Recursos permite ver la información de los recursos de la biblioteca

Reservas recurrentes permite ver cuáles son las reservas ￼￼ que están apartadas por cierto periodo cada semana o cada día

Tipo recurso permite ver cuáles son los posibles tipos de recurso, por ahora están libro, sala de estudio y equipo de computo

Usuarios permite ver la información de los usuarios que están registrados en la biblioteca

Diagrama de clases

Paquete de entidades

![](RackMultipart20220519-1-k5gdcm_html_9f0e813887d186d8.png)

Paquete de manage beans

![](RackMultipart20220519-1-k5gdcm_html_2c84512efd6a480f.png)

Paquete de persistencia

![](RackMultipart20220519-1-k5gdcm_html_2984fb4d7b3171b7.png)

Paquete de servicios

![](RackMultipart20220519-1-k5gdcm_html_2b66148353f0221d.png)

Arquitectura del proyecto

Capas Aplicación Presentación Persistencia Capa de aplicación: En la capa de aplicación se utilizaron las siguientes tecnologías:

Java: Java es una tecnología empleada para el desarrollo de aplicaciones que convierten a la Web en un elemento más interesante y útil. Empleamos este lenguaje de programación para el desarrollo de la plataforma.

Google Guice: Google Guice es un framework que permite la inyección de dependencias.

Maven: Maven es una herramienta de software para la gestión y construcción de proyectos. Este fue empleado para la construcción y administración de nuestro proyecto de inicio a fin.

Apashe Shiro: Apashe Shiro permite el control de autenticación en aplicaciones. Este fue implementado para el control de autorizaciones y accesos.

JaCoCo: JaCoCo es una herramienta para Java que evalúa la cobertura de pruebas. Esta herramienta fue usada para el análisis del cubrimiento de las pruebas realizadas y la generación del reporte de estas.

**Capa de presentación:**

JFS: Java Server Faces es un framework de interfaz de usuario para aplicaciones web en Java. Este fue empleado para la construcción de las interfaces de usuario y su en lace con los beans en la capa de aplicación.

Primefaces: Primefaces es una biblioteca de componentes de JSF que brinda diferentes elementos visuales. Fue empleada para el desarrollo de las diferentes pantallas de usuario.

CSS: CSS es un lenguaje que permite dar estilo a los archivos html. CSS fue empleado para dar estilo y posicionar visualmente las diferentes interfaces.

**Capa de persistencia:**

PostgreSQL: Postgrest es un sistema gestor de bases de datos relacionales. Fue usado para la persistencia de la información correspondiente al proyecto.

MyBatis: MyBatis es una herramienta de persistencia Java. Este fue empleado para el mapeo de las sentencias SQL.

Enlace Heroku

[https://lens-recursos-biblioteca.herokuapp.com/](https://lens-recursos-biblioteca.herokuapp.com/)

Enlace al sistema de integración continua

[https://github.com/2022-1-PROYCVDS-LENS/Proyecto-CVDS-2021.git](https://github.com/2022-1-PROYCVDS-LENS/Proyecto-CVDS-2021.git)

En el readme.md del repositorio se encuentra
Proyecto de manejo de recursos de una biblioteca
[![CircleCI](https://circleci.com/gh/2022-1-PROYCVDS-LENS/Proyecto-CVDS-2021/tree/main.svg?style=svg)](https://circleci.com/gh/2022-1-PROYCVDS-LENS/Proyecto-CVDS-2021/tree/main)
