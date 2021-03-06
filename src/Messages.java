import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<Message> messages = new ArrayList<Message>();
	private String adminAddress;
	
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   		
		String formedMessages = "";    
	    
		
		//Check if there is any messages
		if (messages.size() < 1)
		{
			formedMessages = "There is no message yet."; 
		}
		
		
		//Print previous messages	
		for (Message message : messages) {
			String dateString = "<i class=\"fa fa-clock-o\" title=" + message.getSent() + " style=\"margin-right:5px;\"></i>";
					
	    	formedMessages += 
	    			"<div class=\"single-message\">" + 
	    			dateString +
	    			"<b>" + message.getAuthor(adminAddress) + "</b>: " +
	    			message.getContent() +  			
	    			"</div>";
		}
	    
	    //Set values
		request.setAttribute("message", formedMessages);
		request.setAttribute("name", getCookie(request));
	    request.getRequestDispatcher("/feedback.jsp").forward(request, response);    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");    
		String name = request.getParameter("name"); 
        String address = request.getRemoteAddr();
        
		if (!message.equals(""))
		{
			setCookie(response, name);
		
			if (messages.size() == 0 && message.equals("!admin"))
			{
				adminAddress = address;
				System.out.println("Admin: " + address);
			}
			
			if (address.equals(adminAddress))
			{
				checkCommands(message);
			}
			
			System.out.println(name + "(" + address + "): " + message);
	        if (!message.startsWith("!"))
	        {
	        	messages.add(new Message(message, name, address));
	        }		
		}
        
        response.sendRedirect("./feedback");
	}
	
	private void setCookie(HttpServletResponse response, String name)
	{
		name = name.replace(" ", "-");
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
	
	private void checkCommands(String message)
	{
		
		if (message.equals("!clear"))
		{
			messages.clear();
		}
		else if (message.equals("!spam"))
		{
			messages.remove(messages.size() - 1);
		}
	}

}
