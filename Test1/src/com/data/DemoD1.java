package com.data;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.data.User;

public class DemoD1 {

	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader    = Resources.getResourceAsReader("conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    public static void main(String[] args) {
//    	System.out.println(reader.toString());
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
        User user = (User) session.selectOne("com.data.mapping.UserMapper.getUser", 1);
        session.delete("com.data.mapping.UserMapper.DeleteUser",2);
        session.commit();
        System.out.println(user.getId());
        System.out.println(user.getName());
        } finally {
        session.close();
        }
    }

}
