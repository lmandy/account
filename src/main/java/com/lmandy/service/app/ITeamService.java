package com.lmandy.service.app;

import com.lmandy.bean.AccountRecord;
import com.lmandy.bean.AccountTeam;
import com.lmandy.bean.AccountUserTeamRelation;
import com.lmandy.utils.PageBean;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by 94993 on 2017/3/7.
 */
public interface ITeamService {
    boolean addGroup(AccountTeam team);
    Map<String,List<AccountUserTeamRelation>> getGroupsByUserId(Integer userId);
    Integer addTeamUserRelation(AccountUserTeamRelation relation);

    boolean record(AccountRecord record, MockMultipartFile[] multipartFile, Integer teamId);

    boolean addUserToGroup(Integer teamId, Integer userId);

    boolean deleteUserFromGroup(Integer teamId,Integer userId);

    void getRecordsByPage(PageBean<AccountRecord> pageBean);
}
