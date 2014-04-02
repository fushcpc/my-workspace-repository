package com.titan.processpayment;

import com.titan.domain.Customer;
import com.titan.dto.CheckDO;
import com.titan.dto.CreditCardDO;
import com.titan.exception.PaymentException;

public interface ProcessPayment {
    boolean byCheck(Customer customer, CheckDO check, double amount) throws PaymentException;

    boolean byCash(Customer customer, double amount) throws PaymentException;

    boolean byCredit(Customer customer, CreditCardDO card, double amount) throws PaymentException;
}
