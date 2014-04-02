package com.titan.processpayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.sql.DataSource;

import com.titan.domain.Customer;
import com.titan.dto.CheckDO;
import com.titan.dto.CreditCardDO;
import com.titan.exception.PaymentException;

public class ProcessPaymentBean implements ProcessPaymentLocal, ProcessPaymentRemote {

    public final static String CASH = "CASH";
    public final static String CREDIT = "CREDIT";
    public final static String CHECK = "CHECK";

    @Resource(mappedName = "TitanDataSource")
    private DataSource dataSource;

    @Resource(name = "min")
    private int minCheckNumber;

    @Override
    public boolean byCash(Customer customer, double amount) throws PaymentException {
        return process(customer.getId(), amount, CASH, null, -1, null, null);
    }

    @Override
    public boolean byCheck(Customer customer, CheckDO check, double amount) throws PaymentException {
        if (check.checkNumber > minCheckNumber) {
            return process(customer.getId(), amount, CHECK, check.checkBarCode, check.checkNumber, null, null);
        } else {
            throw new PaymentException("Check number is too low. Must be at least " + minCheckNumber);
        }
    }

    @Override
    public boolean byCredit(Customer customer, CreditCardDO card, double amount) throws PaymentException {
        if (card.expireation.before(new java.util.Date())) {
            throw new PaymentException("Expiration date has passed");
        } else {
            return process(customer.getId(), amount, CREDIT, null, -1, card.number, new java.sql.Date(card.expireation.getTime()));
        }
    }

    private boolean process(int customerID, double amount, String type, String checkBarCode, int checkNumber, String creditNumber, java.sql.Date creditExpDate) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn
                    .prepareStatement("insert into payment (customer_id, amount, type, check_bar_code, check_number, credit_number, credit_exp_date) values (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, customerID);
            ps.setDouble(2, amount);
            ps.setString(3, type);
            ps.setString(4, checkBarCode);
            ps.setInt(5, checkNumber);
            ps.setString(6, creditNumber);
            ps.setDate(7, creditExpDate);
            int retVal = ps.executeUpdate();
            if (retVal != 1) {
                throw new EJBException("Payment insert failed");
            }
            return true;
        } catch (SQLException e) {
            throw new EJBException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new EJBException("Close DB resources failed!");
            }
        }
    }

}
