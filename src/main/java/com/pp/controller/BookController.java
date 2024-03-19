package com.pp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pp.pojo.Books;
import com.pp.service.IbookService;



@Controller
public class BookController {
	@Autowired
private IbookService service;

	@GetMapping("/getAll")
public String getLibrary( Model model) {
	List<Books> allBook = service.getallBooks();
	allBook.forEach(book->System.out.println(book));
	model.addAttribute("allBooks", allBook);
	return "BooksList";
}
	
	@GetMapping("/oneBook")
	public String oneBook(Model model) {
		
		model.addAttribute("book", new Books());
		return "showForm";
	}
	
	@PostMapping("/storeBook")
	public String storeBook(@ModelAttribute Books book) {
		service.storeABook(book);
		
		return "redirect:/getAll";
	}
	
	
	@GetMapping("/searchGenre")
	public String searchGenre(Model model) {
		model.addAttribute("book",new Books() );
		return "search1";
	}
	@GetMapping("/search")
	public String getBooks(@RequestParam String genre,Model model)
	{
	 List<Books> response = service.getbyGenre(genre);
		model.addAttribute("genreData", response);
		return "search1";
	}

	@GetMapping("/deleteBook")
	public String removeBook(@RequestParam Integer bookId) {
		service.deleteBook(bookId);
		return "redirect:/getAll";
	}
	
}
