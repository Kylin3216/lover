package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.DiaryDao;
import tech.dreamfund.model.Diary;
import tech.dreamfund.service.DiaryService;

import java.util.*;

/**
 * Created by Elvira on 2017/6/17.
 */
@Service
public class DiaryServiceImp implements DiaryService {
    @Autowired
    private DiaryDao diaryDao;
    @Override
    public void saveDiary(Diary diary) {
        diaryDao.saveDiary(diary);
    }

    @Override
    public void deleteDiary(int id) {
        diaryDao.deleteDiary(id);
    }

    @Override
    public Diary queryDiaryById(int id) {
        return diaryDao.queryDiaryById(id);
    }

    @Override
    public List<Diary> queryDiaryList(String num) {
        return diaryDao.queryDiaryList(num);
    }

    @Override
    public Map<Integer,Integer> queryYearList() {
        Map<Integer,Integer> map=new HashMap<>();
        for (Integer i:diaryDao.queryYearList()){
            int key=i/10000+2000;
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        return map;
    }

    @Override
    public Map<Integer,Integer> queryMonthList(String year) {
        Map<Integer,Integer> map=new HashMap<>();
        for (Integer i:diaryDao.queryMonthList(year.substring(2)+"%")){
            int key=i/100-Integer.parseInt(year.substring(2))*100;
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        return map;
    }
}
