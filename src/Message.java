import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private String content;
	private Date sent;
	private String author;
	
	public Message(String content, String author)
	{
		this.content = content;
		this.author = author;
		this.sent = new Date();
	}

	public String getContent() {
		return content;
	}

	public String getSent() {
		SimpleDateFormat timeStamp = new SimpleDateFormat("MM-dd HH:mm:ss");
        return "[" + timeStamp.format(sent) + "] ";
	}

	public String getAuthor() {
		if (this.author.equals(""))
		{
			return "Anonymous";
		}
		return author;
	}
	
	
}
