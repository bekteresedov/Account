package com.account.data.dto.converter;
import com.account.data.dto.TransactionDto;
import com.account.data.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction transaction){
        return TransactionDto.builder().id(transaction.getId()).
                transactionType(transaction.getTransactionType())
                .amount(transaction.getAmount()).transactionDate
                        (transaction.getTransactionDate()).build();
    }
}
