# Use an official lightweight Java image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from your build output to the container
COPY springboot-myapp/target/myapp-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Render uses dynamic ports, so we’ll handle that later)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
