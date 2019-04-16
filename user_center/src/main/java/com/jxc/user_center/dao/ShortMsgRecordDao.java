package com.jxc.user_center.dao;

import java.util.List;
import java.util.Map;

import com.jxc.user_center.entity.ShortMsgRecord;



public interface ShortMsgRecordDao {
    
    List<ShortMsgRecord> queryShortMsgRecordListByCondition(Map<String, Object> condtion);
    
}
