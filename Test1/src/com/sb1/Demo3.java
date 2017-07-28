package com.sb1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import ch.ubique.inieditor.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.TextArea;

public class Demo3 {

	private JFrame frame;
	private JTextField textField;
	private String strName;
	private JTextField textField_1;
	private TextArea textArea;
	private JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo3 window = new Demo3();
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
	public Demo3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 781, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, null, null, null));
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(30, 24, 714, 495);
		frame.getContentPane().add(layeredPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				strName=this.getClass().getResource("/").getPath();
				textField.setText(strName+"GAS.ini");
				
				IniEditor in=new IniEditor();
				
				try {
					in.load(textField.getText());
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
				textField_1.setText(in.get("gas", "gas"));
			
				in.set("��д��", "�̶��˿�","nmmp");
				in.addBlankLine("��д��");
				in.addBlankLine("��д��");
				in.addBlankLine("��д��");
				in.addBlankLine("��д��");
				in.addBlankLine("��д��");
				try {
					in.save(strName+"GAS.ini");
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
				 List<String> dd=in.sectionNames();
				textArea.setText(dd.toString());
				
				list.setListData(dd.toArray());
				
			}
		});
		btnNewButton.setBounds(101, 166, 93, 23);
		layeredPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(28, 54, 485, 62);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(28, 394, 420, 77);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		textArea = new TextArea();
		textArea.setBounds(245, 154, 440, 45);
		layeredPane.add(textArea);
		
		list = new JList();
		list.setBounds(268, 237, 322, 133);
		layeredPane.add(list);
		
	}
}
