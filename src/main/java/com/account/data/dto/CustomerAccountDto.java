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
public class CustomerAccountDto {

    Long id;
    BigDecimal balance=BigDecimal.ZERO;
    Set<TransactionDto>transactionDtos;
    LocalDateTime creationDate;
}
