package com.pp.service;

import java.net.URI;
import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pp.pojo.Books;

@Service
public class BookService implements IbookService{

	private static final String URI = "http://localhost:8787/LibraryManagementAPP/api/getAllBooks";
	private static final String URI2 = "http://localhost:8787/LibraryManagementAPP/api/booksave";
	private static final String URI3 = "http://localhost:8787/LibraryManagementAPP/api/getBookByGenre/{genre}";
	private static final String URI4 = "http://localhost:8787/LibraryManagementAPP/api/delete/{id}";
	@Override
	public List<Books> getallBooks() {
		RestTemplate template=new RestTemplate();
		//ResponseEntity<Books> response = template.getForEntity(URI, Books.class);
		ResponseEntity<List<Books>> response = template.exchange(URI, HttpMethod.GET,null,new ParameterizedTypeReference<List<Books>>() {});
		return  response.getBody();
	}

	@Override
	public String storeABook(Books book) {
		RestTemplate template=new RestTemplate();
		
		ResponseEntity<Books> response = template.postForEntity(URI2, book, Books.class);
		
		return "data stored";
	}

	@Override
	public List<Books> getbyGenre(String genre) {
		RestTemplate template=new RestTemplate();
		ResponseEntity<List<Books>> response = template.exchange(URI3, HttpMethod.GET,null,new ParameterizedTypeReference<List<Books>>() {},genre);
	      return response.getBody(); 
	}

	@Override
	public String deleteBook(Integer bookId) {
		RestTemplate template=new RestTemplate();
		 template.delete(URI4, bookId);
		 return "deleted";
	}

	
}
