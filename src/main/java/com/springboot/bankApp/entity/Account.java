package com.springboot.bankApp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
@Table(name = "account")
@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;

    public Account(){

    }

    public Account(Object id, String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public Account(Object id, String accountHolderName, double balance) {
//
//    }
}
