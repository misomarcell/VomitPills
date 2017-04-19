
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<String> subscribers = new ArrayList<String>();

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	Hashtable<String, String> validUsers = new Hashtable<String, String>();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		validUsers.put("admin:s3cr3t","authorized");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String auth = request.getHeader("Authorization");
		if (!allowUser(auth)) {
			response.setHeader("WWW-Authenticate", "BASIC realm=\"Admin area!\"");
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		} else {
			System.out.println("Ok!");
		}

		request.setAttribute("subscribers", getFormedSubscribers());
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	protected boolean allowUser(String auth) throws IOException {

		if (auth == null) {
			return false;
		}

		if (!auth.toUpperCase().startsWith("BASIC ")) {
			return false;
		}

		String userpassEncoded = auth.substring(6);
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		String userpassDecoded = new String(dec.decodeBuffer(userpassEncoded));

		if ("authorized".equals(validUsers.get(userpassDecoded))) {
			return true;
		} else {
			return false;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	private String getFormedSubscribers() {
		String result = "";
		for (String subscriber : subscribers) {
			result += "<li>" + subscriber + "</li>";
		}

		return result;
	}
}
