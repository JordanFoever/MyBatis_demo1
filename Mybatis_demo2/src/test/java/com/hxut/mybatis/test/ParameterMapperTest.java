package com.hxut.mybatis.test;

import com.hxut.mybatis.mapper.ParameterMapper;
import com.hxut.mybatis.pojo.User;
import com.hxut.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/20 -11:41
 */
public class ParameterMapperTest{

    @Test
    public void testGetAllUser(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user-> System.out.println(user));
    }
}



