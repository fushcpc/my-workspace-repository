package com.titan.clients;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.titan.domain.Address;
import com.titan.domain.Cabin;
import com.titan.dto.CreditCardDO;
import com.titan.dto.TicketDO;
import com.titan.exception.IncompleteConversationalSate;
import com.titan.travelagent.TravelAgentRemote;

/**
 * Servlet implementation class Client
 */
public class Client extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context cxt = getInitialContext();
            TravelAgentRemote remote = (TravelAgentRemote) cxt.lookup("ejb/spc/titan/TravelAgentBeanStateful");
            CreditCardDO creditCard = new CreditCardDO("1234567890", new Date(), "zhaoshangringhang");
            remote.findOrCreateCustomer("David", "Chen");
            remote.setCabinID(1);
            remote.setCruiseID(1);
            Address addr = new Address();
            addr.setCity("SZ");
            addr.setState("GX");
            addr.setStreet("NANSHANDADAO");
            addr.setZip("537023");
            remote.updateAddress(addr);
            TicketDO ticket = remote.bookPassage(creditCard, 101);
            PrintWriter out = response.getWriter();
            out.write(ticket.toString());
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (IncompleteConversationalSate e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private void saveCabin(HttpServletResponse response) throws NamingException, IOException {
        Context cxt = getInitialContext();
        //Object ref = cxt.lookup("ejb/Titan/TitanEJB.jar/TravelAgentBean#com.titan.travelagent.TravelAgentRemote");
        Object ref = cxt.lookup("ejb/spc/titan/TravelAgent");
        TravelAgentRemote dao = (TravelAgentRemote) PortableRemoteObject.narrow(ref, TravelAgentRemote.class);

        Cabin cabin = new Cabin();
        // cabin.setId(1);
        cabin.setName("Master Suite");
        cabin.setDeckLevel(1);
        cabin.setShipId(1);
        cabin.setBedCount(3);

        //        dao.createCabin(cabin);

        //            Cabin cab = dao.findCabin(1);
        PrintWriter out = response.getWriter();
        out.print(cabin);
    }

    private Context getInitialContext() throws NamingException {
        return new javax.naming.InitialContext();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
