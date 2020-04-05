#include <map>
#include <iostream>
#include <string>
#include "../user/user.h"
#include "transaction.h"
#include "../util/util.h"
using namespace std;

/**
* Verifies a user can perform a transaction
* @param user The user to verify
* @return A boolean of whether or not the user is permitted to perform the transaction
*/
bool CreateTransaction::verify(User* user) {
    if (!user) {
        cout << "Error: Not logged in" <<  endl;
        return false;
    }
    if (user->user_type == "AA") return true;

    cout << "Error: Transaction not permitted for your user type" << endl;
    return false;
}

/**
* Executes the create transaction
* @param tf The current transactions file
* @param current_user The current user
* @param users The users map
* @return A return code, 0 if successful, non-zero if an error occurs
*/
int CreateTransaction::execute(TransactionFile tf, User* current_user, map<string, User*> users) {
    if (!verify(current_user)) return 1;

    string username;
    string user_type;
    string user_credit;

    cout << "Please enter the username:" << endl;
    getline(cin, username);

    if (username.size() > 15) {
        cout << "Error: Username too long" << endl;
        return 1;
    }

    if (username.size() == 0){
        cout << "Error: Username too short" << endl;
        return 1;
    }

    map<string, User*>::iterator it = users.find(username);
    if(it == users.end()){
    } else{
        cout <<"Error: Username already taken" << endl;
        return 2;
    }

    //end of testing username
    cout << "Please enter the user type:" << endl;
    getline(cin, user_type);
    if(user_type != "AA" && user_type != "FS" && user_type != "SS" && user_type != "BS"){
        cout <<"Error: Invalid user type" <<endl;
        return 3;
    }

    cout <<"Please enter the initial credit:" <<endl;
    getline(cin, user_credit);
    if(!util::is_number(user_credit)){
        cout <<"Error: Invalid input" <<endl;
        return 4;
    }
    double credit = atof(user_credit.c_str());
    if (credit < 0){
        cout <<"Error: inital credit should greater than zero\n";
        return 5;
    }
    //end of testing user_type

    // TODO: add credit here
    tf.write_create_account(username, user_type,credit);

    cout << "Account created!" << endl;

    return 0;
}
