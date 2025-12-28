Sistema de Gestión de Usuarios y Roles

Java Web · MVC · MySQL · Apache Tomcat

📌 Descripción del proyecto

Este proyecto corresponde a una aplicación web desarrollada en Java, cuyo objetivo es gestionar usuarios y roles, permitiendo:

Registrar usuarios

Crear y listar roles

Asignar roles a usuarios

Visualizar la información desde una interfaz web

La aplicación fue construida utilizando el patrón de arquitectura MVC (Modelo–Vista–Controlador) y una base de datos relacional MySQL, cumpliendo con los principios de organización, escalabilidad y separación de responsabilidades.

🧠 Arquitectura utilizada
🔹 Patrón MVC

Modelo:
Clases Java que representan las entidades (Usuario, Rol, UsuarioRol) y acceso a datos (DAO).

Vista:
Páginas JSP con Bootstrap 5 para un diseño moderno y responsivo.

Controlador:
Servlets (UsuarioController, RolController) que gestionan las peticiones HTTP.

🛠️ Tecnologías utilizadas

Java SE

Java Web (Jakarta EE 8)

Apache Tomcat 9

MySQL (XAMPP)

JSP / Servlets

JDBC

Bootstrap 5

UML (modelo de datos)

📂 Estructura del proyecto
SistemaUsuariosWeb
│
├── Web Pages
│   ├── css
│   │   └── estilos.css
│   ├── usuario
│   │   ├── listar.jsp
│   │   ├── formulario.jsp
│   │   └── asignarRol.jsp
│   ├── rol
│   │   └── listar.jsp
│   └── index.jsp
│
├── Source Packages
│   ├── controlador
│   │   ├── UsuarioController.java
│   │   └── RolController.java
│   ├── dao
│   │   ├── UsuarioDAO.java
│   │   ├── RolDAO.java
│   │   └── UsuarioRolDAO.java
│   ├── modelo
│   │   ├── Usuario.java
│   │   ├── Rol.java
│   │   └── UsuarioRol.java
│   └── util
│       └── Conexion.java

🗄️ Base de datos
📌 Base de datos: sistema_usuarios
Tablas principales:
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(255),
    fecha_creacion DATE,
    estado BOOLEAN
);

CREATE TABLE rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(100)
);

CREATE TABLE usuario_rol (
    id_usuario INT,
    id_rol INT,
    PRIMARY KEY (id_usuario, id_rol),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

▶️ Ejecución del proyecto
Requisitos previos

JDK 8 o superior

Apache Tomcat 9

XAMPP (MySQL)

NetBeans IDE

Pasos

Clonar el repositorio

Importar el proyecto en NetBeans

Configurar Tomcat

Crear la base de datos en MySQL

Ejecutar el proyecto

La aplicación se inicia desde:

http://localhost:8080/SistemaUsuariosWeb

🎨 Interfaz gráfica

La interfaz fue desarrollada con Bootstrap 5, ofreciendo:

Diseño limpio y moderno

Tablas estilizadas

Formularios claros

Navegación sencilla

📊 Funcionalidades implementadas

✔ Listar usuarios
✔ Crear usuarios
✔ Crear roles
✔ Listar roles
✔ Asignar roles a usuarios
✔ Conexión a base de datos con JDBC

📚 Modelo UML

El modelo de datos fue diseñado utilizando UML, representando:

Entidades

Atributos

Claves primarias y foráneas

Relación muchos a muchos entre usuarios y roles

👨‍💻 Autor

Felipe Gómez
Ingeniería de Sistemas
Especialización en Desarrollo de Software
