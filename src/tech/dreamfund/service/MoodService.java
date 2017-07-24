package tech.dreamfund.service;

import tech.dreamfund.model.Mood;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface MoodService {
    void saveMood(Mood mood);
    void deleteMood(int id);
    List<Mood> queryAllMood(int aid);
}
