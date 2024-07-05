package com.parking.service.tickets.service.impl;

import com.parking.service.tickets.entity.AccountEntity;
import com.parking.service.tickets.repository.AccountRepository;
import com.parking.service.tickets.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountEntity getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername(username);
    }

}
