#ifndef TRANSACTION_H
#define TRANSACTION_H

#include <string>
#include <map>
#include "../user/user.h"
#include "../item/item.h"
#include "../transactionfile/transactionfile.h"

/**
* Class to represent a login transaction
*/
class LoginTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User*& user, std::map<std::string, User*> users);
};

/**
* Class to represent a logout transaction
*/
class LogoutTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User*& user, std::map<std::string, User*> users);
};

/**
* Class to represent a create transaction
*/
class CreateTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User* user, std::map<std::string, User*> users);
};

/**
* Class to represent a delete transaction
*/
class DeleteTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User* user, std::map<std::string, User*> users);
};

/**
* Class to represent an advertise transaction
*/
class AdvertiseTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User* user, std::map<std::string, User*> users, std::map<std::pair<std::string, std::string>, Item*> items);
};

/**
* Class to represent a bid transaction
*/
class BidTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User* user, std::map<std::string, User*> users, std::map<std::pair<std::string, std::string>, Item*> items);
};

/**
* Class to represent a refund transaction
*/
class RefundTransaction {
    public:
        static bool verify(User* user);
        static int execute(TransactionFile tf, User* user, std::map<std::string, User*> users);
};

/**
* Class to represent an addcredit transaction
*/
class AddCreditTransaction {
    public:
        static std::map<std::string, double> daily_max;
        static bool verify(User* user);
        static int execute(TransactionFile tf, User* user, std::map<std::string, User*> users);
};

#endif
