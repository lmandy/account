package com.lmandy.service.app.impl;

import com.lmandy.bean.AccountRecord;
import com.lmandy.bean.AccountRecordTeamRelation;
import com.lmandy.bean.AccountTeam;
import com.lmandy.bean.AccountUserTeamRelation;
import com.lmandy.dao.app.ITeamMapper;
import com.lmandy.service.app.IAccountFileService;
import com.lmandy.service.app.IAccountPersonalService;
import com.lmandy.service.app.ITeamService;
import com.lmandy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 94993 on 2017/3/7.
 */
@Service
@Transactional
public class ITeamServiceImpl implements ITeamService {
    @Autowired
    private DataSourceTransactionManager txManager;
    @Autowired
    private ITeamMapper teamMapper;

    @Autowired
    private IAccountPersonalService personalService;
    @Autowired
    private IAccountFileService fileService;
    /**
     * 添加群组
     * @param team
     * @return
     */
    @Override
    public boolean addGroup(AccountTeam team) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
        TransactionStatus status = txManager.getTransaction(def); // 获得事务状态

        try {
            teamMapper.add(team);
            //添加关联关系
            AccountUserTeamRelation relation = new AccountUserTeamRelation(null,team.getUserId(),team.getId(),1);
            addTeamUserRelation(relation);
            txManager.commit(status);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            txManager.rollback(status);
        }
        return false;
    }

    /**
     * 添加用户和群组之间关系
     * @param relation
     * @return
     */
    @Override
    public Integer addTeamUserRelation(AccountUserTeamRelation relation) {
        return teamMapper.addTeamUserRelation(relation);
    }

    /**
     * 记录群体消费
     * @param record
     * @param multipartFile
     * @param teamId
     * @return
     */
    @Override
    public boolean record(AccountRecord record, MockMultipartFile[] multipartFile, Integer teamId) {
        boolean flag = personalService.record(record, multipartFile);
        if(flag){
            //团体消费
            if(record.getSigle().equals("2")){
                AccountRecordTeamRelation relation = new AccountRecordTeamRelation(null,record.getId(),teamId);
                teamMapper.addRecordTeamRelation(relation);
            }
        }
        return true;
    }

    /**
     * 添加用户进群组
     * @param teamId
     * @param userId
     * @return
     */
    @Override
    public boolean addUserToGroup(Integer teamId, Integer userId) {
        AccountUserTeamRelation relation = new AccountUserTeamRelation(null,userId,teamId,0);
        return addTeamUserRelation(relation)>0 ? true:false;
    }

    /**
     * 将用户从群组中删除
     * @param teamId
     * @param userId
     * @return
     */
    @Override
    public boolean deleteUserFromGroup(Integer teamId, Integer userId) {
        return teamMapper.deleteUserFromGroup(teamId,userId)>0 ? true:false;
    }

    @Override
    public void getRecordsByPage(PageBean<AccountRecord> pageBean) {
        List<AccountRecord> records = teamMapper.getListByCommonFromGroup(pageBean);
        for (AccountRecord record : records) {
            //加载附件
            record.setRecordFiles(fileService.getRecordFilesByRecordId(record.getId()));
        }
        pageBean.setResults(records);
        pageBean.setTotalCount(teamMapper.getCountByCommonFromGroup(pageBean));
    }

    /**
     * 获取用户所在群组
     * @param userId
     * @return
     */
    @Override
    public Map<String,List<AccountUserTeamRelation>> getGroupsByUserId(Integer userId) {
        Map<String,List<AccountUserTeamRelation>> map = new HashMap<>();
        List<AccountUserTeamRelation> teamRelations = teamMapper.getGroupsByUserId(userId);
        for (AccountUserTeamRelation teamRelation : teamRelations) {
            if(map.containsKey(teamRelation.getName())){
                map.get(teamRelation.getName()).add(teamRelation);
            }else{
                map.put(teamRelation.getName(),teamRelations);
            }
        }

        return map;
    }
}
