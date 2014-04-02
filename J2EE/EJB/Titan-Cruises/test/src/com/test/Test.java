package com.test;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.titan.travelagent.TravelAgentRemote;

public class Test {
    public static void main(String[] args) throws Exception {
        Context cxt = getInitialContext();
        Object ref = cxt.lookup("ejb/Titan/TitanEJB.jar/TravelAgentBean#com.titan.travelagent.TravelAgentRemote");
        TravelAgentRemote dao = (TravelAgentRemote) PortableRemoteObject.narrow(ref, TravelAgentRemote.class);

        //		Cabin cab = dao.findCabin(2);
        //		System.out.println(cab);
    }

    private static Context getInitialContext() throws NamingException {
        return new javax.naming.InitialContext();
    }
}
