package com.example.tp7moadg7;

public interface ATM {
    public void login(Client client);
    public void deposit(Account account,int amount);
    public void withdraw(Account account,int amount);
}
