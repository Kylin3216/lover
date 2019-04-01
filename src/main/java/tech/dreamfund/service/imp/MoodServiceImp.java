package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.MoodDao;
import tech.dreamfund.model.Mood;
import tech.dreamfund.service.MoodService;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Service
public class MoodServiceImp implements MoodService {
    @Autowired
    private MoodDao moodDao;

    @Override
    public void saveMood(Mood mood) {
        moodDao.saveMood(mood);
    }

    @Override
    public void deleteMood(int id) {
        moodDao.deleteMood(id);
    }

    @Override
    public List<Mood> queryAllMood(int aid) {
        return moodDao.queryAllMoodByAid(aid);
    }
}
