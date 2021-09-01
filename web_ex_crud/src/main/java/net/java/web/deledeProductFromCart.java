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
 * Servlet implementation class deledeProductFromCart
 */
@WebServlet("/DeleteProductFromCart")
public class deledeProductFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deledeProductFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();	
			int wID =Integer.parseInt(request.getParameter("id"));
			Object obj = session.getAttribute("cart");
			@SuppressWarnings("unchecked")
			Map<Integer, BillDetail> map = (Map<Integer, BillDetail>) obj;
			map.remove(wID);
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
