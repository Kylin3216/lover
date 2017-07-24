package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.LoveLetterDao;
import tech.dreamfund.model.LoveLetter;
import tech.dreamfund.service.LoveLetterService;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Service
public class LoveLetterServiceImp implements LoveLetterService {
    @Autowired
    private LoveLetterDao loveLetterDao;

    @Override
    public void saveLetter(LoveLetter loveLetter) {
        loveLetterDao.saveLetter(loveLetter);
    }

    @Override
    public void deleteLetter(int id) {
        loveLetterDao.deleteLetter(id);
    }

    @Override
    public void updateLetter(LoveLetter loveLetter) {
        loveLetterDao.updateLetter(loveLetter);
    }

    @Override
    public List<LoveLetter> queryLetter(int aid, int state) {
        return loveLetterDao.queryLetter(aid, state);
    }
}
