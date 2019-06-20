#! /bin/sh

awk '{
	string = $1
	temp = "samtools sort " substr(string, 1) ".bam " substr(string, 1) ".sorted"
	print temp
}' list_com.txt > bam_sort.sh
