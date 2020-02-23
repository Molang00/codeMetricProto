package com.cherrybox.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import com.cherrybox.calculator.CodeMetric;
import com.cherrybox.gui.org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import com.cherrybox.gui.FList.FList;
import com.cherrybox.gui.FTree.FTree;

public class MainGui extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel MainPanel;
	private JTextPane txtCherryBox;
	private JTextPane textField;
	private JTextPane textField_1;
	private JTextPane IDText;
	private JTextPane PswText;
	private JTextPane LoginText;
	private JTextPane SignUpText;
	private JPasswordField passwordField;
	

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setBackground(Color.GRAY);
		setTitle("Cherry Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1440, 810);
		//getContentPane().
		MainPanel = new JPanel(new CardLayout());
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(MainPanel);
		//MainPanel.setLayout(new CardLayout(0, 0));
		
		//Login Field
		JPanel LoginPanel = new JPanel();
		//MainPanel.setLayer(LoginPanel, 0);
		LoginPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		LoginPanel.setBackground(Color.WHITE);
		LoginPanel.setBounds(0, 0, 1440, 810);
		MainPanel.add(LoginPanel, "Login");
		LoginPanel.setLayout(null);
		
		
		//Box Field
		JPanel BoxPanel = new JPanel();
		BoxPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		BoxPanel.setBackground(Color.WHITE);
		BoxPanel.setBounds(0, 0, 1440, 810);
		MainPanel.add(BoxPanel, "Box");
		
		
		
		
		txtCherryBox = new JTextPane();
		txtCherryBox.setEditable(false);
		txtCherryBox.setFont(new Font("����������_ac ExtraBold", Font.PLAIN, 43));
		txtCherryBox.setForeground(Color.BLACK);
		txtCherryBox.setText("Cherry Box");
		txtCherryBox.setBounds(602, 140, 237, 54);
		LoginPanel.add(txtCherryBox);
		
		textField = new JTextPane();
		textField.setEditable(false);
		textField.setText("\uB2E4\uB978 \uC11C\uBE44\uC2A4\uB85C \uB85C\uADF8\uC778");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("����������_ac", Font.PLAIN, 22));
		textField.setBounds(625, 238, 191, 31);
		LoginPanel.add(textField);
		
		JButton fbButton = new JButton("");
		fbButton.setIcon(new ImageIcon("C:\\Users\\YooTaeHyun\\eclipse-workspace\\CherryBox\\src\\images\\facebook.png"));
		fbButton.setBounds(560, 292, 64, 64);
		LoginPanel.add(fbButton);
		
		JButton googleButton = new JButton("");
		googleButton.setIcon(new ImageIcon("C:\\Users\\YooTaeHyun\\eclipse-workspace\\CherryBox\\src\\images\\google.png"));
		googleButton.setBounds(644, 292, 64, 64);
		LoginPanel.add(googleButton);
		
		JButton gitButton = new JButton("");
		gitButton.setIcon(new ImageIcon("C:\\Users\\YooTaeHyun\\eclipse-workspace\\CherryBox\\src\\images\\github.png"));
		gitButton.setBounds(728, 292, 64, 64);
		LoginPanel.add(gitButton);
		
		JButton naverButton = new JButton("");
		naverButton.setIcon(new ImageIcon("C:\\Users\\YooTaeHyun\\eclipse-workspace\\CherryBox\\src\\images\\naver.png"));
		naverButton.setBounds(812, 292, 64, 64);
		LoginPanel.add(naverButton);
		
		textField_1 = new JTextPane();
		textField_1.setEditable(false);
		textField_1.setForeground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		textField_1.setFont(new Font("����������_ac", Font.PLAIN, 20));
		textField_1.setText("\uB610\uB294");
		textField_1.setBounds(698, 391, 42, 24);
		LoginPanel.add(textField_1);
		
		JFormattedTextField IdTextField = new JFormattedTextField();
		IdTextField.setFont(new Font("����������_ac", Font.PLAIN, 16));
		IdTextField.setBounds(615, 427, 333, 41);
		LoginPanel.add(IdTextField);
		
		IDText = new JTextPane();
		IDText.setEditable(false);
		IDText.setFont(new Font("����������_ac ExtraBold", Font.PLAIN, 22));
		IDText.setText("ID");
		IDText.setBounds(499, 432, 116, 31);
		LoginPanel.add(IDText);
		
		PswText = new JTextPane();
		PswText.setEditable(false);
		PswText.setText("Password");
		PswText.setFont(new Font("����������_ac ExtraBold", Font.PLAIN, 22));
		PswText.setBounds(499, 485, 116, 31);
		LoginPanel.add(PswText);
		
		LoginText = new JTextPane();
		LoginText.setEditable(false);
		LoginText.setText("\uB85C\uADF8\uC778");
		LoginText.setForeground(UIManager.getColor("FormattedTextField.foreground"));
		LoginText.setFont(new Font("����������_ac", Font.PLAIN, 20));
		LoginText.setBounds(690, 533, 60, 24);
		LoginPanel.add(LoginText);
		
		SignUpText = new JTextPane();
		SignUpText.setEditable(false);
		SignUpText.setText("\uC544\uC9C1 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694? \uD68C\uC6D0\uAC00\uC785\uD558\uAE30");
		SignUpText.setForeground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		SignUpText.setFont(new Font("����������_ac", Font.PLAIN, 20));
		SignUpText.setBounds(563, 612, 313, 41);
		LoginPanel.add(SignUpText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(615, 480, 333, 41);
		LoginPanel.add(passwordField);
		
		
		
		
		//Search Text Field
		JTextField Search = new JTextField();
		Search.setBounds(14, 31, 290, 36);
		Search.setFont(new Font("����������_ac Light", Font.PLAIN, 24));
		Search.setHorizontalAlignment(SwingConstants.CENTER);
		Search.setText("\uAC80\uC0C9...");
		Search.setBackground(SystemColor.text);
		BoxPanel.setLayout(null);
		//contentPane.add(Search);
		
		//MyPageButton
		JButton MyPageButton = new JButton("");
		MyPageButton.setIcon(new ImageIcon("images\\MyPage.png"));
		MyPageButton.setBounds(1367, 12, 41, 41);
		//contentPane.add(MyPageButton);
		
		
		//SearchButton
		JButton SearchButton = new JButton("");
		SearchButton.setIcon(new ImageIcon("images\\search.png"));
		SearchButton.setBounds(303, 31, 35, 35);
		BoxPanel.setLayout(null);
		//contentPane.add(SearchButton);
		
		
		JPanel ProjectPanel = new JPanel();
		ProjectPanel.setBounds(0, 87, 207, 51);
		ProjectPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		ProjectPanel.setBackground(Color.WHITE);
		BoxPanel.add(ProjectPanel);
		ProjectPanel.setLayout(null);
		
		JTextPane txtpnProjects = new JTextPane();
		txtpnProjects.setEditable(false);
		txtpnProjects.setText("Projects");
		txtpnProjects.setFont(new Font("����������_ac ExtraBold", Font.PLAIN, 31));
		txtpnProjects.setBounds(42, 6, 131, 39);
		ProjectPanel.add(txtpnProjects);
		
		JPanel DirPanel = new JPanel();
		DirPanel.setBounds(205, 87, 202, 51);
		DirPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DirPanel.setBackground(Color.WHITE);
		BoxPanel.add(DirPanel);
		DirPanel.setLayout(null);
		
		JTextPane txtpnDir = new JTextPane();
		txtpnDir.setEditable(false);
		txtpnDir.setText("Dir");
		txtpnDir.setFont(new Font("����������_ac ExtraBold", Font.PLAIN, 31));
		txtpnDir.setBounds(73, 6, 56, 39);
		DirPanel.add(txtpnDir);
		
		JButton ResetButton = new JButton("");
		ResetButton.setIcon(new ImageIcon("images\\refresh.png"));
		ResetButton.setBounds(174, 28, 16, 16);
		DirPanel.add(ResetButton);
		
		JPanel CodePanel = new JPanel();
		CodePanel.setBounds(405, 87, 740, 51);
		CodePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		CodePanel.setBackground(Color.WHITE);
		BoxPanel.add(CodePanel);
		CodePanel.setLayout(null);
		
		JButton editButton = new JButton("");
		editButton.setSelectedIcon(new ImageIcon("images\\\uC218\uC815.png"));
		editButton.setForeground(Color.WHITE);
		editButton.setIcon(new ImageIcon("images\\\uC218\uC815.png"));
		editButton.setBounds(58, 5, 40, 40);
		CodePanel.add(editButton);
		
		JButton saveButton = new JButton("");
		saveButton.setIcon(new ImageIcon("images\\save.png"));
		saveButton.setBounds(6, 5, 40, 40);
		CodePanel.add(saveButton);
		
		//�ڵ�˻� ��ư
		JButton testButton = new JButton("");		
		testButton.setIcon(new ImageIcon("images\\test.png"));
		testButton.setBounds(686, 5, 40, 40);
		CodePanel.add(testButton);
		
		JButton deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon("images\\delete.png"));
		deleteButton.setBounds(110, 5, 40, 40);
		CodePanel.add(deleteButton);
		
		
		JPanel TestResult_panel = new JPanel();
		TestResult_panel.setBounds(1143, 87, 279, 51);
		TestResult_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		TestResult_panel.setBackground(Color.WHITE);
		BoxPanel.add(TestResult_panel);
		TestResult_panel.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("\uCF54\uB4DC\uC9C4\uB2E8 \uACB0\uACFC");
		textPane_1.setFont(new Font("����������_ac ExtraBold", Font.PLAIN, 31));
		textPane_1.setBounds(69, 6, 176, 39);
		TestResult_panel.add(textPane_1);
		
		JPanel ProjectContentsPanel = new JPanel();
		ProjectContentsPanel.setBounds(0, 135, 207, 634);
		ProjectContentsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		ProjectContentsPanel.setBackground(Color.WHITE);
		BoxPanel.add(ProjectContentsPanel);
		ProjectContentsPanel.setLayout(null);
		
		ProjectContentsPanel.setLayout(null);
		FList proList = new FList();
		proList.setFont(new Font("����", Font.PLAIN, 18));
		proList.setBounds(7,7,194,617);
		proList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane ProScroll = new JScrollPane(proList);
		ProScroll.setBounds(7,7,194,617);
		ProjectContentsPanel.add(ProScroll);
		ProScroll.setVisible(true);
		
		
		JPanel DirContentsPanel = new JPanel();
		DirContentsPanel.setBounds(205, 135, 202, 634);
		DirContentsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DirContentsPanel.setBackground(Color.WHITE);
		BoxPanel.add(DirContentsPanel);
		
		
		//FTree
		DirContentsPanel.setLayout(null);
		FTree codeTree = new FTree();
		//codeTreet.setFont(new Font("����", Font.PLAIN, 18));
		codeTree.setBounds(7, 7, 185, 617);
		//codeTree.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane DirScroll = new JScrollPane(codeTree);
		DirScroll.setBounds(7,7,187,617);
		DirContentsPanel.add(DirScroll);
		DirScroll.setVisible(true);
		
			
		JPanel CodeContentsPanel = new JPanel();
		CodeContentsPanel.setBounds(405, 135, 740, 634);
		CodeContentsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		CodeContentsPanel.setBackground(Color.WHITE);
		BoxPanel.add(CodeContentsPanel);
		CodeContentsPanel.setLayout(null);
		
		JTextPane CodeText = new JTextPane();
		CodeText.setBounds(10,10,722,614);
		CodeText.setFont(new Font("����������_ac", Font.PLAIN, 14));
		CodeContentsPanel.setBackground(Color.WHITE);
		JScrollPane CodeTextScroll = new JScrollPane(CodeText);
		CodeTextScroll.setBounds(7,7,725,617);
		CodeContentsPanel.add(CodeTextScroll);
		CodeTextScroll.setVisible(true);
		CodeText.setEditable(false);
		
		JPanel TestResultContensPanel = new JPanel();
		TestResultContensPanel.setBounds(1143, 135, 279, 634);
		TestResultContensPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		TestResultContensPanel.setBackground(Color.WHITE);
		BoxPanel.add(TestResultContensPanel);
		TestResultContensPanel.setLayout(null);
		
		JTextPane TestResultText = new JTextPane();
		TestResultText.setEditable(false);
		TestResultText.setFont(new Font("����������_ac", Font.PLAIN, 16));
		TestResultText.setBounds(7, 7, 267, 617);
		TestResultContensPanel.add(TestResultText);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBounds(0, 0, 1422, 89);
		MenuPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		MenuPanel.setBackground(Color.WHITE);
		BoxPanel.add(MenuPanel);
		MenuPanel.setLayout(null);
		MenuPanel.add(Search);
		MenuPanel.add(SearchButton);
		MenuPanel.add(MyPageButton);
		BoxPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{MyPageButton, Search, SearchButton, ProjectPanel, DirPanel, CodePanel, TestResult_panel}));
		
		
		MenuPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Search.getText().contentEquals("")) Search.setText("�˻�...");
			}
		});
		
		Search.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				Search.setText("");
			}
		});
		
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestResultText.setText("");
				String testResult = CodeMetric.exitReport();
				if(proList.getSelectedIndex()==-1) TestResultText.setText("Select File or Project\n"+testResult);
				else {
					File file = new File("");
					if(codeTree.getSelectionCount()==0) {
						file = proList.getFileAt(proList.getSelectedIndex());
						TestResultText.setText("Test Result of Project: " + file.getName());
					}
					else {
						file = codeTree.getFileSelected();
						TestResultText.setText("Test Result of " + file.getName());
					}
				}
			}
		});
		
		//edit button of CodeText
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((codeTree.getSelectionCount()!=0)&&(codeTree.getFileSelected().isFile()))
					CodeText.setEditable(true);
			}
		});
		
		//Save button of CodeText
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if((codeTree.getSelectionCount()!=0)&&(codeTree.getFileSelected().isFile())) {
					CodeText.setEditable(false);
					try {
						int selIndex = proList.getSelectedIndex();
						File saveFile = codeTree.getFileSelected();
						BufferedWriter saveFileBuf = new BufferedWriter(new FileWriter(saveFile));
						saveFileBuf.write(CodeText.getText(),0,CodeText.getText().length());
						saveFileBuf.flush();
						saveFileBuf.close();
						proList.updateList("drive");
						proList.setSelectedIndex(selIndex);
						
					}catch(IOException ioe) {
						
					}
				}
			}
		});
		
		//refreshbutton
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proList.updateList("drive");
				codeTree.resetTree();
			}
		});
		
		//Ŭ���� �ش� ������Ʈ Ʈ�� ȭ�� ���
		proList.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				TestResultText.setText("");
				CodeText.setText("");
				File file = proList.getFileAt(proList.getSelectedIndex());
				codeTree.updateTree(file.getAbsolutePath());
				return;
			}
		});
		
		//Ŭ���� �ش� �ڵ� ȭ�鿡 ���
		codeTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TestResultText.setText("");
				File file=codeTree.getFileSelected();
				
				if(file.isFile()) {
					/*�̹��� ������ �̹����� ����ϴ� �Լ�
					int index=file.getName().lastIndexOf(".");
					if(file.getName().substring(index+1, file.getName().length()).equals("png"))
					CodeText.set(new ImageIcon(file.getAbsolutePath()));
					*/
					try{
						BufferedReader in = new BufferedReader(new  FileReader(file));
						CodeText.setText("");
						String line= "";
						while((line = in.readLine())!=null) {
							CodeText.setText(CodeText.getText()+line + "\n");
						}
						in.close();
					}catch(IOException er) {
						
					}
				}
				else CodeText.setText("");
				
			}
			
		});
		
		
		//delete button
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if((proList.getSelectedIndex()!=-1)||(codeTree.getSelectionCount()!=0)) {
					File file = new File("");
					if((proList.getSelectedIndex()!=-1)&&(codeTree.getSelectionCount()==0))
						file = proList.getFileAt(proList.getSelectedIndex());
					else if(codeTree.getSelectionCount()!=0)
						file = codeTree.getFileSelected();
					if(file.isFile()) {
						if(file.exists()) {
							if(file.delete()) {
								//delete Project
								if((proList.getSelectedIndex()!=-1)&&(codeTree.getSelectionCount()==0)) { 
									proList.setSelectedIndex(-1);
									codeTree.resetTree();
									proList.updateList("drive");
								}
								//delete Files in Directory
								else if(codeTree.getSelectionCount()!=0) {
									File filelater = proList.getFileAt(proList.getSelectedIndex());
									codeTree.updateTree(filelater.getAbsolutePath());
								}
								TestResultText.setText("");
								
								CodeText.setText("File deleted");
							}		
							else CodeText.setText("Delete Fail");
						}
					else CodeText.setText("Choose File");
					}
					
					else if(file.isDirectory()) {
						deleteFolder(file.getAbsolutePath());
						if((proList.getSelectedIndex()!=-1)&&(codeTree.getSelectionCount()==0)) { 
							proList.setSelectedIndex(-1);
							codeTree.resetTree();
							proList.updateList("drive");
						}
						else if(codeTree.getSelectionCount()!=0) {
							File filelater = proList.getFileAt(proList.getSelectedIndex());
							codeTree.updateTree(filelater.getAbsolutePath());
						};
						
						CodeText.setText("File deleted");
					}
				}
							
			}
			
		});
		
		//Login
		LoginText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout)MainPanel.getLayout();
				cl.show(MainPanel, "Box");
			}
		});
		
		
	}
	
	public void deleteFolder(String path) {
		File folder = new File(path);
	    try{
			if(folder.exists()){
	            File[] folder_list = folder.listFiles(); //���ϸ���Ʈ ������		
	            for (int i = 0; i < folder_list.length; i++) {
	            	if(folder_list[i].isFile()) {
	            		folder_list[i].delete();
	            	}
	            	else {
	            		deleteFolder(folder_list[i].getPath()); //����Լ�ȣ��
	            	}
	            	folder_list[i].delete();
	            }
	            folder.delete(); //���� ����
			}
	    }
	    catch (Exception e) {
	    	e.getStackTrace();
	    }
	}
}

