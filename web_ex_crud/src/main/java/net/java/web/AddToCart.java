package net.java.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import net.java.dao.WaifuDAO;
import net.java.model.user;
import net.java.model.waifu;
import net.java.model.BillDetail;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WaifuDAO waifuDAO;
	public void init() throws ServletException {
	 waifuDAO = new WaifuDAO();
		super.init();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DOC TU SESSION RA GIO HANG TRUOC
		try {
			
	
		int wID =Integer.parseInt(request.getParameter("WaifuID"));
		waifu waifu = waifuDAO.Get_Waifu_By_ID(wID);
		HttpSession session = request.getSession();
		
	
		Object obj = session.getAttribute("cart");
			
				if(obj==null) {
					BillDetail billDetail = new BillDetail();
					billDetail.setWaifu(waifu);
					billDetail.setQuantity(1);
					billDetail.setUnitPrice(waifu.getPrice());
					// gio hang co nhieu mat hang
					Map<Integer, BillDetail> map = new HashMap<>();
					map.put(wID, billDetail);// them mat hang vao ds
					
					session.setAttribute("cart", map);// luu tam vao session
				}else {
					@SuppressWarnings("unchecked")
					Map<Integer, BillDetail> map = (Map<Integer, BillDetail>) obj;
					BillDetail billDetail= map.get(wID);
					if(billDetail==null) {
						billDetail = new BillDetail();
						billDetail.setWaifu(waifu); 
						billDetail.setQuantity(1);
						billDetail.setUnitPrice(waifu.getPrice());
						map.put(wID, billDetail);
					}else {
						billDetail.setQuantity(billDetail.getQuantity()+1);
					}
					session.setAttribute("cart", map);// luu tam vao session
				}
				
				
				 response.sendRedirect("listwaifu");
		}catch (Exception e) {
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
