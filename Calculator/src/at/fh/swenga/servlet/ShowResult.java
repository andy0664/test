package at.fh.swenga.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowResult
 */
public class ShowResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResult() {
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
 
		int result=(Integer)request.getAttribute("result");
 
		String color = this.getInitParameter("color");
 
		if (color==null) {
			color="#000000";
		}
 
		String htmlContent = 
				String.format("<html><body>"
						+"<div style='color:%s'>%s + %s = %s</div>"
						+ "<a href='./index.html'>Back</a><br>\n" 
						+"</body></html>",
						color,num1Param,num2Param,result);
 
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println(htmlContent);
	}

}
