package com.hxut.mybatis.mapper;

import com.hxut.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/20 -22:11
 */
public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     */

    List<User> getUserByLike(@Param("username") String username);


}
