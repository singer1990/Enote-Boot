package com.grand.enoteboot.controller;

import com.grand.enoteboot.entity.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * 测试swagger用例
 * @author GrandX
 */
@Controller
@RequestMapping(value="/Books")
public class BookController {

    private static Map<Long, Book> Books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value="获取用户列表", notes="查询所有用户信息")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<Book> getBookList() {
        return new ArrayList<Book>(Books.values());
    }

    @ApiOperation(value="创建用户", notes="根据Book对象创建用户")
    @ApiImplicitParam(name = "Book", value = "用户详细实体Book", required = true, dataType = "Book")
    @RequestMapping(value="", method= RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        Books.put(book.getId(), book);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return Books.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的Book信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "Book", value = "用户详细实体Book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putBook(@PathVariable Long id, @RequestBody Book Book) {
        Book u = Books.get(id);
        u.setName(Book.getName());
        u.setNumber(Book.getNumber());
        Books.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        Books.remove(id);
        return "success";
    }

}
