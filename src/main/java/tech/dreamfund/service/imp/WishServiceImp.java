package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.WishDao;
import tech.dreamfund.model.Wish;
import tech.dreamfund.service.WishService;

import java.util.List;

/**
 * Created by xiasu on 2017/6/29.
 */
@Service
public class WishServiceImp implements WishService {
    @Autowired
    private WishDao wishDao;

    @Override
    public void saveWish(Wish wish) {
        wishDao.saveWish(wish);
    }

    @Override
    public void deleteWish(int id) {
        wishDao.deleteWish(id);
    }

    @Override
    public void updateWish(Wish wish) {
        wishDao.updateWish(wish);
    }

    @Override
    public Wish queryWishById(int id) {
        return wishDao.queryWishById(id);
    }

    @Override
    public List<Wish> queryWishByAid(int aid) {
        return wishDao.queryWishByAid(aid);
    }
}
