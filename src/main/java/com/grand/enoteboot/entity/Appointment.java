package com.grand.enoteboot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 预约图书实体
 */
@Data
public class Appointment {
    /**
     * 主键ID
     */
    private long id;

    /**
     * 图书ID
     */
    private long bookId;

    /**
     * 学号
     */
    private long studentId;

    /**
     * 预约时间
     */
    private Date appointTime;

    /**
     * 图书实体
     */
    private Book book;
}
