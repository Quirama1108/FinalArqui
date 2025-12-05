# =============================================================
# Etapa 1: Construcción del proyecto usando Maven
# =============================================================
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Crear carpeta para el proyecto
WORKDIR /app


COPY . .

# Construir el proyecto y empaquetar el JAR, omitiendo los tests
RUN mvn clean package -DskipTests


# =============================================================
# Etapa 2: Imagen final (solo JAR)
# =============================================================
FROM eclipse-temurin:17

# Carpeta donde vivirá el JAR
WORKDIR /app

# Copiar el jar generado desde la etapa build
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
