package com.hxut.mybatis.test;

import com.hxut.mybatis.mapper.SelectMapper;
import com.hxut.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author weijiangquan
 * @date 2022/4/20 -20:24
 *
 * Mybatis的各种查询功能
 *  1.若查询出的数据只有一条,
 *      ① 可以通过实体类
 *      ② 集合进行接收对象接收
 *      ③ 也可以通过map集合接收
 *         结果:{password=123, sex=男, id=13, age=22, email=121@qq.com, username=王五}
 *  2.若查询的数据有多条,
 *    ①可以通过list集合接收,
 *      注意:一定不能通过实体类对象接收,这个时候会抛出异常 TooManyResultException
 *    ② 可以通过map类型的list集合接收
 *    ③ 可以在mapper接口的方法上添加@Mapper注解,然后就可以将每条数据转换的map集合作为值,
 *     以某个字段的值作为键放在同一个map集合中
 *  3.
 *
 *  MyBatis中设置了类型别名
 *  java.lang.Integer -->int,integer
 *  int -->_int,_Integer
 *  Map -->map
 *  String -->String
 *  这几个是最常用的
 */
public class SelectMapperTest {


    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());

    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(13));
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());

    }
    // 2
    // 多条数据的情况下
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());

    }

    // 1
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(12));
    }
}


