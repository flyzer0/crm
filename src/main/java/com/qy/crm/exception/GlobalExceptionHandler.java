package com.qy.crm.exception;

import com.alibaba.fastjson.JSONObject;
import com.qy.crm.data.pojo.common.Desc;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("errorInfo",e);
        JSONObject jsonObject = new JSONObject();
        Desc desc = new Desc();
        desc.setCode("2");
        desc.setDescription(e.getMessage());
        jsonObject.put("status","2");
        jsonObject.put("desc",desc);
        return jsonObject;
    }

}
