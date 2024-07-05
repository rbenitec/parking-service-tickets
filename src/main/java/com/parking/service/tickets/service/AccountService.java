package com.parking.service.tickets.service;


import com.parking.service.tickets.entity.AccountEntity;

public interface AccountService {
    AccountEntity getAccountByUsername(String username);

}
