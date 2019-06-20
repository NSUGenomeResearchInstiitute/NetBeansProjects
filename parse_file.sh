#! /bin/sh

awk '{
	string = $1
	temp = substr(string, 1) "_1"
	tempp = substr(string, 1) "_2"
	tem = substr(string, 1) ".sam"
	OFS = "\t"
	print temp, tempp, tem
}' list_com.txt > out_fin.txt
