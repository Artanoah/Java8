######################################
#         Eigenes Benchmark-Tool     #
# Steffen Giersch, Maximilian Zender #
#   Jeremias Twele, Hendrik Albers   #
#             Hector Smith           #
######################################


	Inhalt:

/src 				-> Source-Ordner der .java Dateien
.project			-> Eclipse-Projekt-Datei
.classpath			-> Classpath-Datei fuer das Eclipse-Projekt
Java 8 Benchmark - graphen.pdf 	-> Benchmarks-Ergebnisse als Grafik
WP Java8 Konzept Aufgabe2.pdf	-> Konzept 
sgb-words.txt			-> Input fuer Benchmarks
output.csv			-> Benchmark-Ergebnisse als .csv
README.txt			-> Diese Datei


	Ausfuehrung:

Der Ordner "Praktikum2-ownBenchmark" kann einfach als Java-Projekt in Eclipse
eingebunden werden. 
Die Hauptklasse ist "benchmark.TestAll" und kann einfach ausgefuehrt werden 
um die Benchmarkergebnisse sowohl in der Konsolenausgabe, als auch als 
"output.csv"-Datei zu erzeugen.
Bei Bedarf koennen auch eigene Tests zum Benchmark zugefuegt werden, indem sie
in der Klasse "benchmark.TestAll" zum Method-Array "methods" hinzugefuegt werden