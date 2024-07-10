package com.springboot.bankApp.controller;


import com.springboot.bankApp.dto.AccountDto;
import com.springboot.bankApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> GetAccount(@PathVariable long id){
        AccountDto accountDto = accountService.GetAccountById(id);
        return ResponseEntity.ok(accountDto);
         }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> DepositMoney(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("deposit");
        AccountDto accountDto = accountService.DepositMoney(id,amount);
        return  ResponseEntity.ok(accountDto);
    }

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> WithDrawMoney(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("withdraw");
        AccountDto accountDto = accountService.WithDrawMoney(id,amount);
        return  ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> GetAllAccounts(){
        List<AccountDto> accounts = accountService.GetAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteAccount(@PathVariable Long id){
         accountService.DeleteAccount(id);
         return ResponseEntity.ok("Account deleted successfully");
    }


}
