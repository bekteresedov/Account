package com.account.data.dto.converter;

import com.account.data.dto.AccountDto;
import com.account.data.entity.Account;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AccountDtoConverter {

     final CustomerDtoConverter customerDtoConverter;
     final TransactionDtoConverter transactionDtoConverter;

     public AccountDto convert(Account account){
          return new AccountDto(
                  account.getId(), account.getBalance(),account.getCreationDate(),
                  customerDtoConverter.convertToAccountCustomer(Optional.ofNullable(account.getCustomer())),
                  Objects.requireNonNull(account.getTransactions())
                          .stream()
                          .map(transactionDtoConverter::convert)
                          .collect(Collectors.toSet()));
     }
}
