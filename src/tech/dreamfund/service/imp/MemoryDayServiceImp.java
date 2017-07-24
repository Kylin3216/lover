package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.MemoryDayDao;
import tech.dreamfund.model.MemoryDay;
import tech.dreamfund.service.MemoryDayService;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Service
public class MemoryDayServiceImp implements MemoryDayService {
    @Autowired
    private MemoryDayDao memoryDayDao;
    @Override
    public void saveMemoryDay(MemoryDay memoryDay) {
        memoryDayDao.saveMemoryDay(memoryDay);
    }

    @Override
    public void deleteMemoryDay(int id) {
        memoryDayDao.deleteMemoryDay(id);
    }

    @Override
    public void updateMemoryDay(MemoryDay memoryDay) {
        memoryDayDao.updateMemoryDay(memoryDay);
    }

    @Override
    public List<MemoryDay> queryMemoryDayByAid(int aid) {
        return memoryDayDao.queryMemoryDayByAid(aid);
    }
}
