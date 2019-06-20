#! /bin/sh

awk '{
	string = $1
	temp = substr(string, 1) "_1.fastq"
	tempp = substr(string, 1) "_2.fastq"
	tem = substr(string, 1) ".sam"
	OFS = "\t"
	print temp" " tempp" > " tem
}' list_com.txt > output_final.txt
