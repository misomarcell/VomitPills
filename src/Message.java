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
		return content;
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
