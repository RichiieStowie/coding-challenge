FROM openjdk:11
#ADD ./target/codingChallenge-0.0.1-SNAPSHOT.jar /codingChallenge/src/codingChallenge-0.0.1-SNAPSHOT.jar
ADD target/codingChallenge-0.0.1-SNAPSHOT.jar codingChallenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","codingChallenge-0.0.1-SNAPSHOT.jar"]