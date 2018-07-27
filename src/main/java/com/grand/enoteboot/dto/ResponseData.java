package com.grand.enoteboot.dto;

import java.io.Serializable;

public class ResponseData implements Serializable{
    private Integer code;
    private String msg;
    private Object rows;
    private Long total;

    private ResponseData(){
    }
    private ResponseData(Object rows){
        this.code = 200;
        this.msg = "OK";
        this.rows = rows;
    }
    public ResponseData(Object rows,Long total){
        this.code = 200;
        this.msg = "OK";
        this.rows = rows;
        this.total = total;
    }
    public static ResponseData build(){
        return new ResponseData();
    }

    public static ResponseData ok(Object rows){
        return new ResponseData(rows);
    }
    public static ResponseData ok(Object rows,Long total){
        return new ResponseData(rows,total);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
