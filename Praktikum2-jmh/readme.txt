jmh Benchmarks for Java 8 Testobjects
=====================================

jmh website
-----------

http://openjdk.java.net/projects/code-tools/jmh/

Maven archetype used to setup Project
-------------------------------------

(just for your information, no need to run this again)

    mvn archetype:generate \
        -DinteractiveMode=false \
        -DarchetypeGroupId=org.openjdk.jmh \
        -DarchetypeArtifactId=jmh-java-benchmark-archetype \
        -DgroupId=benchmarks \
        -DartifactId=jmh-benchmarks \
        -Dversion=1.0 

Build and run (on commandline)
------------------------------

To set maven to use java 8: 
-   In Linux systems 
  -   Create a `JAVA_HOME` system variable and set it to the java directory path.
  -   z.B. `JAVA_HOME=/opt/java/jdk1.8.0_25/jre/` 
  -   Save it in `~/.mavenrc` 
-   Windows systems \
  -   No idea


In jmh-benchmarks directory:

    mvn clean install
    java -jar target/benchmarks.jar «testobject»

«testobject»: Regular expression to select a class to benchmark from the
src/main/java/benchmarks folder.

Test Modes:

-   Throughput: operations per unit of time
-   AverageTime: average time per operation
-   SampleTime: samples the time for each operation
-   SingleShotTime: measures the time for a single operation

Example run with output to csv file:
java -jar target/benchmarks.jar streamsVsFor -rf csv -rff output.csv -f 1 -i 8 -wi 8 -bm all
to run tests for all testobjects:
java -jar target/benchmarks.jar .*TestObject -rf csv -rff output.csv -f 1 -i 8 -wi 8 -bm all

Open as Eclipse Project
-----------------------

Requires Maven plugin for eclipse. Import project -> Maven -> Existing
Maven Projects -> select jmh-benchmarks directory

create charts from output data
------------------------------

software needed: *
-   GNU awk (gawk), has to be gawk because gensub function is used 
-   gnuplot 
-   Bash, split, head, cut

Run the benchmarks, let it generate a file output.csv. Run the plot.sh
bash script. It needs 2 parameters. The first parameter is the
output.csv with the benchmark data, the second is the number of test
objects (8 currently). 
    ./plot.sh sample-output.csv 8 
This creates a number of bar charts with gnuplot, called outputN.png. 
It will also create a number of files all beginning with mode-, these 
files are only needed for the gnuplot calls and can be deleted.
