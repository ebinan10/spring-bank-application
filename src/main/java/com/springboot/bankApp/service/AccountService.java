package com.springboot.bankApp.service;

import com.springboot.bankApp.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto GetAccountById(long id);

    AccountDto DepositMoney(long id, double amount);

    AccountDto WithDrawMoney(long id, double amount);

    List<AccountDto> GetAllAccounts();

    void DeleteAccount(long id);
}
