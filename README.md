# AngelCamasAbnerIvan_pruebatec1
prueba tecnica 01 - gestion de empleados


Este prueba implementa un sistema de gestión de empleados utilizando JPA (Java Persistence API) y EclipseLink para la persistencia de datos. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre empleados.
## Requisitos Previos
Antes de ejecutar la aplicación, asegúrate de tener instalado lo siguiente:
- **Java JDK** 
- **Apache Maven** (de preferencia)
- **MySQL** o cualquier otra base de datos que uses con JPA.
- **NetBeans** o cualquier otro IDE que soporte Java y JPA.
- **XAMPP** o cualquier otro servidor de base de datos si estás usando MySQL,me funciono mas facil que MAMP
- **EclipseLink** como proveedor JPA (configurado en el archivo `persistence.xml`).

  ## Configuración de la base de datos

Antes de ejecutar la aplicación, asegúrate de que tu base de datos está configurada correctamente. Para hacerlo, debes:

    Crear una base de datos llamada pruebatecnicafinal (asi lo configure en persistence.xml).
    Configurar el acceso en el archivo persistence.xml que se encuentra en el directorio META-INF de tu proyecto.
    la tabla si se llama empleado

  ## Una vez que la aplicación esté en funcionamiento, puedes interactuar con ella utilizando las siguientes funcionalidades:

    Crear empleado: Agrega un nuevo empleado a la base de datos.
    Leer empleados: Consulta todos los empleados almacenados en la base de datos.
    Actualizar empleado: Modifica la información de un empleado existente.
    Eliminar empleado: Elimina un empleado de la base de datos.


   ## Durante el desarrollo de esta aplicación se consideraron los siguientes supuestos:

    Base de datos MySQL: Se asumió que la base de datos utilizada es MySQL, aunque podría adaptarse a otro sistema de base de datos mediante ajustes en el archivo persistence.xml.
    Conexión estable: Se asumió que la aplicación se ejecutará en un entorno donde la base de datos está disponible y la conexión es exitosa.
    Operaciones CRUD simples: Las operaciones CRUD se implementaron de manera básica sin validación avanzada o control de errores más allá de lo que JPA proporciona.
    No se manejan relaciones complejas: Este proyecto no maneja relaciones entre entidades complejas. Se limita a la gestión de una sola entidad (Empleado).
    Sin interfaz gráfica: La aplicación se prueba a través de la consola, sin interfaz de usuario. Sin embargo, es fácilmente ampliable para agregar una UI en el futuro.
    No validación avanzada de entrada: La validación de datos (como chequear si el salario es un valor positivo) no está implementada, pero podría añadirse según sea necesario(me quede sin tiempo).




###importante
los archivos estan sobre master
