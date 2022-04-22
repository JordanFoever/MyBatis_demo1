package com.hxut.mybatis.test;

import com.hxut.mybatis.mapper.SQLMapper;
import com.hxut.mybatis.mapper.SelectMapper;
import com.hxut.mybatis.pojo.User;
import com.hxut.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/20 -22:16
 */
public class SQLMapperTest {

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);

    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("6,7,8");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);

    }
}

