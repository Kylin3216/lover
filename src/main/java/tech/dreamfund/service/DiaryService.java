package tech.dreamfund.service;

import tech.dreamfund.model.Diary;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Elvira on 2017/6/17.
 */
public interface DiaryService {
    void saveDiary(Diary diary);
    void deleteDiary(int id);
    Diary queryDiaryById(int id);
    List<Diary> queryDiaryList(String num);
    Map<Integer,Integer> queryYearList();
    Map<Integer,Integer> queryMonthList(String year);
}
