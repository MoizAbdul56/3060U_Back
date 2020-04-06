#!/bin/bash

# This script runs the tests for the auctioning system frontend

# command line argument to run tests for a single transaction
# ex: ./test.sh addcredit
#     will only run the tests for the addcredit transaction
if [ -n "$1" ]
then
    transaction_tests="tests/$1"
else
    transaction_tests="tests/*"
fi

# loop through the transaction test folders
for transaction in $transaction_tests
do
    if [ -d "$transaction" ]
    then
        transaction_name=${transaction##*/}
        echo -e "\e[7m  $transaction_name  \e[0m"

        # command line arg to only run single test in a transaction
        # ex: ./test.sh login login1
        #     will only run login1 test under login transaction
        if [ -n "$2" ]
        then
            test_dir=$transaction/$2
        else
            test_dir=$transaction/*
        fi

        # loop through each test folder
        for test in $test_dir
        do
            # name of the current test (generated by removing all the parent folder names from current path and leaving only current folder name)
            test_name=${test##*/}

            touch $test/transactions.output     # transactions file output
            touch $test/$test_name.output       # program output

            # generate necessary files if they don't exist
            # actually, we shouldn't since some tests rely on them not existing
            # touch $test/items.txt
            # touch $test/userAccounts.txt

            # run the program
            src/main $test/userAccounts.txt $test/items.txt $test/transactions.output < $test/$test_name.input > $test/$test_name.output

            # check if the output and transactions matched the expected output and transactions
            if diff $test/$test_name.output $test/$test_name.exoutput > /dev/null && diff $test/transactions.output $test/transactions.txt > /dev/null ;
            then
                # print PASS (with green highlighting) if they matched
                echo -e "\e[102m\e[30m PASS \e[39m\e[49m $test_name"
            else
                # print FAIL (with red highlighting) if either did not match
                echo -e "\e[101m\e[30m FAIL \e[39m\e[49m $test_name"

                # print the output diff if actual/expected differed
                if ! diff $test/$test_name.output $test/$test_name.exoutput > /dev/null ;
                then
                    echo -e "\e[106m\e[30m OUTPUT DIFF \e[39m\e[49m"
                    diff $test/$test_name.output $test/$test_name.exoutput
                fi

                # print the transactions diff if actual/expected differed
                if ! diff $test/transactions.output $test/transactions.txt > /dev/null ;
                then
                    echo -e "\e[106m\e[30m TRANSACTIONS DIFF \e[39m\e[49m"
                    diff $test/transactions.output $test/transactions.txt
                fi
                echo
            fi

            # remove temporary files
            rm $test/transactions.output
            rm $test/$test_name.output
        done

        echo
    fi
done