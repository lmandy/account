package com.lmandy.service.app;

import com.lmandy.bean.AccountFile;
import com.lmandy.bean.AccountRecordFileRelation;

import java.util.List;

/**
 * Created by 94993 on 2017/3/6.
 */
public interface IAccountFileService {
    Integer add(AccountFile file);
    Integer addFileRecordRelation(AccountRecordFileRelation relation);
    List<AccountFile> getRecordFilesByRecordId(Integer id);
}
