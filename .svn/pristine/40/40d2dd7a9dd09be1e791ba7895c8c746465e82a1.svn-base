package com.jxc.common.dao;

import com.jxc.common.bean.KvOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KvOptionDao {

    @Select("select option_key as optionKey, option_value as optionValue from jxc_kv_option where option_key = #{optionKey}")
    public KvOption getKvOption(@Param("optionKey")String optionKey);

}
