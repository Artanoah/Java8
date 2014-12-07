set datafile separator ","
#set autoscale fix
set key outside right center
set style fill solid
set style data histograms
set boxwidth 0.8


set title "TITLE"

plot 'plot1.csv' using 5:xtic(8) title "for each", \
  'plot2.csv' using 5 title "stream"

pause -1
