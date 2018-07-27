package com.grand.enoteboot.entity;

import lombok.Data;

/**
 *
 * @author GrandX
 */
@Data
public class Book {

    /** 图书ID */
    private Long id;

    /** 图书名称 */
    private String name;

    /** 馆藏数量 */
    private Integer number;

}
