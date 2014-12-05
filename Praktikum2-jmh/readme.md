# jmh Benchmarks for Java 8 Testobjects

## jmh
http://openjdk.java.net/projects/code-tools/jmh/

## maven archetype used to setup Project
mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=benchmarks \
          -DartifactId=jmh-benchmarks \
          -Dversion=1.0

## build and run
in top directory:
mvn clean install
java -jar target/benchmarks.jar <testobject>

<testobject>: regular expression to select a class to benchmark from the src/main/java/benchmarks folder.
