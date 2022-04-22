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


        /**
         * 批量删除
         */

        int deleteMore(@Param("ids") String ids);


    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);
}
