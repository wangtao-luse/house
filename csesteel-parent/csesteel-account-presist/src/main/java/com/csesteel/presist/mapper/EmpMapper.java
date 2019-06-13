package com.csesteel.presist.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csesteel.model.Emp;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangtao
 * @since 2019-06-01
 */
public interface EmpMapper  extends BaseMapper<Emp> {
List<Emp> selectEmpWidthDept(Emp emp);
}