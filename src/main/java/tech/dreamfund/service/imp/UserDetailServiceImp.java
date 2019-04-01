package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.UserDetailDao;
import tech.dreamfund.model.UserDetail;
import tech.dreamfund.service.UserDetailService;

/**
 * Created by xiasu on 2017/6/4.
 */
@Service
public class UserDetailServiceImp implements UserDetailService {
    @Autowired
    private UserDetailDao userDetailDao;

    @Override
    public void saveDetail(UserDetail userDetail) {
        userDetailDao.saveDetail(userDetail);
    }

    @Override
    public void updateDetail(UserDetail userDetail) {
        userDetailDao.updateDetail(userDetail);
    }

    @Override
    public UserDetail queryDetailByUid(int uid) {
        return userDetailDao.queryDetailByUid(uid);
    }
}
