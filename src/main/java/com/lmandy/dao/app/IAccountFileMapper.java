package com.lmandy.dao.app;

import com.lmandy.bean.AccountFile;
import com.lmandy.bean.AccountRecordFileRelation;
import com.lmandy.dao.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 94993 on 2017/3/6.
 */
@Repository
public interface IAccountFileMapper extends IBaseMapper<AccountFile>{
    Integer addFileRecordRelation(AccountRecordFileRelation relation);

    /**
     * 根据消费记录id加载附件
     * @param id
     * @return
     */
    List<AccountFile> getRecordFilesByRecordId(Integer id);
}
