import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private String content;
	private Date sent;
	private String author;
	private String address;
	
	public Message(String content, String author, String address)
	{
		this.content = content;
		this.author = author;
		this.sent = new Date();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getContent() {
		if (content.startsWith("https://www.youtube.com/watch?v=") && content.length() < 50)
		{
			return "<br/><iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/" + content.replace("https://www.youtube.com/watch?v=", "") + "?rel=0&amp;controls=1&amp;showinfo=0\" frameborder=\"0\"></iframe>";
		}
		return content.replace("<", "&lt;");
	}

	public String getSent() {
		SimpleDateFormat timeStamp = new SimpleDateFormat("HH:mm:ss");
        return timeStamp.format(sent);
	}

	public String getAuthor() {
		if (this.author.equals(""))
		{
			return "Anonymous";
		}	
		return author;
	}
	
	public String getAuthor(String adminAddress)
	{
		if (address.equals(adminAddress))
		{
			return "<font color=\"red\" title=\"Admin\">" + author + "</font>";
		}
		return author;
	}
	
}
