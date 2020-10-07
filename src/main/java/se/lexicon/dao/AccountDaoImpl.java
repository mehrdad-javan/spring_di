package se.lexicon.dao;

import se.lexicon.dao.sequencer.AccountGenerator;
import se.lexicon.model.Account;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class AccountDaoImpl implements AccountDao {

    private Set<Account> accounts = new HashSet<>();

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(AccountGenerator.nextAccountId());
            accounts.add(account);
        } else {
            Optional<Account> findAccount = findById(account.getId());
            Account original = findAccount.orElseThrow(IllegalArgumentException::new);
            original.setName(account.getName());
            original.setAccountType(account.getAccountType());
            original.setBalance(account.getBalance());
        }
        return account;
    }

    @Override
    public boolean delete(Integer id) {
        Account account = findById(id).orElseThrow(IllegalArgumentException::new);
        return accounts.remove(account);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return accounts.stream().filter(account -> account.getId().equals(id)).findFirst();
    }
}
