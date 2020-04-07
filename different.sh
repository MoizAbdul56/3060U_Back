#!/bin/bash

if [ -n "$1" ]
then
    days="week/$1"
else
    days="week/*"
fi

for day in $days
do
    if [ -d "$day" ]
    then
        day_name=${day##*/}
        echo -e "\e[7m  $day_name  \e[0m"

        rm $day/transactions1.txt
        rm $day/transactions2.txt
        rm $day/transactions3.txt

        touch $day/$day_name.txt

        frontend/src/main userAccounts.txt items.txt $day/transactions1.txt < $day/stream1.input > $day/$day_name.txt
        frontend/src/main userAccounts.txt items.txt $day/transactions2.txt < $day/stream2.input > $day/$day_name.txt
        frontend/src/main userAccounts.txt items.txt $day/transactions3.txt < $day/stream3.input > $day/$day_name.txt

        rm $day/$day_name.txt
    fi
done
