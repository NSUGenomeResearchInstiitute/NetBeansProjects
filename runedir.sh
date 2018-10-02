#!/bin/sh

cd batchrun
begin=2801812
end=2802195
for i in $(seq $begin $end); do
    fil="SAMN0$i"
    filename="$i.fasta"
    esearch  -query $fil  -db nuccore | elink -target nuccore -name nuccore_nuccore_mstr2mbr | efetch -format fasta > $filename
done
