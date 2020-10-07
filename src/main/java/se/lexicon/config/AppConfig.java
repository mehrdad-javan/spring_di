package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.AccountDaoImpl;
import se.lexicon.service.WalletService;
import se.lexicon.service.WalletServiceImpl;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Configuration
public class AppConfig {

    @Bean("accountDao")
    public AccountDao accountDao() {
        return new AccountDaoImpl();
    }

/*

    @Bean("walletService")
    public WalletService walletService(){
        return new WalletServiceImpl(accountDao());
    }
*/


    @Bean("walletService")
    public WalletService walletService() {
        WalletServiceImpl walletService = new WalletServiceImpl();
        walletService.setAccountDao(accountDao());
        return walletService;
    }

}
