FROM gradle:jre8-slim as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:8-jre-slim
MAINTAINER Shreyansh

ENV JAVA_APP_JAR restaurant.jar

COPY --from=builder /home/gradle/src/build/libs/$JAVA_APP_JAR /
#COPY --from=builder /home/gradle/src/build/libs/newrelic.jar /
#COPY --from=builder /home/gradle/src/build/libs/newrelic.yml /

CMD java -Duser.timezone=Asia/Kolkata -Xmx768m -javaagent:newrelic.jar -Dspring.profiles.active=$PROFILE -jar $JAVA_APP_JAR