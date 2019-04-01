package tech.dreamfund.service;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.dreamfund.model.UserDetail;

/**
 * Created by xiasu on 2017/6/4.
 */
public interface UserDetailService {
    void saveDetail(UserDetail userDetail);
    void updateDetail(UserDetail userDetail);
    UserDetail queryDetailByUid(int uid);
}
