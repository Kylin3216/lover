package tech.dreamfund.service;

import tech.dreamfund.model.Wish;

import java.util.List;

/**
 * Created by xiasu on 2017/6/29.
 */
public interface WishService {
    void  saveWish(Wish wish);
    void deleteWish(int id);
    void updateWish(Wish wish);
    Wish queryWishById(int id);
    List<Wish> queryWishByAid(int aid);
}
