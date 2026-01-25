package com.rev_hire.service;

import com.rev_hire.dao.IUserAccountDao;
import com.rev_hire.dao.UserAccountDaoImpl;
import com.rev_hire.model.UserAccount;

import java.sql.SQLException;
import java.util.List;

public class UserAccountServiceImpl implements IUserAccountService{
    private static IUserAccountDao userAccountDao = new UserAccountDaoImpl();
    @Override
    public boolean addUserAccount(UserAccount userAccount) throws SQLException {

        if (userAccountDao.isEmailExists(userAccount.getEmail())) {
            System.out.println("Email already exists. Registration failed.");
            return false;
        }

        return userAccountDao.addUserAccount(userAccount);
    }

    @Override
    public boolean updateUserAccount(UserAccount userAccount) {

        return userAccountDao.updateUserAccount(userAccount);
    }

    @Override
    public boolean deleteUserAccount(int id) {

        return userAccountDao.deleteUserAccount(id);
    }

    @Override
    public UserAccount getUserAccount(int id) {

        return userAccountDao.getUserAccount(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return List.of();
    }

    @Override
    public boolean isEmailExists(String email) {
        return userAccountDao.isEmailExists(email);
    }
}
