package org.poop.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.poop.pojo.Book;

import java.util.List;

public interface Service {
    List<Book> selectAll();
    Book selectById(Integer id);
    boolean create(Book book);
    boolean update(Book book);
    boolean deleteById(Integer id);
    List<Book> searchByName(String name);
}
