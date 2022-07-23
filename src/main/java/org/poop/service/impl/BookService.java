package org.poop.service.impl;

import org.poop.dao.BookDao;
import org.poop.pojo.Book;
import org.poop.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class BookService implements Service {
    @Autowired
    BookDao dao;
    @Override
    public List<Book> selectAll() {
        List<Book> books = dao.selectAll();
        return books;
    }

    @Override
    public Book selectById(Integer id) {
        Book book = dao.selectById(id);
        return book;
    }

    @Override
    public boolean create(Book book) {
        try{
            dao.create(book);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Book book) {
        try{
            dao.update(book);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try{
            dao.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Book> searchByName(String name) {
        try{
            return dao.searchByName(name);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
