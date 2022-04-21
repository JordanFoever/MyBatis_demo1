package com.hxut.mybatis.test;

import com.hxut.mybatis.mapper.ParameterMapper;
import com.hxut.mybatis.pojo.User;
import com.hxut.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weijiangquan
 * @date 2022/4/20 -11:41
 *
 * MyBatis获取参数的两种方式:${}和#{}
 * ${}本质是字符串拼接
 * #{}本质是占位符赋值
 *
 * mybatis来获取参数值的各种情况:
 *  1.mapper接口方法参数为单个的字面量类型
 *      可以通过${}和#{}以任意的名称获取参数值,但是要注意${}的单引号问
 *  2.mapper接口的参数为多个时候
 *   此时Mybatis会将这些参数放在一个map集合中,以两种方式进行存储
 *   ① 以arg0,arg1...为键,以参数为值
 *   ② 以param1,param2...为键,以参数为值
 *
 *   因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
 *  3.若mapper接口方法的参数有多个时,可以手动将这些参数放在一个map中存储
 *      只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}单引号问
 *
 *  4.mapper接口的参数是实体类类型的参数 (用的最多的情况)
 *      只需要通过#{}和${}以属性的方式访问属性即可,但是需要注意${}单引号问题
 *
 *  5.使用@Param注解命名参数
 *      此时MyBatis会将这些参数放在一个map集合中,以两种方式进行存储
 *      a->以@param注解的值为键,以参数为值
 *      b->a以@param1,param2...为键,以参数为值
 *      因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
 *
 *
 */
public class ParameterMapperTest{


    // 对应上面的标题4
    @Test
    public void testCheckLoginByParam(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user =  mapper.checkLoginByParam("张三","123456");
        System.out.println(user);
    }

    // 对应上面的标题4
    @Test
    public void testInsertUser(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "王五", "123", 22, "男", "121@qq.com"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByMap(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","张三");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    // 多个参数
    @Test
    public void testCheckLogin(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张三","123456");
        System.out.println(user);

    }
    // 单个参数
    @Test
    public void testGetUserByUsername(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getByUserName("张三");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        // 这是静态方法不用通过new的方式创建出来,直接通过点类名的方式弄出来
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user-> System.out.println(user));
    }
}


