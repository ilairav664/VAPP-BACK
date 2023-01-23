package com.example.vappback.db.repository;

import com.example.vappback.db.entity.Account;
import com.example.vappback.db.entity.Shop;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    public Account findAccountByCardNumber(String cardNumber);
    public Account findAccountByAccountId(Integer accountId);
    public List<Account> findAccountByAccountHolder_UserIdOrderByAccountId(Integer userId);
    public List<Account> findAll();
}
