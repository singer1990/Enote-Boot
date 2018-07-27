package com.grand.enoteboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GrandX
 */
@Data
public class User implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long createId;
    private Date createTime;
    private Long updateId;
    private Date updateTime;
    private Date lastLoginTime;
    private Integer status;
    private Integer isDelete;
}
