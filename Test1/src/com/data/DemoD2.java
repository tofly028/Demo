package com.data;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.data.User;
import com.data.inter.*;

public class DemoD2 {
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
    
    public void getUserList(String userName){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);          
            List<User> users = userOperation.selectUsers(userName);
            for(User user:users){
                System.out.println(user.getAge()+":"+user.getName());
            }
            
        } finally {
            session.close();
        }
    }
    
    /**
     * 测试增加,增加后，必须提交事务，否则不会写入到数据库.
     */
    public void addUser(){
        User user=new User();
        user.setAge(999);
        user.setName("老杂种");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }
    
    
    public void updateUser(){
        User user=new User();
        
        
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            user = userOperation.SelectUserById(6);
            user.setAge(1);
            user.setName("狗日的老杂种");
            userOperation.updateUser(user);
            session.commit();
            System.out.println("当前修改的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }
    
    public void deleteUser(){
        User user=new User();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            user = userOperation.SelectUserById(6);
            userOperation.deleteUser(user);
            session.commit();
            System.out.println("当前删除的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		SqlSession session = sqlSessionFactory.openSession();
//        try {
//        	IUserOperation userOperation=session.getMapper(com.data.inter.IUserOperation.class);
//            
//            User user = userOperation.SelectUserById(1);
//            System.out.println(user.getAge());
//            System.out.println(user.getName());
//            
//        } finally {
//            session.close();
//        }
		//查询列表
//        DemoD2 d2=new DemoD2();
//        d2.getUserList("%李%");
		
		//增加数据
//		DemoD2 d2=new DemoD2();
//        d2.addUser();
        
      //修改数据
//      		DemoD2 d2=new DemoD2();
//              d2.updateUser();
		
		//删除数据
		DemoD2 d2=new DemoD2();
        d2.deleteUser();
	}
}
