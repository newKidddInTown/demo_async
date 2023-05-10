FROM openjdk:8-alpine

ADD run.sh run.sh
ADD target/*.jar app.jar
CMD ["sh", "run.sh"]
