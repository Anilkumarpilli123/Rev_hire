package com.rev_hire.dao;

import com.rev_hire.model.UserAccount;
import com.rev_hire.util.JDBCUtil;

import java.sql.Connection;
import java.util.List;

public class UserAccountDaoImpl implements IUserAccountDao {

    @Override
    public boolean addUserAccount(UserAccount userAccount) {
        Connection con = JDBCUtil.getConnection();
        return false;
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
