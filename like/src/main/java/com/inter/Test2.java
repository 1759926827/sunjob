package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"mysql");
        SqlSession sqlSession = sqlSessionFactory.openSession();

       int depid = 5 ;

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.qj" , depid);

        for (Dep d : list) {
            System.out.println(d.getDepid()+"\t" + d.getDepname());
        }

    }
}
