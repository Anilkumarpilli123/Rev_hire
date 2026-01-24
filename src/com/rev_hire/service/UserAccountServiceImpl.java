package com.rev_hire.service;

import com.rev_hire.dao.IUserAccountDao;
import com.rev_hire.dao.UserAccountDaoImpl;
import com.rev_hire.model.UserAccount;

import java.util.List;

public class UserAccountServiceImpl implements IUserAccountService{
    private static IUserAccountDao userAccountDao = new UserAccountDaoImpl();
    @Override
    public boolean addUserAccount(UserAccount userAccount) {
        return userAccountDao.addUserAccount(userAccount);
    }

    @Override
    public boolean updateUserAccount(UserAccount userAccount) {
        return false;
    }

    @Override
    public boolean deleteUserAccount(int id) {
        return false;
    }

    @Override
    public UserAccount getUserAccount(int id) {
        return null;
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return List.of();
    }
}
