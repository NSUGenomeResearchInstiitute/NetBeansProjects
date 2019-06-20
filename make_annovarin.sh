#! /bin/sh

awk '{
	string = $1
	temp = "convert2annovar.pl -format vcf4 ./store/edited_" substr(string, 4) ".res > ./annoin/" substr(string, 4) ".avinput"
	print temp
}' list_com.txt > process_annovarin.sh
