package com.account.service.impl;

import com.account.data.dto.AccountDto;
import com.account.data.dto.CreateAccountRequest;
import com.account.data.dto.converter.AccountDtoConverter;
import com.account.data.entity.Account;
import com.account.data.entity.Customer;
import com.account.data.entity.Transaction;
import com.account.data.repository.AccountRepository;
import com.account.service.AccountService;
import com.account.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {

     final AccountRepository accountRepository;
     final CustomerService customerService;
     final AccountDtoConverter converter;
     final Clock clock;

    @Override
    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {

        Customer customer=customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account=new Account();
        account.setCustomer(customer);
        account.setCreationDate(getLocalDateTimeNow());
        account.setBalance(createAccountRequest.getInitialCredit());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transaction transaction=new Transaction();
            transaction.setTransactionDate(getLocalDateTimeNow());
            transaction.setAccount(account);
            transaction.setAmount(createAccountRequest.getInitialCredit());
            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow(){
        Instant instant=clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
}
