import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/feedback")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<Message> messages = new ArrayList<Message>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   		
		String formedMessages = "";    
	    
		
		//Check if there is any messages
		if (messages.size() < 1)
		{
			formedMessages = "There is no message yet."; 
		}
		
		
		//Print previous messages
		for (Message message : messages) {
	    	formedMessages += 
	    			"<div class=\"single-message\">" + 
	    			message.getSent() +
	    			"<b>" + message.getAuthor() + "</b>: " +
	    			message.getContent() +    			
	    			"</div>";
		}
	    
	    //Set values
		request.setAttribute("message", formedMessages);
		request.setAttribute("name", getCookie(request));
	    request.getRequestDispatcher("/feedback.jsp").forward(request, response);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");    
		String name = request.getParameter("name"); 
        
		if (!message.equals(""))
		{
			setCookie(response, name);
			
			System.out.println(name + ": " + message);
	        messages.add(new Message(message, name));
		}
        
        response.sendRedirect("./feedback");
	}
	
	private void setCookie(HttpServletResponse response, String name)
	{
		Cookie cookie = new Cookie("name", name);
		response.addCookie(cookie);
	}
	
	private String getCookie(HttpServletRequest request)
	{	
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("name"))
				{	
					return cookie.getValue(); 
				}        	
			}
			return "";
		}
		return "";
	}

}
