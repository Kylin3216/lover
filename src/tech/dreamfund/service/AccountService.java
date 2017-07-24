package tech.dreamfund.service;

import tech.dreamfund.model.Account;

/**
 * Created by xiasu on 2017/6/4.
 */
public interface AccountService {
    void addAccount(Account account);

    void delAccount(int id);

    void updateAccount(Account account);

    void updateLover(Account account);
    void updateEmail(Account account);

    void updateTelephone(Account account);

    void updatePassword(Account account);

    void updateType(Account account);

    void updateLastLoginTime(Account account);

    Account queryAccountById(int id);

    Integer queryLastId();

    Account confirmByAccountName(String accountName,String password);

    Account confirmByEmail(String email,String password);

    Account confirmByTelephone(String telephone,String password);

    Account queryByAccountName(String accountName);

    Account queryByEmail(String email);

    Account queryByTelephone(String telephone);
}
