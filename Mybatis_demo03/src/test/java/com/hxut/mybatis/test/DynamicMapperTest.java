package com.hxut.mybatis.test;

import com.hxut.mybatis.mapper.DynamicSQLMapper;
import com.hxut.mybatis.pojo.Emp;
import com.hxut.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/21 -23:17
 *
 * 动态SQL
 * 1.if:根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
 *
 * 3.trim(有下面的4个属性)
 * prefix="" suffix="" suffixOverrides="" prefixOverrides=""
 * prefix|suffix:将trim标签中内容前面或后面添加指定的内容
 * suffixOverrides|prefixOverrides:将trim前面或者后面去掉指定的内容
 * 若标签中没有内容时,trim标签也没有任何效果
 *
 * 4.choose
 *  when至少要有一个,otherwise最多只能有一个
 *
 */
public class DynamicMapperTest{

    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);

    }


    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "张三", 23, "男", "1212@qq.com",null));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, null, 12, "男", "1212@qq.com",null));
        System.out.println(list);

    }
}
