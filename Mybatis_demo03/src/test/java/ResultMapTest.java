import com.hxut.mybatis.mapper.DeptMapper;
import com.hxut.mybatis.mapper.EmpMapper;
import com.hxut.mybatis.pojo.Dept;
import com.hxut.mybatis.pojo.Emp;
import com.hxut.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author weijiangquan
 * @date 2022/4/21 -18:16
 */
public class ResultMapTest{

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }


    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(2);
        System.out.println(emp);
    }

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp-> System.out.println(emp));

    }
}
