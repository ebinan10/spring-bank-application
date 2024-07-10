package com.springboot.bankApp.mapper;

import com.springboot.bankApp.dto.AccountDto;
import com.springboot.bankApp.entity.Account;

public class AccounterMapper {

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }


}
