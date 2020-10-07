package se.lexicon.model;

import java.util.Objects;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class Account {
    private Integer id;
    private String name;
    private AccountType accountType;
    private Long balance;

    public Account() {
    }

    public Account(String name, AccountType accountType, Long balance) {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(name, account.name) &&
                accountType == account.accountType &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accountType, balance);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", accountType=").append(accountType);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
