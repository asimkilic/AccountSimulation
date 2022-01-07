package com.asimkilic.account.dto.converter;

import com.asimkilic.account.dto.TransactionDto;
import com.asimkilic.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convertToTransactionDto(Transaction from) {
        return new TransactionDto(
                from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate()
        );
    }
}
