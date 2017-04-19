import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Subscribe")
public class Subscribe extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        String email = request.getParameter("email");      
        Admin.subscribers.add(email);
        
        PrintWriter writer = response.getWriter();      
        String htmlRespone = "<html><h2>You successfully subscribed to the newsletter! ( " + email + " )</h2>";
        htmlRespone += "<a href='index.html'>Go back...</a></html>";
        writer.println(htmlRespone);
       
    }

	
	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("Started...");
	}
	
}
