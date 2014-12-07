NR == 1 {next}
{
  gsub(/"/, "");
  $1 = gensub(/^.*\.([A-z]+\.[A-z]+)$/, "\\1", 1, $1);
  print > "mode-"$2".csv"
}
