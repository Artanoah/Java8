#!/bin/bash

# parameters
# first parameter is expected to be the input file (csv output of jmh becnhmark)
# second parameter is number of testobjects (needed for split)

# split the file into new files by test mode
awk -F, -f split-by-mode.awk -- $1

# the awk script creates 4 files:
# mode-avgt.csv
# mode-sample.csv
# mode-ss.csv
# mode-thrpt.csv

# split each of those files so that there is a file per testobject
for file in mode-*.csv
do
  #split --number=l/$2 $file $file.
  totallines=`wc -l "$file" | cut -f1 -d ' '`
  linesperfile=$(($totallines / $2))
  split --lines=$linesperfile $file $file.
done

# call the gnuplot script for 2 files each
i=0
for file in mode-*.csv.*
do
  if [ -z $prev ]
  then
    prev=$file
    continue
  fi

  ((i++))
  outputfile="output$i.png"
  plot1file=$prev
  plot2file=$file
  plot1title=`head -n1 "$prev" | cut -f1 -d' '`
  plot2title=`head -n1 "$file" | cut -f1 -d' '`
  yaxis=`head -n1 "$prev" | cut -f7 -d' '`

  gnuplot -e "outputfile='$outputfile'; yaxis='$yaxis'; plot1file='$plot1file'; plot1title='$plot1title'; plot2file='$plot2file'; plot2title='$plot2title';" plot.gp

  prev=""
done

#outputfile="output.png"

#plot1file="plot1.csv"
#plot1title="for each"

#plot2file="plot2.csv"
#plot2title="stream"


#gnuplot -e "outputfile='$outputfile'; plot1file='$plot1file'; plot1title='$plot1title'; plot2file='$plot2file'; plot2title='$plot2title';" plot.gp
