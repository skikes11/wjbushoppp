package net.java.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.java.model.BillDetail;

/**
 * Servlet implementation class QuantityMinusFromCart
 */
@WebServlet("/QuantityMinusFromCart")
public class QuantityMinusFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuantityMinusFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();	
			int wID =Integer.parseInt(request.getParameter("wID"));
			Object obj = session.getAttribute("cart");
			@SuppressWarnings("unchecked")
			Map<Integer, BillDetail> map = (Map<Integer, BillDetail>) obj;
			BillDetail billDetail= map.get(wID);
			billDetail.setQuantity(billDetail.getQuantity()-1);
			if(billDetail.getQuantity()==0) {
				map.remove(wID);
			}
			session.setAttribute("cart", map);
			response.sendRedirect("Cart.jsp");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
