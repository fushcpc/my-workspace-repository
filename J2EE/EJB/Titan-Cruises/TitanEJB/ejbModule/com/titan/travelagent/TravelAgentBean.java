package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Address;
import com.titan.domain.Customer;
import com.titan.dto.CreditCardDO;
import com.titan.dto.TicketDO;
import com.titan.exception.IncompleteConversationalSate;

@Stateless
public class TravelAgentBean implements TravelAgentRemote {

    @PersistenceContext(unitName = "TitanDataSource")
    private EntityManager manager;

    @Override
    public TicketDO bookPassage(CreditCardDO card, double price) throws IncompleteConversationalSate {
        return null;
    }

    @Override
    public Customer findOrCreateCustomer(String firstName, String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCabinID(int cabin) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCruiseID(int cruise) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateAddress(Address addr) {
        // TODO Auto-generated method stub

    }

}
