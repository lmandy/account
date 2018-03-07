package com.lmandy.service.app.impl;

import com.lmandy.bean.AccountFile;
import com.lmandy.bean.AccountRecordFileRelation;
import com.lmandy.dao.app.IAccountFileMapper;
import com.lmandy.service.app.IAccountFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 94993 on 2017/3/6.
 */
@Service
public class IAccountFileServiceImpl implements IAccountFileService {

    @Autowired
    private IAccountFileMapper fileMapper;

    @Override
    public Integer add(AccountFile file) {
        return fileMapper.add(file);
    }

    @Override
    public Integer addFileRecordRelation(AccountRecordFileRelation relation) {
        return fileMapper.addFileRecordRelation(relation);
    }

    /**
     * 根据消费记录id加载附件
     * @param id
     * @return
     */
    @Override
    public List<AccountFile> getRecordFilesByRecordId(Integer id) {
        return fileMapper.getRecordFilesByRecordId(id);
    }
}
