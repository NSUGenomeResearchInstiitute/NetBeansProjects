#! /bin/sh

awk '{
	string = $1
	temp = "annotate_variation.pl -out " substr(string, 4) " -buildver hg38 ../annoin/" substr(string, 4) ".avinput /home/nsu/Documents/annovar/humandb/hg38/"
	print temp
}' list_com.txt > process_annovarout.sh
