package se.lexicon;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.lexicon.model.Account;
import se.lexicon.model.AccountType;
import se.lexicon.service.WalletService;

public class App {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        WalletService service=context.getBean("walletService",WalletService.class);
        Account account = service.createAccount(new Account("Mehrdad", AccountType.TRANSACTION_ACC,0L));
        System.out.println("account.toString() = " + account.toString());
        Account depositAccount = service.deposit(100,account.getId());
        System.out.println("depositAccount = " + depositAccount);

        Account walletAccount=service.withdraw(50,account.getId());
        System.out.println("walletAccount = " + walletAccount);

//        Account walletAccount1=service.withdraw(500,account.getId());
//        System.out.println("walletAccount1 = " + walletAccount1);


    }

}
