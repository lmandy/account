package com.lmandy.appInterface;

import com.google.gson.Gson;
import com.lmandy.bean.AccountRecord;
import com.lmandy.bean.AccountTeam;
import com.lmandy.bean.AccountUserTeamRelation;
import com.lmandy.service.app.IAccountPersonalService;
import com.lmandy.service.app.ITeamService;
import com.lmandy.utils.PageBean;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by 94993 on 2017/3/7.
 */
@RequestMapping("team")
@Controller
public class TeamAccountController {

    @Autowired
    private ITeamService teamService;

    /**
     * 新建群组
     * @param team
     * @return
     */
    @ResponseBody
    @RequestMapping("addGroup")
    public String addGroup(AccountTeam team){
        boolean flag = teamService.addGroup(team);
        if(flag){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 添加用户进群组
     * @param teamId
     * @param userId
     * @return
     */
    @RequestMapping("addUserToGroup")
    @ResponseBody
    public String addUserToGroup(Integer teamId,Integer userId){
        boolean flag = teamService.addUserToGroup(teamId,userId);
        if (flag)
            return "succes";
        else
            return "fail";
    }
    @ResponseBody
    @RequestMapping("delUserFromGroup")
    public String delUserFromGroup(Integer teamId,Integer userId){
        boolean flag = teamService.deleteUserFromGroup(teamId, userId);
        if (flag)
            return "succes";
        else
            return "fail";
    }

    /**
     * 获取用户所在群组信息
     * @param userId
     * @return
     */
    @RequestMapping("getGroupsByUserId")
    @ResponseBody
    public String getGroupsByUserId(Integer userId){
        Map<String, List<AccountUserTeamRelation>> map = teamService.getGroupsByUserId(userId);
        return new Gson().toJson(map).toString();
    }

    /**
     * 记录消费信息
     * @param record
     * @param multipartFile
     * @param teamId
     * @return
     */
    @RequestMapping("accounting")
    @ResponseBody
    public String accounting(AccountRecord record, MockMultipartFile[] multipartFile,Integer teamId){
        boolean flag = teamService.record(record,multipartFile,teamId);
        if(flag){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 获取团体用户消费记录
     * @param teamId
     * @param userId
     * @param pageNo
     * @return
     */
    @RequestMapping("records")
    @ResponseBody
    public String records(Integer teamId,Integer userId,Integer pageNo){
        Map<String,Object> conMap = new HashedMap(){{
            put("teamId",teamId);
            put("userId",userId);
        }};
        PageBean<AccountRecord> pageBean = new PageBean<>(pageNo,null,conMap);
        teamService.getRecordsByPage(pageBean);

        return new Gson().toJson(pageBean).toString();
    }

}
