package com.rev_hire.service;

import com.rev_hire.dao.IUserAccountDao;
import com.rev_hire.dao.UserAccountDaoImpl;
import com.rev_hire.model.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class UserAccountServiceImpl implements IUserAccountService {

    private static final Logger logger = LogManager.getLogger(UserAccountServiceImpl.class);
    private IUserAccountDao userAccountDao;

    public UserAccountServiceImpl() {
        this.userAccountDao = new UserAccountDaoImpl();
    }

    public UserAccountServiceImpl(IUserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }
    // @Override
    // public boolean addUserAccount(UserAccount userAccount) throws SQLException {
    //
    // if (userAccountDao.isEmailExists(userAccount.getEmail())) {
    // System.out.println("Email already exists. Registration failed.");
    // return false;
    // }
    //
    // return userAccountDao.addUserAccount(userAccount);
    // }
    //
    // @Override
    // public boolean updateUserAccount(UserAccount userAccount) {
    //
    // return userAccountDao.updateUserAccount(userAccount);
    // }
    //
    // @Override
    // public boolean deleteUserAccount(int id) {
    //
    // return userAccountDao.deleteUserAccount(id);
    // }
    //
    // @Override
    // public UserAccount getUserAccount(int id) {
    //
    // return userAccountDao.getUserAccount(id);
    // }
    //
    // @Override
    // public List<UserAccount> getAllUserAccounts() {
    // return List.of();
    // }
    //
    // @Override
    // public boolean isEmailExists(String email) {
    // return userAccountDao.isEmailExists(email);
    // }

    @Override
    public boolean addUserAccount(UserAccount userAccount) throws SQLException {

        System.out.println("➡ Registering user: " + userAccount.getEmail());
        logger.info("Attempting to register user: {}", userAccount.getEmail());

        if (userAccountDao.emailExists(userAccount.getEmail())) {
            System.out.println("Email already registered");
            logger.warn("Email already exists: {}", userAccount.getEmail());
            return false;
        }

        boolean inserted = userAccountDao.addUserAccount(userAccount);
        System.out.println("Insert result = " + inserted);

        return inserted;
    }

    //
    // @Override
    // public boolean updateUserAccount(UserAccount userAccount) {
    // return false;
    // }
    //
    // @Override
    // public boolean deleteUserAccount(int id) {
    // return false;
    // }
    //
    // @Override
    // public UserAccount getUserAccount(int id) {
    // return null;
    // }
    //
    // @Override
    // public List<UserAccount> getAllUserAccounts() {
    // return List.of();
    // }
    //
    // @Override
    // public boolean isEmailExists(String email) {
    // return false;
    // }

    @Override
    public UserAccount login(String email, String password, String role) {
        logger.info("Login attempt for email: {}, role: {}", email, role);
        return userAccountDao.login(email, password, role);

    }

}
