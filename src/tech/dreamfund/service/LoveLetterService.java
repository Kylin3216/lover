package tech.dreamfund.service;

import tech.dreamfund.model.LoveLetter;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface LoveLetterService {
    void  saveLetter(LoveLetter loveLetter);
    void  deleteLetter(int id);
    void updateLetter(LoveLetter loveLetter);
    List<LoveLetter> queryLetter(int aid, int state);
}
