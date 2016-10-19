package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Account;

/**
 * Servlet implementation class LogarController
 */
@WebServlet("/LogarController.do")
public class LogarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String agency = request.getParameter("agency");
		String acc = request.getParameter("account");
		String pass = request.getParameter("pass");
		Account account = null;
		RequestDispatcher view = null;
		
		try
		{
			account = Account.newAccount(agency, acc, pass);
		}
		catch(Exception e)
		{
			view = request.getRequestDispatcher("contaNaoEncontrada.html");
		}
		
		if(account != null)
		{
			view = request.getRequestDispatcher("menu.jsp");
		}
		
		view.forward(request, response);
	}

}
