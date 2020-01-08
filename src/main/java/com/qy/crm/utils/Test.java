package com.qy.crm.utils;

import com.qy.crm.data.pojo.Report;

import java.text.SimpleDateFormat;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 18:00
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Report report = new Report();
        report.setOrgnization("中泰证券");
        report.setParseOrgnization("{\"short_name\": \"中泰证券\", \"id\":113}");
        report.setParseTitle("中泰证券复利防御");
        report.setTitle("中泰证券复利防御");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        report.setReportdate(df.parse("2020-01-07 00:00:00"));

        FieldUtil.getOrgnization(report);
        FieldUtil.getReportDate(report);
        FieldUtil.getTitle(report);

        String parseOrgnization = report.getParseOrgnization();
        String parseTitle = FieldUtil.cleanTitle(report.getParseTitle());
        String parseReportdate = FieldUtil.processDate(report.getParseReportdate());

        String esId = FieldUtil.getMD5(parseOrgnization + "_"
                + parseTitle + "_" + parseReportdate);
        System.out.println(esId);
    }
}
