#! /bin/sh

awk '{
	string = $1
	temp = substr(string, 1) "_1.fastq"
	tempp = substr(string, 1) "_2.fastq"
	tem = substr(string, 1) ".sam"
	temm = "bwa mem ./ref/hg38.fa "
	print temm temp" " tempp" > " tem
	wa = "wait"
	print wa
	rmm = "rm "
	print rmm temp" " tempp
}' list_com.txt > bwa_run.sh
