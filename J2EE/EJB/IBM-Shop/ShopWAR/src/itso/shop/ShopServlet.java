package itso.shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@EJB(name = "ejb/Cart", beanInterface = itso.shop.Cart.class)
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String CART_REF_NAME = "shop.cart";

	public ShopServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute(CART_REF_NAME);
		if (cart == null) {
			try {
				Context ctx = new InitialContext();
				cart = (Cart) ctx.lookup("java:comp/env/ejb/Cart");
				session.setAttribute(CART_REF_NAME, cart);
			} catch (NamingException e) {
				throw new ServletException(e);
			}
		}
		PrintWriter out = response.getWriter();
		out.write(cart.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
