#! /bin/sh

files=`ls`

for filess in *
do
	if [ -d $filess ]
	then
		cd $filess
		for filesss in *
		do
			if [ ! -d $filesss ]
			then
				awk '{
					string = $4
					temp = substr(string, 1, 1) "." substr(string, 2, 1)
					split(temp, a, ".", seps)
					stringg = $1
					tempp = substr(stringg, 4) "."
					split(tempp, b, ".", seps)
					OFS = "\t"
					print b[1], $2, $3, a[1], a[2], $5, $6, $7
				  }' $filesss > outtr
			fi
		done
		cd ..
	fi
done
