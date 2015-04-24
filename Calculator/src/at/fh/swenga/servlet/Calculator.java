package at.fh.swenga.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
public class Calculator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num1Param=request.getParameter("num1");
		String num2Param=request.getParameter("num2");
		
		try{
			int num1 = Integer.parseInt(num1Param);
			int num2 = Integer.parseInt(num2Param);
			
			//calc the result and store it as an attribute in the request
			int result = num1+num2;
			request.setAttribute("result",result);
			
			//Go to the next Servlet
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/showResult");
			rd.forward(request, response);
			return;
			
		}catch(Exception ex){
			ex.printStackTrace();
			
			request.setAttribute("error", ex.getMessage());
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/showError");
			rd.forward(request, response);
			return;
		}
	}

}
