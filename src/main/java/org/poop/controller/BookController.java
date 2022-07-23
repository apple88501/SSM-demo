package org.poop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Delete;
import org.poop.pojo.Book;
import org.poop.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService service;
    final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/search/{name}")
    public String searchByName(@PathVariable String name){
        System.out.println("post search by name, name="+name);
        List<Book> books = service.searchByName(name);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            mapper.writeValue(out, books);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final byte[] data = out.toByteArray();
        System.out.println(new String(data));
        return new String(data);
    }
    @GetMapping
    public String selectAll(){
        List<Book> books = service.selectAll();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            mapper.writeValue(out, books);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final byte[] data = out.toByteArray();
        System.out.println(new String(data));
        return new String(data);
    }
    @GetMapping("/{id}")
    public String selectById(@PathVariable Integer id){
        Book book = service.selectById(id);
        String result = "";
        try {
            result = mapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping
    public String create(@RequestBody Book book){
        System.out.println(book.toString());
        Map<String, Boolean> map = new HashMap<>();
        map.put("result",service.create(book));
        String result = "";
        try {
            result = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
    @PutMapping
    public String update(@RequestBody Book book){
        Map<String, Boolean> map = new HashMap<>();
        map.put("result",service.update(book));
        String result = "";
        try {
            result = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("result",service.deleteById(id));
        String result = "";
        try {
            result = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
