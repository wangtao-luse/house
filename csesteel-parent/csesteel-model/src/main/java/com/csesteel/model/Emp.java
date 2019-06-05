package com.csesteel.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangtao
 * @since 2019-06-01
 */
@Data
@TableName("EMP")
public class Emp extends Model<Emp> {

private static final long serialVersionUID=1L;

    @TableId("EMPNO")
    private Integer empno;

    @TableField("ENAME")
    private String ename;

    @TableField("JOB")
    private String job;

    @TableField("MGR")
    private Integer mgr;

    @TableField("HIREDATE")
    private LocalDateTime hiredate;

    @TableField("SAL")
    private Double sal;

    @TableField("COMM")
    private Double comm;

    @TableField("DEPTNO")
    private Integer deptno;
    
    @TableField(exist = false)
    private String dname;
    
    @TableField(exist = false)
    private String loc;

  
}