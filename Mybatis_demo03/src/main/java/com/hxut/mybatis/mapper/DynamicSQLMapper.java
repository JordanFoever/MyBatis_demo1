package com.hxut.mybatis.mapper;

import com.hxut.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/21 -22:23
 */
public interface DynamicSQLMapper{
    /**
     * 多条件查询
     */

    List<Emp> getEmpByCondition(Emp emp);


    /**
     * 用来测试choose,when,otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组来实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);
}
