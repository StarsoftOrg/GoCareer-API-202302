# Usa una imagen de Java como base
FROM openjdk:latest

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR de tu aplicación a la imagen Docker
COPY ./target/tu-aplicacion.jar /app

# Comando para ejecutar tu aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "tu-aplicacion.jar"]
