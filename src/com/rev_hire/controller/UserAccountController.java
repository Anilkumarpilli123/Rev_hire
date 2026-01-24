package com.rev_hire.controller;

import com.rev_hire.dao.IUserAccountDao;
import com.rev_hire.dao.UserAccountDaoImpl;
import com.rev_hire.model.UserAccount;
import com.rev_hire.service.IUserAccountService;
import com.rev_hire.service.UserAccountServiceImpl;

import java.util.List;

public class UserAccountController {
//    private static IUserAccountDao userAccountDao = new UserAccountDaoImpl();

    private static IUserAccountService userAccountService = new UserAccountServiceImpl();

    public boolean addUserAccount(UserAccount userAccount) {
        return userAccountService.addUserAccount(userAccount);
    }


    public boolean updateUserAccount(UserAccount userAccount) {
        return false;
    }


    public boolean deleteUserAccount(int id) {
        return false;
    }


    public UserAccount getUserAccount(int id) {
        return null;
    }


    public List<UserAccount> getAllUserAccounts() {
        return List.of();
    }
}
