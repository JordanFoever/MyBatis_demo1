package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/19 -18:17
 *
 * sqlSession默认不自动提交事务,若需要自动提交事物
 * 可以来使用SqlSessionFactory.openSession(true) 自动提交
 *
 *
 */
public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取splSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //为true就是自动提交事务
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //底层使用的是代理模式
        //测试功能
        int result = mapper.insertUser();
      /*  // 提交事务
        sqlSession.commit();*/
        System.out.println("result:"+result);
    }

    // 更新功能
    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //为true就是自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
    }

    // 删除功能
    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //为true就是自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper.deleteUser();

       /* // 查询一个用户的所有信息
        User user = mapper.getUserById();
        System.out.println(user);*/
        // 查询所有用户的信息(嘿嘿)
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}












