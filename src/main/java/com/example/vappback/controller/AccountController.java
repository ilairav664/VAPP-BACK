package com.example.vappback.controller;

import com.example.vappback.db.entity.Account;
import com.example.vappback.db.repository.AccountRepository;
import com.example.vappback.db.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    UserRepository userRepository;
    AccountRepository accountRepository;

    @Autowired
    public AccountController(UserRepository userRepository, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }



    @PostMapping("/addMoney")
    public Integer addMoney(@RequestParam(value="accountId") Integer accountId,
            @RequestParam(value="cardNumber") String cardNumber,
            @RequestParam(value="amount") Integer amount) {

        Account chargeAccount = accountRepository.findAccountByAccountId(accountId);
        chargeAccount.setBalance(chargeAccount.getBalance() + amount);
        accountRepository.save(chargeAccount);
        return 200;
    }

    @PostMapping("/transferMoney")
    public Integer transferMoney(@RequestParam(value="accountId") Integer accountId,
                              @RequestParam(value="cardNumber") String cardNumber,
                              @RequestParam(value="amount") Integer amount) {

        Account chargeAccount = accountRepository.findAccountByAccountId(accountId);
        Account transferAccount = accountRepository.findAccountByCardNumber(cardNumber);
        if (amount <= chargeAccount.getBalance()) {
            chargeAccount.setBalance(chargeAccount.getBalance() - amount);
            transferAccount.setBalance(transferAccount.getBalance() + amount);
            accountRepository.save(chargeAccount);
            accountRepository.save(transferAccount);
            return 200;
        } else return 0;
    }

    @RequestMapping(method= RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    public List<Account> getAccounts(@RequestParam(value = "userId") Integer userId) {
        return accountRepository.findAccountByAccountHolder_UserIdOrderByAccountId(userId);
    }
}
