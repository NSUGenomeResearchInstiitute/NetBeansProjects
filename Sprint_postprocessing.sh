#! /bin/sh

awk '{
	string = $1
	temp = "out" substr(string, 1)
	ch = "cd "
	print ch temp
	mov = "mv SPRINT_identified_regular.res out" substr(string, 1) ".res"
	print mov
	upp = "cd .."
	print upp
}' list_com.txt > postprocessing.sh
