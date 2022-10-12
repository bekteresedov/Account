package com.account.data.dto;

import com.account.enums.TransactionType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TransactionDto {

    Long id;
    TransactionType transactionType=TransactionType.INITIAL;
    BigDecimal amount;
    LocalDateTime transactionDate;
}
