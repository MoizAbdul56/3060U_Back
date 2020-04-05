#!/bin/sh
cd frontend/src

make

./main userAccounts.txt items.txt transactions1.txt << EOF
login
buyer
addcredit
102
logout
exit
EOF

./main userAccounts.txt items.txt transactions2.txt << EOF
login
seller
advertise
ball
20
3
logout
exit
EOF

./main userAccounts.txt items.txt transactions3.txt << EOF
login
user
bid
guitar
seller
400
logout
exit
EOF

cat transactions1.txt transactions2.txt transactions3.txt > mergedTransactions.txt

cd ../../backend/src

javac --module-path $PATH_TO_FX --add-modules javafx.controls main.java
java --module-path $PATH_TO_FX --add-modules javafx.controls main



