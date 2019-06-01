package com.csesteel.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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


    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public LocalDateTime getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDateTime hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    protected Serializable pkVal() {
        return this.empno;
    }

    @Override
    public String toString() {
        return "Emp{" +
        "empno=" + empno +
        ", ename=" + ename +
        ", job=" + job +
        ", mgr=" + mgr +
        ", hiredate=" + hiredate +
        ", sal=" + sal +
        ", comm=" + comm +
        ", deptno=" + deptno +
        "}";
    }
}