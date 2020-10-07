package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.dao.AccountDao;
import se.lexicon.model.Account;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class WalletServiceImpl implements WalletService {

    private AccountDao accountDao;

    // Setter Injection
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

/*

    // Constructor Injection
    public WalletServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
*/

    @Override
    public Account createAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }
        return accountDao.save(account);
    }

    @Override
    public Account findAccountById(Integer id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException();
        }
        return accountDao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Account withdraw(Integer amount, Integer accountId) {
        if (amount == 0) {
            throw new IllegalArgumentException();
        }
        if (accountId == null) {
            throw new IllegalArgumentException();
        }
        Account account = accountDao.findById(accountId).orElseThrow(IllegalArgumentException::new);
        if (amount > account.getBalance()) {
            throw new IllegalArgumentException();
        }
        account.setBalance(account.getBalance() - amount);
        accountDao.save(account);
        return account;
    }

    @Override
    public Account deposit(Integer amount, Integer accountId) {
        if (amount == 0) {
            throw new IllegalArgumentException();
        }
        if (accountId == null) {
            throw new IllegalArgumentException();
        }
        Account account = accountDao.findById(accountId).orElseThrow(IllegalArgumentException::new);
        account.setBalance(account.getBalance() + amount);
        return account;
    }
}
