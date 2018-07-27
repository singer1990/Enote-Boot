package com.grand.enoteboot.dao;

import com.grand.enoteboot.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GrandX
 */
public interface BookDao {
    /**
     * queryById: 根据ID查询图书信息
     * @param id 图书编号
     * @return Book
     */
    Book queryById(Long id);

    /**
     * queryAll: 分页查询所有图书信息
     * @param offset 起始
     * @param limit 条数
     * @return List
     */
    List<Book> queryAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * reduceNumber: 根据ID减少图书存量
     * @param id 图书编号
     * @return  如果影响行数等于>1，表示更新的记录行数
     */
    Integer reduceNumber(Long id);
}
