#! /bin/sh

awk '{
	string = $1
	temp = "cp out" substr(string, 1) ".res ../store/" substr(string, 4) ".res"
	print temp
}' list_com.txt > processed.sh
