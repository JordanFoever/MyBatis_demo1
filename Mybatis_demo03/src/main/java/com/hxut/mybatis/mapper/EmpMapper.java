package com.hxut.mybatis.mapper;

import com.hxut.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/21 -18:12
 */
public interface EmpMapper {

    /**
     * 查询所有的员工信息
     */


    List<Emp> getAllEmp();


    /**
     * 查询员工以及员工多对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);


    /***
     * 通过分布查询查询员工以及员工所对应的部门信息
     * 分布查询的第一步(不需要用连表查询)
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
}
