package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(77, 34, 390, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("新增會員資料");
		lblNewLabel_6.setBounds(143, 30, 93, 15);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(79, 107, 388, 276);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名:");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 31, 46, 18);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(36, 59, 46, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setBounds(36, 88, 46, 18);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3.setBounds(36, 116, 46, 18);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("電話:");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_4.setBounds(36, 144, 46, 18);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("行動:");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_5.setBounds(36, 172, 46, 18);
		panel_1.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(135, 30, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(135, 58, 96, 21);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(135, 87, 96, 21);
		panel_1.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(135, 115, 96, 21);
		panel_1.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(135, 143, 96, 21);
		panel_1.add(phone);
		phone.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(135, 171, 96, 21);
		panel_1.add(mobile);
		mobile.setColumns(10);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				
				if(new MemberServiceImpl().isUsernameBeenUse(Username))
				{
					AddMemberErrorUI addmembererror=new AddMemberErrorUI();
					addmembererror.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					String Mobile=mobile.getText();
					
					Member member=new Member(Name,Username,Password,Address,Phone,Mobile);
					
					new MemberServiceImpl().addMember(member);
					
					AddMemberSuccessUI addmembersuccess=new AddMemberSuccessUI();
					addmembersuccess.setVisible(true);
					dispose();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(144, 224, 87, 23);
		panel_1.add(btnNewButton);
	}

}
