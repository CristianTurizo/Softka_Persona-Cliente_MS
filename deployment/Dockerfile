FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY applications/app-service/build/libs/PersonaYCliente.jar PersonaYCliente.jar
ENV JAVA_OPTS=" -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar PersonaYCliente.jar" ]
