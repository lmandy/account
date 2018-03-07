package com.lmandy.dao.app;

import com.lmandy.bean.AccountRecord;
import com.lmandy.bean.AccountRecordTeamRelation;
import com.lmandy.bean.AccountTeam;
import com.lmandy.bean.AccountUserTeamRelation;
import com.lmandy.dao.IBaseMapper;
import com.lmandy.utils.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 94993 on 2017/3/7.
 */
@Repository
public interface ITeamMapper extends IBaseMapper<AccountTeam> {
    /**
     * 添加群组和用户关系
     * @return
     */
    Integer addTeamUserRelation(AccountUserTeamRelation relation);

    /**
     * 获取用户所在群组
     * @param userId
     * @return
     */
    List<AccountUserTeamRelation> getGroupsByUserId(Integer userId);

    /**
     * 添加群组人员消费记录
     * @param relation
     * @return
     */
    Integer addRecordTeamRelation(AccountRecordTeamRelation relation);

    /**
     * 将用户从群组中删除
     * @param teamId
     * @param userId
     * @return
     */
    Integer deleteUserFromGroup(@Param("teamId") Integer teamId,@Param("userId") Integer userId);

    List<AccountRecord> getListByCommonFromGroup(PageBean<AccountRecord> pageBean);
    Integer getCountByCommonFromGroup(PageBean<AccountRecord> pageBean);


}
