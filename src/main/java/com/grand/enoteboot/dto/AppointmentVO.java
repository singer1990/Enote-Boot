package com.grand.enoteboot.dto;

import com.grand.enoteboot.entity.Appointment;
import com.grand.enoteboot.enums.AppointStateEnum;

/**
 * 封装预约执行后结果
 */
public class AppointmentVO {

    /** 图书ID */
    private Long bookId;

    /** 秒杀预约结果状态 */
    private Integer state;

    /**  状态标识 */
    private String stateInfo;

    /** 预约成功对象 */
    private Appointment appointment;

    public AppointmentVO() {
    }


    /**
     * @param bookId
     * @param stateEnum
     */
    public AppointmentVO(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getCode();
        this.stateInfo = stateEnum.getDesc();
    }

    // 预约成功的构造器
    public AppointmentVO(long bookId, AppointStateEnum stateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state = stateEnum.getCode();
        this.stateInfo = stateEnum.getDesc();
        this.appointment = appointment;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
