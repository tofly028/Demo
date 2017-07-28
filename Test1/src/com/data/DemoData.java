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
				 //mybatis�������ļ�
		        String resource = "conf.xml";
		        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		        InputStream is = DemoData.class.getClassLoader().getResourceAsStream(resource);
		        //����sqlSession�Ĺ���
		        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		        //Reader reader = Resources.getResourceAsReader(resource); 
		        //����sqlSession�Ĺ���
		        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		        //������ִ��ӳ���ļ���sql��sqlSession
		        SqlSession session = sessionFactory.openSession();
		        /**
		         * ӳ��sql�ı�ʶ�ַ�����
		         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		         */
		        String statement = "com.data.mapping.userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
		        //ִ�в�ѯ����һ��Ψһuser�����sql
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