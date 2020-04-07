#!/bin/sh

# Initialize initial file content in the root
cp initial/userAccounts.txt userAccounts.txt
cp initial/items.txt items.txt

# Loop through 5 days
for i in 1 2 3 4 5
do
    currentDay="day$i"
    echo $currentDay
    ./daily.sh $currentDay
done