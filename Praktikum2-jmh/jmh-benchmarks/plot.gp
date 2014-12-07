set datafile separator ","
#set autoscale fix
set key outside right center
set style fill solid
set style data histograms
set boxwidth 0.8
set grid

set terminal png size 800,600 enhanced font "Helvetica,20"
set output outputfile

set title "TODO: good title"

plot plot1file using 5:xtic(8) title plot1title, \
  plot2file using 5 title plot2title

#pause -1
