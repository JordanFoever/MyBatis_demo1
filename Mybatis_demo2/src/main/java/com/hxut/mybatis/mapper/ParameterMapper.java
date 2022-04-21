package com.hxut.mybatis.mapper;

import com.hxut.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author weijiangquan
 * @date 2022/4/20 -11:25
 */
public interface ParameterMapper{


    /**
     * 验证登录(使用@Param)
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户信息
     *
     */

    int insertUser(User user);

    /**
     * 验证登录(参数为map)
     */

    User checkLoginByMap(Map<String,Object> map);


    User checkLogin(String username,String password);

    // 根据用户查询用户信息
    User getByUserName(String username);
    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();
}
