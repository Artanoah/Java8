# jmh Benchmarks for Java 8 Testobjects

## jmh website
`http://openjdk.java.net/projects/code-tools/jmh/`

## Maven archetype used to setup Project
```
mvn archetype:generate \
    -DinteractiveMode=false \
    -DarchetypeGroupId=org.openjdk.jmh \
    -DarchetypeArtifactId=jmh-java-benchmark-archetype \
    -DgroupId=benchmarks \
    -DartifactId=jmh-benchmarks \
    -Dversion=1.0 
```

## Build and run
To set maven to use java 8:
* In Linux systems
  * Create a `JAVA_HOME` system variable and set it to the java directory path.
  * z.B. `JAVA_HOME=/opt/java/jdk1.8.0_25/jre/ `
  * Save it in `~/.mavenrc`
* Windows systems
  * No idea

In `jmh-benchmarks` directory:
```
mvn clean install
java -jar target/benchmarks.jar «testobject»
```

`«testobject»`: Regular expression to select a class to benchmark from the src/main/java/benchmarks folder.

## Eclipse Project
Requires Maven plugin for eclipse. <br/>
Import project -> Maven -> Existing Maven Projects -> select `jmh-benchmarks` directory
