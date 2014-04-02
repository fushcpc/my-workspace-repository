package com.test;

import java.util.Hashtable;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.xpath.operations.String;

import com.titan.travelagent.TravelAgentRemote;

public class SimpleClient {
	public static void main(String[] args) {
		java.lang.String jndiName = "ejb/Titan/TitanEJB.jar/TravelAgentBean#com.titan.travelagent.TravelAgentRemote";

		MessageProducer mp = null;
		Destination destination = null;
		try {

			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.ibm.websphere.naming.WsnInitialContextFactory");
			env.put(Context.PROVIDER_URL, "iiop://localhost:2809");
			Context initialContext = new InitialContext(env);
			System.out.println("Getting Connection Factory");

			TravelAgentRemote travelAgentRemote = (TravelAgentRemote) initialContext
					.lookup(jndiName);

		} catch (Exception je) {
		}
	}
}
