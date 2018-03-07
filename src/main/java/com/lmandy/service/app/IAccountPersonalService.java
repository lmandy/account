package com.lmandy.service.app;

import com.lmandy.bean.AccountRecord;
import com.lmandy.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 94993 on 2017/3/6.
 */
public interface IAccountPersonalService {
    /**
     * 记录消费信息
     * @param record
     * @param multipartFile
     * @return
     */
    boolean record(AccountRecord record, MultipartFile[] multipartFile);

    void getRecordsByPage(PageBean<AccountRecord> pageBean);
}
