package tech.dreamfund.service;

import tech.dreamfund.model.MemoryDay;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface MemoryDayService {
    void saveMemoryDay(MemoryDay memoryDay);
    void deleteMemoryDay(int id);
    void updateMemoryDay(MemoryDay memoryDay);
    List<MemoryDay> queryMemoryDayByAid(int aid);
}
