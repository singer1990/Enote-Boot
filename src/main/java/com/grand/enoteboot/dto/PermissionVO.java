package com.grand.enoteboot.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 菜单权限
 */
@Data
public class PermissionVO {
    private Long id;
    private Integer permType;
    private String name;
    private String url;
    private Long parentId;
    private Integer sortNo;
    private Integer isLeaf;
    private Integer status;
    private String description;
    private Long createId;
    private Date createTime;
    private Long updateId;
    private Date updateTime;
    private Integer isDelete;
    private List<PermissionVO> children;
}
