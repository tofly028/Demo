package com.assist;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.*;

public class Demo1 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton jbt=new JButton("OK");
	private Icon ic=new ImageIcon(this.getClass().getResource("/com/res/about.png"));
	private JLabel jlb=new JLabel("sb",ic,SwingConstants.RIGHT);
	private JList jl=new JList(new String[]{"aa","bb","cc"});
	
	
	
//	private JList jl=new JList(
//		new object[]{
//			new Student(20,"����"),
//			new Student(21,"����"),
//			new Student(22,"����")
//		}
//	);
	/**
	 * 
	 */
	Demo1()
	{
		super.setTitle("Demo1");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		
		this.setLayout(new FlowLayout());
		
		this.add(jbt);
		this.add(jl);
		this.add(jlb);
		this.setVisible(true);
		this.setDefaultCloseOperation(Demo1.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Demo1();
	}

}