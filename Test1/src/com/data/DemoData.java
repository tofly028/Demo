package com.data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class DemoData {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoData window = new DemoData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemoData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 87, 362, 359);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 52, 304, 60);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 //mybatis的配置文件
		        String resource = "conf.xml";
		        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		        InputStream is = DemoData.class.getClassLoader().getResourceAsStream(resource);
		        //构建sqlSession的工厂
		        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		        //Reader reader = Resources.getResourceAsReader(resource); 
		        //构建sqlSession的工厂
		        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		        //创建能执行映射文件中sql的sqlSession
		        SqlSession session = sessionFactory.openSession();
		        /**
		         * 映射sql的标识字符串，
		         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		         */
		        String statement = "com.data.mapping.userMapper.getUser";//映射sql的标识字符串
		        //执行查询返回一个唯一user对象的sql
		        User user = session.selectOne(statement, 1);
//		        textField.setText(user);
		        //System.out.println(user);
		        textField.setText(user.toString());
			}
		});
		btnNewButton.setBounds(37, 197, 214, 28);
		panel.add(btnNewButton);
	}
}
