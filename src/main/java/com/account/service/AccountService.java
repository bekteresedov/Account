package com.account.service;

import com.account.data.dto.AccountDto;
import com.account.data.dto.CreateAccountRequest;

public interface AccountService {

    public AccountDto createAccount(CreateAccountRequest createAccountRequest);
}
