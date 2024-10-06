# Metacine (grupo 02) 

Para realizar conexión con la base de datos, necesitan crear un application.properties en src/main/resources como de este tipo

```
spring.application.name=Metacine
spring.datasource.url={DB_URL}
spring.datasource.username={DB_USR}
spring.datasource.password={DB_PSWD}

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.jpa.hibernate.ddl-auto=update
```