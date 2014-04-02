package com.titan.travelagent;

import javax.ejb.Remote;

import com.titan.domain.Address;
import com.titan.domain.Customer;
import com.titan.dto.CreditCardDO;
import com.titan.dto.TicketDO;
import com.titan.exception.IncompleteConversationalSate;

@Remote
public interface TravelAgentRemote {
    Customer findOrCreateCustomer(String firstName, String lastName);

    void updateAddress(Address addr);

    void setCruiseID(int cruise);

    void setCabinID(int cabin);

    TicketDO bookPassage(CreditCardDO card, double price) throws IncompleteConversationalSate;
}
