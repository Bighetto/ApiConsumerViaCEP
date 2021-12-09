FROM openjdk:11

RUN apt update && apt install -y maven

COPY pom.xml pom.xml
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests=true -X

COPY target/*.jar app.jar

#VARIAVEIS DE AMBIENTE:

#ENV URL \
   # SENHA \
   # USUARIO \
   # OPERACAO_PEDIDO \
   # OPERACAO_TOKEN \
   # STOREID \
   # DB_URL \
   # DB_NAME \
   # DB_USER \
   # DB_PASS \
   # DB_PORT


ENV TZ America/Sao_Paulo

CMD ["java", "-jar", "/app.jar"]