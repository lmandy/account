package com.lmandy.service.app.impl;

import com.lmandy.bean.AccountFile;
import com.lmandy.bean.AccountRecord;
import com.lmandy.bean.AccountRecordFileRelation;
import com.lmandy.bean.AccountRecordTeamRelation;
import com.lmandy.dao.app.IAccountPersonalMapper;
import com.lmandy.service.app.IAccountFileService;
import com.lmandy.service.app.IAccountPersonalService;
import com.lmandy.utils.Constants;
import com.lmandy.utils.DateUtil;
import com.lmandy.utils.PageBean;
import com.lmandy.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by 94993 on 2017/3/6.
 */
@Service
@Transactional
public class IAccountPersonalServiceImpl implements IAccountPersonalService {
    @Autowired
    private DataSourceTransactionManager txManager;
    @Autowired
    private IAccountPersonalMapper personalMapper;
    @Autowired
    private IAccountFileService fileService;

    /**
     * 记录消费信息
     * @param record
     * @param multipartFile
     * @return
     */
    @Override
    public boolean record(AccountRecord record, MultipartFile[] multipartFile) {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
        TransactionStatus status = txManager.getTransaction(def); // 获得事务状态

        try {
            //个人消费
            personalMapper.add(record);
            if(multipartFile !=null && multipartFile.length>0){
                for (MultipartFile file : multipartFile) {
                    String path = Constants.baseUrl+Constants.imageUrl;
                    File f = new File(path);
                    if(!f.exists()){
                        f.mkdirs();
                    }
                    String finalFileName = UUIDUtil.getUUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                    file.transferTo(new File(f,finalFileName));

                    AccountFile accountFile = new AccountFile(null,
                            file.getOriginalFilename(),
                            Double.parseDouble(((Long)file.getSize()).toString())/1024,
                            Constants.baseUrl+Constants.imageUrl+finalFileName,UUIDUtil.getUUID(),
                            DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));

                    fileService.add(accountFile);

                    AccountRecordFileRelation relation = new AccountRecordFileRelation(null,accountFile.getId(),record.getId());

                    fileService.addFileRecordRelation(relation);
                }
            }
            txManager.commit(status);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            txManager.rollback(status);
        }

        return false;
    }

    @Override
    public void getRecordsByPage(PageBean<AccountRecord> pageBean) {
        List<AccountRecord> records = personalMapper.getListByCommon(pageBean);
        for (AccountRecord record : records) {
            //加载附件
            record.setRecordFiles(fileService.getRecordFilesByRecordId(record.getId()));
        }
        pageBean.setResults(records);
        pageBean.setTotalCount(personalMapper.getCountByCommon(pageBean));
    }
}
