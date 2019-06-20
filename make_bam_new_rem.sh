#! /bin/sh

awk '{
	string = $1
	temp = "samtools view -bS -q 20 " substr(string, 1) ".sam -o " substr(string, 1) ".bam"
	print temp
	wa = "wait"
	print wa
	rem = "rm " substr(string, 1) ".sam"
	print rem
	tem = "samtools sort " substr(string, 1) ".bam " substr(string, 1) ".sorted"
	print tem
	print wa
	rmo = "rm " substr(string, 1) ".bam"
	print rmo
}' list_com.txt > bam_create_final.sh
