package com.lmandy.service;

import com.lmandy.utils.PageBean;

/**
 * Created by 94993 on 2017/3/6.
 */
public interface IBaseService <T>{
    T getById(Integer id);
    T getByName(String name);
    Integer add(T t);
    Integer update(T t);
    Integer delete(Integer id);
    void indexInfo(PageBean<T> pageBean);
}
