package com.jxc.short_message.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MsgLoggerDao {

    @Insert({"insert into jxc_short_msg_record(phone,type,create_time,client,msg) ",
            "value (#{phone}, #{type}, now(), #{client}, #{msg})"})
    public void insert(@Param("phone")String phone, @Param("type")String type, @Param("client")String client, @Param("msg")String msg);



}
