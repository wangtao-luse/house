package com.csesteel.presist.mapper;

import java.util.List;

import com.csesteel.model.Dept;


public interface DeptMapper {
    int deleteByPrimaryKey(Short deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Short deptno);
    
    List<Dept> selectDepts(Dept record);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}

