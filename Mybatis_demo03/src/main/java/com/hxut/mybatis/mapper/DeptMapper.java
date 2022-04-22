package com.hxut.mybatis.mapper;

import com.hxut.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author weijiangquan
 * @date 2022/4/21 -18:12
 */
public interface DeptMapper {

    /**
     * 分布查询的第二步,通过did查询员工对应的部门信息
     */

    Dept getEmpAndDeptByStepTWo(@Param("did") Integer did);


    /**
     * 部门以及部门种所有的员工信息
     *
     */
    Dept getDeptAndEmp(@Param("did") Integer did);


}
