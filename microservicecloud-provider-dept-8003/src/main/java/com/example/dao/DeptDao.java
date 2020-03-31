package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entities.Dept;
import org.apache.ibatis.annotations.Insert;

public interface DeptDao extends BaseMapper<Dept> {

    @Override
    @Insert("INSERT INTO dept(d_name, db_source) VALUES (#{dName}, DATABASE())")
    int insert(Dept dept);
}
