package com.lmandy.dao.backstage;

import com.lmandy.bean.AccountSystemUser;
import com.lmandy.dao.IBaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by 94993 on 2017/2/26.
 */
@Repository
public interface ISystemUserMapper extends IBaseMapper<AccountSystemUser> {

}
