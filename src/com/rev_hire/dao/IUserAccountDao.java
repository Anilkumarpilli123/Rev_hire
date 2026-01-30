package com.rev_hire.dao;

import com.rev_hire.model.UserAccount;

import java.sql.SQLException;
import java.util.List;

public interface IUserAccountDao {

//    public boolean addUserAccount(UserAccount userAccount) throws SQLException;
//    public boolean updateUserAccount(UserAccount userAccount);
//    public boolean deleteUserAccount(int id);
//    public UserAccount getUserAccount(int id);
//    public List<UserAccount> getAllUserAccounts();
//
//    boolean isEmailExists(String email);

    UserAccount login(String email, String password, String role);

    boolean emailExists(String email);

    boolean addUserAccount(UserAccount userAccount);
}
