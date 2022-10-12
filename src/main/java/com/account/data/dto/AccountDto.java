package com.account.data.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AccountDto {

    Long id;
    BigDecimal balance;
    LocalDateTime creationDate;
    AccountCustomerDto accountCustomerDto;
    Set<TransactionDto>transactionDtos;

}
