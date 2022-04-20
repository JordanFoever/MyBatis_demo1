package com.hxut.mybatis.mapper;

import com.hxut.mybatis.pojo.User;

import java.util.List;


/**
 * @author weijiangquan
 * @date 2022/4/20 -11:25
 */
public interface ParameterMapper{

    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();
}
