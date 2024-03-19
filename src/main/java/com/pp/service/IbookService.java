package com.pp.service;

import java.util.List;

import com.pp.pojo.Books;

public interface IbookService {
public List<Books> getallBooks();
public String storeABook(Books book);
public List<Books> getbyGenre(String Genre);
public String deleteBook(Integer bookId);
}
