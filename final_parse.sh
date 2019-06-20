#! /bin/sh

awk '{
	string = $4
	temp = substr(string, 1, 1) "." substr(string, 2, 1)
	split(temp, a, ".", seps)
	stringg = $1
	tempp = substr(stringg, 4) "."
	split(tempp, b, ".", seps)
	OFS = "\t"
	print b[1], $2, $3, a[1], a[2], $5, $6, $7
}' sprinttr > outtr
