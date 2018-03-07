package com.lmandy.dao;

import com.lmandy.utils.PageBean;

import java.util.List;

/**
 * Created by 94993 on 2017/3/1.
 */
public interface IBaseMapper <T> {
    T getById(Integer id);
    T getByName(String name);
    T getByToken(String token);
    Integer add(T t);
    Integer update(T t);
    Integer delete(Integer id);
    List<T> getListByCommon(PageBean<T> pageBean);
    Integer getCountByCommon(PageBean<T> pageBean);
}
