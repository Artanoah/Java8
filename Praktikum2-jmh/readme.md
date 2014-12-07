# jmh Benchmarks for Java 8 Testobjects

## jmh website
http://openjdk.java.net/projects/code-tools/jmh/

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

## Build and run (on commandline)
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

#### Test [Modes](https://stackoverflow.com/questions/24928922/jmh-what-does-the-score-value-mean):
* `Throughput`: operations per unit of time
* `AverageTime`: average time per operation
* `SampleTime`: samples the time for each operation
* `SingleShotTime`: measures the time for a single operation

Example run with output to csv file: <br/>
`java -jar target/benchmarks.jar streamsVsFor -rf csv -rff test.csv -f 1 -i 8 -wi 8 -bm all`
to run tests for all testobjects: <br/>
`java -jar target/benchmarks.jar .*TestObject -rf csv -rff test.csv -f 1 -i 8 -wi 8 -bm all`

## Eclipse Project
Requires Maven plugin for eclipse. <br/>
Import project -> Maven -> Existing Maven Projects -> select `jmh-benchmarks` directory
