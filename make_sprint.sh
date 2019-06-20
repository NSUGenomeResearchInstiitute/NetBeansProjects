#! /bin/sh

awk '{
	string = $1
	temp = "sprint_from_bam " substr(string, 1) ".sorted.bam ./ref/hg38.fa out" substr(string, 1) " samtools"
	print temp
}' list_com.txt > sprint_run.sh
