package com.csesteel.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangtao
 * @since 2019-06-02
 */
@Data
@TableName("DEPT")
public class Dept extends Model<Dept> {

private static final long serialVersionUID=1L;

    @TableId("DEPTNO")
    private Integer deptno;

    @TableField("DNAME")
    private String dname;

    @TableField("LOC")
    private String loc;

}
