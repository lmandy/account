package com.lmandy.appInterface;

import com.google.gson.Gson;
import com.lmandy.bean.AccountRecord;
import com.lmandy.service.app.IAccountPersonalService;
import com.lmandy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 94993 on 2017/3/6.
 * 个人
 */
@Controller
@RequestMapping("personal")
public class PersonalAccountController {

    @Autowired
    private IAccountPersonalService accountPersonalService;

    /**
     * 记录消费信息
     * @param record
     * @param multipartFile
     * @return
     */
    @RequestMapping("accounting")
    @ResponseBody
    public String accounting(AccountRecord record, MockMultipartFile[] multipartFile){
        boolean flag = accountPersonalService.record(record,multipartFile);
        if(flag){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("records")
    @ResponseBody
    public String getRecords(Integer pageNo){

        PageBean<AccountRecord> pageBean = new PageBean<>(pageNo,null,null);
        accountPersonalService.getRecordsByPage(pageBean);
        return new Gson().toJson(pageBean).toString();
    }
}
