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

        rm $day/transactions.output
        rm $day/$day_name.output

        touch $day/transactions.output
        touch $day/$day_name.output

        frontend/src/main userAccounts.txt items.txt $day/transactions.output < $day/$day_name.input > $day/$day_name.output
    fi
done
