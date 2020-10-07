package se.lexicon.dao;

import se.lexicon.model.Account;

import java.util.Optional;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public interface AccountDao {
    Account save(Account account);

    boolean delete(Integer id);

    Optional<Account> findById(Integer id);

}

