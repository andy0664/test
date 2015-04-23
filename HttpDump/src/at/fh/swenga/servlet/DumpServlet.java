package at.fh.swenga.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DumpServlet
 */
public class DumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DumpServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
 
		// -----------------------------------------------------------------
		// dump all parameters
		// -----------------------------------------------------------------
		out.println("<h1>Parameters</h1>");
		Enumeration<String> parameterNames = request.getParameterNames();
		if (parameterNames != null) {
			while (parameterNames.hasMoreElements()) {
				String paramName = parameterNames.nextElement();
				String paramValue = request.getParameter(paramName);
				String[] paramValues = request.getParameterValues(paramName);
 
				out.println(paramName + ":" + paramValue + "<br>");
				out.println(paramName + ":" + Arrays.toString(paramValues)
						+ "<br>");
 
			} // while
		} else {
			out.println("No parameters<br>");
		}
 
		out.println("<br><br>");
 
		// -----------------------------------------------------------------
		// dump all headers
		// -----------------------------------------------------------------
		out.println("<h1>Headers</h1>");
		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				String headerValue = request.getHeader(headerName);
				out.println(headerName + ":" + headerValue + "<br>");
			} // while
		} else {
			out.println("No headers<br>");
		}
		out.println("<br><br>");
 
		// -----------------------------------------------------------------
		// dump all cookies
		// -----------------------------------------------------------------
		out.println("<h1>Cookies</h1>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				out.println(cookies[i].getName() + "<br>");
				out.println(cookies[i].getValue() + "<br><br>");
			}
		} else {
			out.println("No Cookies<br>");
		}
		out.println("<br><br>");
 
	}
}
