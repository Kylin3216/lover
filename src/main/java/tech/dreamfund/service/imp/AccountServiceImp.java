package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.AccountDao;
import tech.dreamfund.model.Account;
import tech.dreamfund.service.AccountService;

/**
 * Created by xiasu on 2017/6/4.
 */
@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public void delAccount(int id) {
        accountDao.delAccount(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void updateLover(Account account) {
        accountDao.updateLover(account);
    }

    @Override
    public void updateEmail(Account account) {
        accountDao.updateEmail(account);
    }

    @Override
    public void updateTelephone(Account account) {
        accountDao.updateTelephone(account);
    }

    @Override
    public void updatePassword(Account account) {
        accountDao.updatePassword(account);
    }

    @Override
    public void updateType(Account account) {
        accountDao.updateType(account);
    }

    @Override
    public void updateLastLoginTime(Account account) {
        accountDao.updateLastLoginTime(account);
    }

    @Override
    public Account queryAccountById(int id) {
      return   accountDao.queryAccountById(id);
    }

    @Override
    public Integer queryLastId() {
        return accountDao.queryLastId();
    }

    @Override
    public Account confirmByAccountName(String accountName,String password) {
       return  accountDao.confirmByAccountName( accountName, password);
    }

    @Override
    public Account confirmByEmail(String email,String password) {
      return   accountDao.confirmByEmail( email, password);
    }

    @Override
    public Account confirmByTelephone(String telephone,String password) {
       return  accountDao.confirmByTelephone( telephone, password);
    }

    @Override
    public Account queryByAccountName(String accountName) {
        return accountDao.queryByAccountName(accountName);
    }

    @Override
    public Account queryByEmail(String email) {
        return accountDao.queryByEmail(email);
    }

    @Override
    public Account queryByTelephone(String telephone) {
        return accountDao.queryByTelephone(telephone);
    }
}
