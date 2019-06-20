awk ' { if ($4<0.001) 
  print $1 , "       " , $2 , "       " , $3 , "       " , $4 
} ' only_matched.txt > out_final.txt
