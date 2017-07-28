package com.sb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Demo2 {

	private JFrame frmdemo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo2 window = new Demo2();
					window.frmdemo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmdemo = new JFrame();
		frmdemo.setTitle("�й�Demo2");
		frmdemo.setBounds(100, 100, 623, 471);
		frmdemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmdemo.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmdemo.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		frmdemo.getContentPane().add(lblNewLabel);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"sb", "1", "asdfd", "bq"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		frmdemo.getContentPane().add(list_1);
		
		JList list = new JList();
		frmdemo.getContentPane().add(list);
	}

}
