package com.rev_hire.service;

import com.rev_hire.model.UserAccount;

import java.sql.SQLException;
import java.util.List;

public interface IUserAccountService {
//    public boolean addUserAccount(UserAccount userAccount) throws SQLException;
//    public boolean updateUserAccount(UserAccount userAccount);
//    public boolean deleteUserAccount(int id);
//    public UserAccount getUserAccount(int id);
//    public List<UserAccount> getAllUserAccounts();
//    boolean isEmailExists(String email);

    boolean addUserAccount(UserAccount userAccount) throws SQLException;

    UserAccount login(String email, String password, String role);
}