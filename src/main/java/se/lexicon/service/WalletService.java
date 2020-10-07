package se.lexicon.service;

import se.lexicon.model.Account;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public interface WalletService {
    Account createAccount(Account account);
    Account findAccountById(Integer id);
    Account withdraw(Integer amount,Integer accountId);
    Account deposit(Integer amount,Integer accountId);
}
