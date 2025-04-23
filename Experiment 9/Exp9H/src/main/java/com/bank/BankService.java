package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Transactional
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accountDao.getAccountById(fromAccountId);
        Account toAccount = accountDao.getAccountById(toAccountId);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Account not found!");
        }

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds!");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountDao.updateAccount(fromAccount);

        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDao.updateAccount(toAccount);

        Transaction transaction = new Transaction(amount, fromAccount, toAccount);

        transactionDao.saveTransaction(transaction);
    }
}
