package com.grand.enoteboot.entity;

public class Singleton {
    //private Singleton(){}
    //private static Singleton instance = new Singleton();
    //public static Singleton getInstance(){
    //    return instance;
    //}
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
            return instance;
        }else {
            return instance;
        }
    }
}
