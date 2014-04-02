package com.titan.travelagent;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.titan.domain.Address;
import com.titan.domain.Cabin;
import com.titan.domain.Cruise;
import com.titan.domain.Customer;
import com.titan.domain.Reservation;
import com.titan.dto.CreditCardDO;
import com.titan.dto.TicketDO;
import com.titan.exception.IncompleteConversationalSate;
import com.titan.exception.PaymentException;
import com.titan.processpayment.ProcessPaymentLocal;

@Stateful
public class TravelAgentBeanStateful implements TravelAgentRemote {

    @PersistenceContext(unitName = "TitanDataSource")
    private EntityManager entityManager;
    private Customer customer;
    private Cabin cabin;
    private Cruise cruise;
    @EJB
    private ProcessPaymentLocal processPayment;

    @Override
    //indicate that after this method is invoked, all the references attributes of this class will be clear.
    public TicketDO bookPassage(CreditCardDO card, double price) throws IncompleteConversationalSate {
        if (customer == null || cruise == null || cabin == null) {
            throw new IncompleteConversationalSate();
        }

        try {
            Reservation reservation = new Reservation(customer, cruise, cabin, price, new Date());
            entityManager.persist(reservation);
            processPayment.byCredit(customer, card, price);
            TicketDO ticket = new TicketDO(customer, cruise, cabin, price);
            return ticket;
        } catch (PaymentException e) {
            throw new EJBException(e);
        }
    }

    @Override
    public Customer findOrCreateCustomer(String firstName, String lastName) {
        try {
            Query q = entityManager.createQuery("from Customer c where c.firstname = :first and c.lastname = :last");
            q.setParameter("first", firstName);
            q.setParameter("last", lastName);
            this.customer = (Customer) q.getSingleResult();
        } catch (NoResultException e) {
            this.customer = new Customer();
            this.customer.setFirstName(firstName);
            this.customer.setLastName(lastName);
            entityManager.persist(this.customer);
        }
        return customer;
    }

    @Override
    public void setCabinID(int cabin) {
        this.cabin = entityManager.find(Cabin.class, cabin);
        if (this.cabin == null) {
            throw new NoResultException("Cabin not found!");
        }
    }

    @Override
    public void setCruiseID(int cruise) {
        this.cruise = entityManager.find(Cruise.class, cruise);
        if (this.cruise == null) {
            throw new NoResultException("Cruise not found!");
        }
    }

    @Override
    public void updateAddress(Address addr) {
        this.customer.setAddress(addr);
        this.customer = entityManager.merge(customer);
    }

}
