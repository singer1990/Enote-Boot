package com.grand.enoteboot.enums;

import java.util.Objects;

/**
 * @author GrandX
 */

public enum StatusEnum {
    /**
     * 0:上架,1:下架
     */
    SHELVE(0,"上架"),UNSHELVE(1,"下架");

    private Integer code;
    private String desc;
    StatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDescByCode(Integer code) {
        for (StatusEnum statusEnum : values()) {
            if (Objects.equals(statusEnum.getCode(), code)) {
                return statusEnum.getDesc();
            }
        }
        return null;
    }
}
