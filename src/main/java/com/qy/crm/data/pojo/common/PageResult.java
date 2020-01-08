package com.qy.crm.data.pojo.common;

import java.util.List;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 14:39
 * @Description TODO
 */
public class PageResult<T> {
    List<T> list;
    long total;

    public PageResult() {
    }

    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
