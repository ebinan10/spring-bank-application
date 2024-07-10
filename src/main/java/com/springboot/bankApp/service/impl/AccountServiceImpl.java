package com.springboot.bankApp.service.impl;

import com.springboot.bankApp.dto.AccountDto;
import com.springboot.bankApp.entity.Account;
import com.springboot.bankApp.mapper.AccounterMapper;
import com.springboot.bankApp.repository.AccountRepository;
import com.springboot.bankApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto){
        Account account = AccounterMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccounterMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto GetAccountById(long id){

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccounterMapper.mapToAccountDto(account);
    }


    @Override
    public AccountDto DepositMoney(long id, double amount){

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccounterMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto WithDrawMoney(long id, double amount){

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double balance = account.getBalance();

        if(amount <= balance) {
            balance = balance - amount;
            account.setBalance(balance);
        }
        else {
            throw new RuntimeException("Insufficient Funds");
        }
        Account savedAccount = accountRepository.save(account);
        return AccounterMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> GetAllAccounts() {
      List < Account> accounts = accountRepository.findAll();
      return accounts.stream().map(AccounterMapper::mapToAccountDto)
              .collect(Collectors.toList());

    }

    public void DeleteAccount(long id){
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }

}
