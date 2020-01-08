package com.qy.crm.utils;

import com.alibaba.fastjson.JSONObject;
import com.qy.crm.data.pojo.Report;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 17:02
 * @Description TODO
 */
@Slf4j
public class FieldUtil {
    public static String getMD5(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为十六进制数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("Error to compute MD5", e);
        }
        return null;
    }

    public static void getOrgnization(Report report) {
        String parseOrgnization = report.getParseOrgnization();
        if(Objects.isNull(parseOrgnization)){
            report.setParseOrgnization(report.getOrgnization());
            return;
        }
        JSONObject orgnizationJson = JSONObject.parseObject(parseOrgnization);
        String orgnization = orgnizationJson.getString("short_name");
        if (!org.apache.commons.lang3.StringUtils.isBlank(orgnization)) {
            report.setParseOrgnization(orgnization);
        } else {
            report.setParseOrgnization(report.getOrgnization());
        }
    }

    public static void getTitle(Report report){
        String title = report.getTitle();
        if(!StringUtils.isBlank(title)){
            report.setParseTitle(title.trim());
        }else{
            report.setParseTitle(report.getParseTitle().trim());
        }
    }

    public static void getReportDate(Report report) {
        Date reportdate=report.getReportdate();
        if (Objects.nonNull(reportdate)) {
            report.setParseReportdate(reportdate);
        }
    }

    public static String cleanTitle(String title){
        String reg = "[^\\u4e00-\\u9fa5^\\w]";
        title = title.replaceAll(reg, "");
        return title;
    }

    public static String processDate(Date date){
        SimpleDateFormat newF = new SimpleDateFormat("YYYYMMDD");
        return newF.format(date);
    }
}
