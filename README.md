# Examén técnico - PayFinances API

API REST para la gestión de transacciones financieras, desarrollada con **Java 21**, **Spring Boot**, **H2 Database**, **JPA**, y validaciones mediante **Bean Validation**.

## 1. Estructura del Proyecto y jerarquía

- **controller**: Expone los endpoints REST para el manejo de transacciones.
- **service** : `TransactionsService` define la interfaz de los servicios a utilizar .
- **serviceimpl:** Contiene la lógica de negocio. `TransactionsServiceImpl` define la implementación de los servicios.
- **dto**: Objetos de transferencia de datos:
    - requests → TransactionRequestDTO
    - response → TransactionDTO
- **model / modelEnum**: Modelos de datos y enumeraciones para estandarizar códigos de banco, moneda y estado de transacción. Permite mejor control en datos que en situación real podrian vulnerabilizar las transacciones. Se optó por manejo de enum como primera versión. En caso de extender los códigos de bancos o tipo de monedas se podria optar por un servicio que tome dichos datos ya sea de un servicio externo o de una DB que almacene estos valores.
- **repository**: Interfaces JPA para acceso a la base de datos.
- **util**: Constantes, validaciones, manejo de excepciones y utilidades (ej. generación de estados aleatorios).

---

## 2. Dependencias y Justificación

spring-boot-starter-data-jpa -> Para la integración con JPA/Hibernate y persistencia en la base de datos a definir (H2 para este caso). 

spring-boot-starter-web -> Para exponer endpoints REST con Spring MVC. 

com.h2database:h2 -> Base de datos en memoria para desarrollo y pruebas. 

lombok -> Se hace uso de lombok para simplificar código en los manejos de getter and setter 

spring-boot-starter-test -> Librerías para testing (JUnit, Mockito, etc.). 

hibernate-validator/spring-boot-starter-validation -> Se optó por agregar la libreria para validación de datos mediante anotaciones como @NotNull, @Pattern, @Range. 

modelmapper-spring -> Para mapear automáticamente entidades a DTOs y viceversa. 



## 3. Configuración y Ejecución

1. **Clonar el repositorio mediante HTTPS**:

bash

git clone (https://github.com/araCeli898/payfinance-api.git)

cd payfinances-api


Compilar y ejecutar con Maven:

bash

mvn clean install

mvn spring-boot:run

URL TEST: http://localhost:8080/test


Acceso a la base de datos H2:

URL a DB H2: http://localhost:8080/h2-console

## CREDENCIALES:

JDBC URL: jdbc:h2:mem:testdb


Usuario: sa


Contraseña: (vacía)


4. Servicios y Endpoints
   
## TransactionController

GET	/transaction/{userId}	Obtener todas las transacciones de un usuario.

GET	/transaction/{userId}/{transactionId}	Obtener una transacción específica de un usuario.

POST	/transaction	Crear una nueva transacción.


Ejemplo de DTO de request: 

{

  "userId": 1,
  
  "recipientAccount": "DE98770400440532013123",
  
  "amount": 500.0,
  
  "currency": "EUR",
  
  "bankCode": "BANK123"
  
}


Ejemplo de respuesta:

{

  "status": "OK",
  
  "data": [
  
    {
    
      "transactionId": 10,
      
      "userId": 1,
      
      "recipientAccount": "DE98770400440532013123",
      
      "amount": 500.0,
      
      "currency": "EUR",
      
      "status": "APROBADO",
      
      "createdAt": "2025-09-25T20:21:23.124",
      
      "bankCode": "BANK123"
      
    }
    
  ],
  
  "error_code": null,
  
  "error_description": null,
  
  "code": null
  
}


## 5. Validaciones
Se utilizan anotaciones de Bean Validation en los DTOs:

@NotNull: Campo obligatorio.

@Pattern: Validación de patrones (ej. cuentas bancarias, códigos de banco).

@Range: Valores numéricos dentro de un rango (aplicado en monto minimo a transferir).

Si la validación falla, la API retorna un mensaje de error estándar:

json
{
  "timestamp": "2025-09-24T23:21:23.126+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "recipientAccount: Ingrese una cuenta bancaria válida",
  "path": "/transaction"
}

## 6. Diagramas y documentación
   
## Diagramas de servicios:

Cada servicio está representado por su Controller y su ServiceImpl correspondiente, comunicándose con el Repository y modelando la persistencia con Transactions.

Flujo de transacciones:

El TransactionController recibe la petición.

Se valida el DTO.

TransactionsServiceImpl aplica la lógica de negocio.

TransactionsRepository persiste los datos.

Se retorna un Result con la información final.

## 7. Consideraciones

Se utiliza ModelMapper para mapear automáticamente Transactions a TransactionDTO.

Se manejan excepciones globales en GlobalException.


Los transactionId se generan automáticamente mediante @GeneratedValue.


Se incorpora las properties y gitignore teniendo en cuenta que es un proyecto con uso de DB en H2. 
En entornos reales se da por entendido que no es una buena practica incluir ambos, ya que expone datos o key sensibles.

```
