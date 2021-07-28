#!/bin/sh
SECONDS=5
i=1

while grep -w -v "COMPLETE" sample.txt > /dev/null
do
        echo "`date`: Loop $i"
        i=$(( $i+1 ))

        sleep $SECONDS
done
echo 'done'