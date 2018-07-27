package com.grand.enoteboot.enums;

public enum AppointStateEnum {
    /**
     * 0,库存不足 1,预约成功 2,重复预约 3,系统异常
     */
    UNDERSTOCK(0,"库存不足"),SUCCESS(1,"预约成功"),REPEAT(2,"重复预约"),ERROR(3,"系统异常");

    private int code;
    private String desc;
    AppointStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
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

    public static AppointStateEnum getStatusByCode(int index) {
        for (AppointStateEnum state : values()) {
            if (state.getCode() == index) {
                return state;
            }
        }
        return null;
    }
}
