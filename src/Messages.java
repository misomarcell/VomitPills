import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/feedback")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<String> messages = new ArrayList<String>();
	
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
	    
	    for (String message : messages) {
	    	formedMessages +=  message + "<br />";
		}
		request.setAttribute("message", formedMessages);           
	    request.getRequestDispatcher("/feedback.jsp").forward(request, response);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");      
        System.out.println(message);
        
        SimpleDateFormat timeStamp = new SimpleDateFormat("MM-dd HH:mm:ss");
        messages.add("[" + timeStamp.format(new Date()) + "] " + message);
        
        response.sendRedirect("./feedback");
	}

}
