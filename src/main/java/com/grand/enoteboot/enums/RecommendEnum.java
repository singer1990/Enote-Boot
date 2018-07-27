package com.grand.enoteboot.enums;

import java.util.Objects;

/**
 * @author GrandX
 */

public enum RecommendEnum {
    /**
     * 0:推荐,1不推荐
     */
    YES(0,"推荐"),NO(1,"不推荐");
    private Integer code;
    private String desc;

    RecommendEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public static String getDescByCode(Integer code) {
        for (RecommendEnum recommendEnum : values()) {
            if (Objects.equals(recommendEnum.getCode(), code)) {
                return recommendEnum.getDesc();
            }
        }
        return null;
    }
}
