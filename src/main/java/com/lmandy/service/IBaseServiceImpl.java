package com.lmandy.service;

import com.lmandy.dao.IBaseMapper;
import com.lmandy.utils.PageBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by 94993 on 2017/3/21.
 */
public abstract class IBaseServiceImpl<T> implements IBaseService<T>{

    public abstract IBaseMapper<T> getBaseMapper();

    private Class<T> clazz;

    public IBaseServiceImpl() {
        super();
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) type;
        this.clazz = (Class<T>) ptype.getActualTypeArguments()[0];
    }

    @Override
    public T getById(Integer id){
        return getBaseMapper().getById(id);
    }
    @Override
    public T getByName(String name){
        return getBaseMapper().getByName(name);
    }
    @Override
    public Integer add(T t){
        return getBaseMapper().add(t);
    }
    @Override
    public Integer update(T t){
        return getBaseMapper().update(t);
    }
    @Override
    public Integer delete(Integer id) {
        return getBaseMapper().delete(id);
    }
    @Override
    public void indexInfo(PageBean<T> pageBean){
        pageBean.setResults(getBaseMapper().getListByCommon(pageBean));
        pageBean.setTotalCount(getBaseMapper().getCountByCommon(pageBean));
    }

}
