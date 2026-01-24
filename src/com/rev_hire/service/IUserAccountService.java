package com.rev_hire.service;

import com.rev_hire.model.UserAccount;

import java.util.List;

public interface IUserAccountService {
    public boolean addUserAccount(UserAccount userAccount);
    public boolean updateUserAccount(UserAccount userAccount);
    public boolean deleteUserAccount(int id);
    public UserAccount getUserAccount(int id);
    public List<UserAccount> getAllUserAccounts();
}
