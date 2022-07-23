package org.poop.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.poop.pojo.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookDao {
    @Select("select * from book;")
    List<Book> selectAll();
    @Select("select * from book where id = #{id}")
    Book selectById(Integer id);
    @Insert("insert into book (type,name,description) values (#{type},#{name},#{description})")
    void create(Book book);
    @Update("update book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    void update(Book book);
    @Delete("delete from book where id=#{id}")
    void deleteById(Integer id);
    @Select("select * from book where name like CONCAT('%',#{name},'%')")
    List<Book> searchByName(String name);
}
