package dangdang.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book extends Product implements java.io.Serializable {
	private String author;
	private String publishing;
	private Long publishTime;
	private String wordNumber;
	private String whichEdtion;
	private String totalPage;
	private Long printTime;
	private String isbn;
	private String authorSummary;
	private String catalogue;
	private String publishnyr;
	private static SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
	public Book() {
	}
	public Book(String author, String publishing, Long publishTime,
			String wordNumber, String whichEdtion, String totalPage,
			Long printTime, String isbn, String authorSummary, String catalogue) {
		this.author = author;
		this.publishing = publishing;
		this.publishTime = publishTime;
		this.wordNumber = wordNumber;
		this.whichEdtion = whichEdtion;
		this.totalPage = totalPage;
		this.printTime = printTime;
		this.isbn = isbn;
		this.authorSummary = authorSummary;
		this.catalogue = catalogue;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	public String getWordNumber() {
		return wordNumber;
	}
	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}
	public String getWhichEdtion() {
		return whichEdtion;
	}
	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public Long getPrintTime() {
		return printTime;
	}
	public void setPrintTime(Long printTime) {
		this.printTime = printTime;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthorSummary() {
		return authorSummary;
	}
	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getPublishnyr() {
		Date date = new Date(this.getPublishTime());
		String s = f.format(date);
		return s;
	}
	public void setPublishnyr(String publishnyr) {
		this.publishnyr = publishnyr;
	}

	

}