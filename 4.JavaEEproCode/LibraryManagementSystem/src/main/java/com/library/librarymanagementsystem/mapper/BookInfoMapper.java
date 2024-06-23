package com.library.librarymanagementsystem.mapper;

import com.library.librarymanagementsystem.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    /**
     *
     * @param offset
     * @param pageSize
     * @return
     */
    @Select("select * from book_info where status != 0 order by id desc limit #{offset},#{pageSize}")
    List<BookInfo> selectBookInfoByPage(Integer offset, Integer pageSize);

    @Select("select count(1) from book_info where status !=0")
    Integer count();

    @Insert("insert into book_info (book_name,author,count,price,publish,status)" +
            "values (#{bookName}, #{author}, #{count}, #{price}, #{publish},#{status})")
    Integer insertBook(BookInfo bookInfo);

    @Select("select * from book_info where id=#{id}")
    BookInfo selectBookById(Integer id);

    @Select("select * from book_info where name=#{name}")
    BookInfo selectBookByName(String name);

    // xml
    Integer updateBook(BookInfo bookInfo);


    Integer batchDelete(List<Integer> ids);
}
