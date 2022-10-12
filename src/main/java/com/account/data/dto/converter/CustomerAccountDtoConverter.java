package com.account.data.dto.converter;

import com.account.data.dto.CustomerAccountDto;
import com.account.data.entity.Account;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CustomerAccountDtoConverter {

    final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDto convert(Account account) {
        return new CustomerAccountDto(
                Objects.requireNonNull(account.getId()),
                account.getBalance(),
                account.getTransactions()
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()),
                account.getCreationDate());
    }
}
