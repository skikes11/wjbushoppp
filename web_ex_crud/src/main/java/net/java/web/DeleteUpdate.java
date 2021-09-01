package net.java.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.java.dao.UserDAO;
import net.java.dao.WaifuDAO;
import net.java.model.user;
import net.java.model.waifu;

/**
 * Servlet implementation class DeleteUpdate
 */
@WebServlet("/")
public class DeleteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private WaifuDAO waifuDAO;

    public void init() {
        userDAO = new UserDAO();
        waifuDAO = new WaifuDAO();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String action = request.getServletPath();
        switch (action) {
		    case "/delete":
		       deleteAccount(request, response);
		        break;
		    case "/update":
		    	updateAccount(request, response);
		        break;
		    case "/gUpdate":
		    	GetUpdateAcc(request, response);
		        break;
		    case "/registerPage":
		        showNewForm(request, response, "createAcount.jsp");
		        break;
		    case "/wjbu":
		        showNewForm(request, response, "listwaifu");
		        break;
		    case "/listwaifu":
		    	ShowListWaifu(request, response,"ShopWaifu.jsp");
		        break;
		    case "/manage":
		    	ShowListWaifu(request, response,"Manage.jsp");
		        break;
		    case "/waifuDelete":
		    	deleteWaifu(request,response);
		        break;
		    case "/FormWaifuImport":
		    	showNewForm(request, response, "FormWaifuImport.jsp");
		        break;
		    case "/importWaifu":
		    	InsertWaifu(request, response);
		        break;
		    case "/FormWaifuUpdate":
		    	ShowUpdateWaifuForm(request,response);
		        break;
		    case "/updateWaifu":
		    	GetUpdateWaifu(request,response);
		    	break;
		    case "/listWaifu_TypeLoli":
		    	ShowListWaifu_TypeLoli(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_TypeBB":
		    	ShowListWaifu_TypeBB(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_AgeGoingDown":
		    	ShowListWaifu_Age_GoingDown(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_AgeGoingDown_TypeBB":
		    	ShowListWaifu_Age_GoingDown_Type_BB(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_AgeGoingDown_TypeLoli":
		    	ShowListWaifu_Age_GoingDown_Type_Loli(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_AgeGoingUp":
		    	ShowListWaifu_Age_GoingUp(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_AgeGoingUp_TypeBB":
		    	ShowListWaifu_Age_GoingUp_Type_BB(request,response,"ShopWaifu.jsp");
		    	break;	
		    case "/listWaifu_AgeGoingUp_TypeLoli":
		    	ShowListWaifu_Age_GoingUp_Type_Loli(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_Name_A_Z":
		    	ShowListWaifu_Name_A_Z(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_Name_A_Z_TypeBB":
		    	ShowListWaifu_Name_A_Z_Type_BB(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_Name_A_Z_TypeLoli":
		    	ShowListWaifu_Name_A_Z_Type_Loli(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_PriceGoingDown":
		    	ShowListWaifu_Price_Going_Down(request,response,"ShopWaifu.jsp");
		    	break;	
		    case "/listWaifu_PriceGoingDown_TypeBB":
		    	ShowListWaifu_Price_Going_Down_Type_BB(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_PriceGoingDown_TypeLoli":
		    	ShowListWaifu_Price_Going_Down_Type_Loli(request,response,"ShopWaifu.jsp");
		    	break;	
		    case "/sortByPriceUp":
		    	ShowListWaifu_SortByPrice_Up(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/sortByPriceUp_TypeLoli":
		    	ShowListWaifu_Price_Going_Up_Type_Loli(request,response,"ShopWaifu.jsp");
		    	break;	
		    case "/sortByPriceUp_TypeBB":
		    	ShowListWaifu_Price_Going_Up_Type_BB(request,response,"ShopWaifu.jsp");
		    	break;
		    case "/listWaifu_TypeLoli_Manage":
		    	ShowListWaifu_TypeLoli(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_TypeBB_Manage":
		    	ShowListWaifu_TypeBB(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_AgeGoingDown_Manage":
		    	ShowListWaifu_Age_GoingDown(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_AgeGoingDown_TypeBB_Manage":
		    	ShowListWaifu_Age_GoingDown_Type_BB(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_AgeGoingDown_TypeLoli_Manage":
		    	ShowListWaifu_Age_GoingDown_Type_Loli(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_AgeGoingUp_Manage":
		    	ShowListWaifu_Age_GoingUp(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_AgeGoingUp_TypeBB_Manage":
		    	ShowListWaifu_Age_GoingUp_Type_BB(request,response,"Manage.jsp");
		    	break;	
		    case "/listWaifu_AgeGoingUp_TypeLoli_Manage":
		    	ShowListWaifu_Age_GoingUp_Type_Loli(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_Name_A_Z_Manage":
		    	ShowListWaifu_Name_A_Z(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_Name_A_Z_TypeBB_Manage":
		    	ShowListWaifu_Name_A_Z_Type_BB(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_Name_A_Z_TypeLoli_Manage":
		    	ShowListWaifu_Name_A_Z_Type_Loli(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_PriceGoingDown_Manage":
		    	ShowListWaifu_Price_Going_Down(request,response,"Manage.jsp");
		    	break;	
		    case "/listWaifu_PriceGoingDown_TypeBB_Manage":
		    	ShowListWaifu_Price_Going_Down_Type_BB(request,response,"Manage.jsp");
		    	break;
		    case "/listWaifu_PriceGoingDown_TypeLoli_Manage":
		    	ShowListWaifu_Price_Going_Down_Type_Loli(request,response,"Manage.jsp");
		    	break;	
		    case "/sortByPriceUp_Manage":
		    	ShowListWaifu_SortByPrice_Up(request,response,"Manage.jsp");
		    	break;
		    case "/sortByPriceUp_TypeLoli_Manage":
		    	ShowListWaifu_Price_Going_Up_Type_Loli(request,response,"Manage.jsp");
		    	break;	
		    case "/sortByPriceUp_TypeBB_Manage":
		    	ShowListWaifu_Price_Going_Up_Type_BB(request,response,"Manage.jsp");
		    	break;
		    case "/Cart":
		    	 showNewForm(request, response, "Cart.jsp");
		    	break;
		    case "/fCartCheckOut":
		    	 showNewForm(request, response, "fCartCheckOut.jsp");
		    	break;	
		}
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
	  private void showNewForm(HttpServletRequest request, HttpServletResponse response,String form)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher(form);
			        dispatcher.forward(request, response);
			    }
	  private void InsertWaifu(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
		  try {
			        String name = request.getParameter("wName");
			        int age = Integer.parseInt(request.getParameter("wAge"));
			        String typeString = request.getParameter("wType");
			        int price = Integer.parseInt(request.getParameter("wPrice"));
			        String image  = request.getParameter("wImage");
			        waifu waifu = new waifu(name, age, typeString, price, image);
			        waifuDAO.insertWaifu(waifu);
			        response.sendRedirect("manage");
		  } catch (Exception e) {
				// TODO: handle exception
			}
			    }
	  
	  
	  private void updateAccount(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		  	try {
				
			
			     int id = Integer.parseInt( request.getParameter("id"));
			     user User = userDAO.Get_Account_By_ID(id);
			     request.setAttribute("acc", User);
			     request.getRequestDispatcher("fUpdate.jsp"). forward(request, response);
		  	} catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowUpdateWaifuForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		  	try {
				
			
			     int id = Integer.parseInt( request.getParameter("id"));
			     waifu waifu = waifuDAO.Get_Waifu_By_ID(id);
			     request.setAttribute("w", waifu);
			     request.getRequestDispatcher("FormWaifuUpdate.jsp"). forward(request, response);
		  	} catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
			  		throws SQLException, IOException {
		            int id = Integer.parseInt(request.getParameter("id"));
			        UserDAO.deleteUser(id);
			        response.sendRedirect("list");
			    }
	  private void deleteWaifu(HttpServletRequest request, HttpServletResponse response)
		  		throws SQLException, IOException {
	            int id = Integer.parseInt(request.getParameter("id"));
	            WaifuDAO.deleteWaifu(id);
		        response.sendRedirect("manage");
		    }
	  
	  private void GetUpdateAcc(HttpServletRequest request, HttpServletResponse response)
		  		throws SQLException, IOException {
	            int id = Integer.parseInt(request.getParameter("id"));
		        String taikhoan = request.getParameter("username");
		        String matkhau = request.getParameter("password");
		        user accUser = new user(id,taikhoan,matkhau);
		        userDAO.Update_Account_By_ID(accUser);
		        response.sendRedirect("list");
		    }
	  private void GetUpdateWaifu(HttpServletRequest request, HttpServletResponse response)
		  		throws SQLException, IOException {
	            int id = Integer.parseInt(request.getParameter("wId"));
		        String name = request.getParameter("wName");
		        int age = Integer.parseInt(request.getParameter("wAge"));
		        String type = request.getParameter("wType");
		        int price = Integer.parseInt(request.getParameter("wPrice"));
		        String image = request.getParameter("wImage");
		       waifu w = new waifu(id, name, age, type, price, image);
		        waifuDAO.Update_Waifu_By_ID(w);
		        response.sendRedirect("manage");
		    }
	  
	  private void ShowListWaifu(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
			  
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifu();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
		 }
	  
	  private void ShowListWaifu_TypeLoli(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
			 WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifu_Type_Loli();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_TypeBB(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifu_Type_BB();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Age_GoingDown(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Age_Going_Down();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Age_GoingDown_Type_BB(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Age_Going_Down_Type_BB();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Age_GoingDown_Type_Loli(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Age_Going_Down_Type_Loli();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Age_GoingUp(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Age_Going_Up();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Age_GoingUp_Type_BB(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Age_Going_Up_Type_BB();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Age_GoingUp_Type_Loli(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Age_Going_Up_Type_Loli();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
	  }
	  
	  private void ShowListWaifu_Name_A_Z(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Name_A_Z();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  private void ShowListWaifu_Name_A_Z_Type_BB(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Name_A_Z_Type_BB();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  
	  private void ShowListWaifu_Name_A_Z_Type_Loli(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Name_A_Z_Type_Loli();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  private void ShowListWaifu_Price_Going_Down(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Price_Going_Down();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  private void ShowListWaifu_Price_Going_Down_Type_BB(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Price_Going_Down_Type_BB();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  private void ShowListWaifu_Price_Going_Down_Type_Loli(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Price_Going_Down_Type_Loli();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  
	  
	  private void ShowListWaifu_SortByPrice_Up(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Price_Going_Up();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
			}
		  }
	  
	  
	  private void ShowListWaifu_Price_Going_Up_Type_BB(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Price_Going_Up_Type_BB();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  private void ShowListWaifu_Price_Going_Up_Type_Loli(HttpServletRequest request, HttpServletResponse response,String form)
		  		throws SQLException, IOException {
		  try {
		  WaifuDAO waifuDAO = new WaifuDAO();
			List<waifu> list = waifuDAO.getAllWaifuWith_Price_Going_Up_Type_Loli();
			request.setAttribute("listWaifu", list);
			request.getRequestDispatcher(form).forward(request, response);
		  } catch (Exception e) {
				// TODO: handle exception
		  }
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
