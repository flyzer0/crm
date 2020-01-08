package com.qy.crm.exception;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 16:50
 * @Description TODO
 */
public class BusinessException extends Exception{



    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String businessMessage, Throwable exception){
        super(businessMessage + ":[" + exception.getMessage() + "]");
    }

}
