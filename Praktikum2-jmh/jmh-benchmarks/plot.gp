#set datafile separator ","
#set autoscale fix
set key outside top center
set style fill solid
set style data histograms
set boxwidth 0.8
set grid
set xlabel "Dataset size"
set ylabel yaxis

set terminal png size 1024,768 enhanced font "Helvetica,20"
set output outputfile

#set title "this is the title"

plot plot1file using 5:xtic(8) title plot1title, \
  plot2file using 5 title plot2title

#pause -1
