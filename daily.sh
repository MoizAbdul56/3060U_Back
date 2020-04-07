#!/bin/sh

# Empty the transaction files
:> week/$1/transactions1.txt 
:> week/$1/transactions2.txt 
:> week/$1/transactions3.txt

# Run three frontend sessions and use different inputs for each of them
cd frontend/src

make

if [ "$1" = "day3" ] # If its the third day then ask for user input
then
    ./main ../../userAccounts.txt ../../items.txt ../../week/$1/transactions1.txt
    ./main ../../userAccounts.txt ../../items.txt ../../week/$1/transactions2.txt
    ./main ../../userAccounts.txt ../../items.txt ../../week/$1/transactions3.txt
else # Otherwise read the stream.input files
    ./main ../../userAccounts.txt ../../items.txt ../../week/$1/transactions1.txt < ../../week/$1/stream1.input > ../../week/$1/stream1.output
    ./main ../../userAccounts.txt ../../items.txt ../../week/$1/transactions2.txt < ../../week/$1/stream2.input > ../../week/$1/stream2.output
    ./main ../../userAccounts.txt ../../items.txt ../../week/$1/transactions3.txt < ../../week/$1/stream3.input > ../../week/$1/stream3.output
fi

# Concatenate the transaction files into the merged transaction file
cd ../../week/$1

cat transactions1.txt transactions2.txt transactions3.txt > mergedTransactions.txt
cp mergedTransactions.txt ../../mergedTransactions.txt # Copy current merged transaction file to root so the backend can take it

# Run the backend to update items.txt and userAccounts.txt
cd ../../backend/src

javac --module-path $PATH_TO_FX --add-modules javafx.controls main.java
java --module-path $PATH_TO_FX --add-modules javafx.controls main

# Copy the current state of user accounts and items into the current day
cd ../../

cp userAccounts.txt week/$1/userAccounts.txt
cp items.txt week/$1/items.txt
