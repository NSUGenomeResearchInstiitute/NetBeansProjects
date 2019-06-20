#! /bin/sh

awk '{
	string = $1
	temp = "samtools view -bS -q 20 " substr(string, 1) ".sam -o " substr(string, 1) ".bam"
	print temp
}' list_com.txt > bam_run.sh
