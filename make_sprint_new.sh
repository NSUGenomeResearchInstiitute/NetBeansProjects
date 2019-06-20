#! /bin/sh

awk '{
	string = $1
	temp = "sprint_from_bam " substr(string, 1) ".sorted.bam ./ref/hg38.fa out" substr(string, 1) " samtools"
	print temp
	wa = "wait"
	print wa
	tem = "cd out" substr(string, 1)
	print tem
	co = "rm -r tmp"
	print co
	te = "cd .."
	print te
	rmm = "rm " substr(string, 1) ".sorted.bam"
	print rmm
}' list_com.txt > sprintandprocess.sh
