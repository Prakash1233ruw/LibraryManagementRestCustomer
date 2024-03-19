package com.pp.pojo;

public class Books {

private Integer bookId;	

private String ISBN;
private String title;
private String author;
private String genre;
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public Books() {
	System.out.println("Book in customer Instantiated");
}
@Override
public String toString() {
	return "Books [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", genre=" + genre + "]";
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}


}

