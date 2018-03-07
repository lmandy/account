package com.lmandy.service.app.impl;

import com.lmandy.bean.AccountFile;
import com.lmandy.bean.AccountUser;
import com.lmandy.dao.app.IAPPUserMapper;
import com.lmandy.utils.Constants;
import com.lmandy.utils.DateUtil;
import com.lmandy.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by 94993 on 2017/3/12.
 */
@Service
@Transactional
public class IAPPUserServiceImpl implements IAPPUserService {

    @Autowired
    private IAPPUserMapper iappUserMapper;

    @Override
    public boolean register(AccountUser user, MultipartFile file) {
        if(file != null){
            String path = Constants.baseUrl+Constants.userImgUrl;
            File f = new File(path);
            if(!f.exists()){
                f.mkdirs();
            }
            String finalFileName  = UUIDUtil.getUUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            try {
                file.transferTo(new File(f,finalFileName));
            }catch (Exception e){
                e.printStackTrace();
            }

            user.setPortrait(finalFileName);
        }
        user.setToken(UUIDUtil.getUUID());
       return iappUserMapper.add(user) >0 ? true:false;
    }

    @Override
    public AccountUser getUserByToken(String token) {
        AccountUser accountUser = iappUserMapper.getByToken(token);
        if(accountUser !=null && StringUtils.isNotBlank(accountUser.getPortrait())){
            accountUser.setPortrait(Constants.visitUrl+Constants.userImgUrl+accountUser.getPortrait());
        }
        return accountUser;
    }

    @Override
    public AccountUser getByName(String userName) {
        AccountUser user = iappUserMapper.getByName(userName);
        if(user !=null && StringUtils.isNotBlank(user.getPortrait())){
            user.setPortrait(Constants.visitUrl+Constants.userImgUrl+user.getPortrait());
        }
        return user;
    }
}
