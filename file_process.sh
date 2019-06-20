#! /bin/sh

for filess in *
do
	if [ -d "$filess" ]
	then
		cd "$filess"
		for filesss in *
		do
			if [ -f "$filesss" ]
			then
				newname=edited_"$filesss"
				awk '{
					string = $4
					temp = substr(string, 1, 1) "." substr(string, 2, 1)
					split(temp, a, ".", seps)
					stringg = $1
					tempp = substr(stringg, 4) "."
					split(tempp, b, ".", seps)
					OFS = "\t"
					print b[1], $2, $3, a[1], a[2], $5, $6, $7
				  }' $filesss > $newname
			fi
		done
	fi
done
