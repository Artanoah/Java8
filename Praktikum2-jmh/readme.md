# jmh Benchmarks for Java 8 Testobjects

## jmh
http://openjdk.java.net/projects/code-tools/jmh/

## maven archetype used to setup Project
> mvn archetype:generate \ <br/>
>          -DinteractiveMode=false \ <br/>
>          -DarchetypeGroupId=org.openjdk.jmh \ <br/>
>          -DarchetypeArtifactId=jmh-java-benchmark-archetype \ <br/>
>          -DgroupId=benchmarks \ <br/>
>          -DartifactId=jmh-benchmarks \ <br/>
>          -Dversion=1.0

## build and run
in top directory:
> mvn clean install <br/>
> java -jar target/benchmarks.jar «testobject»

«testobject»: regular expression to select a class to benchmark from the src/main/java/benchmarks folder.
