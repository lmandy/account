package com.lmandy.service.app.impl;

import com.lmandy.bean.AccountUser;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 94993 on 2017/3/12.
 */
public interface IAPPUserService {
    boolean register(AccountUser user, MultipartFile multipartFile);
    AccountUser getUserByToken(String token);
    AccountUser getByName(String userName);
}
