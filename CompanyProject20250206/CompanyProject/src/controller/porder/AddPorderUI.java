package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lcd;
	private JTextField ram;
	private JTextField mouse;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(53, 10, 327, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("新增訂單");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(120, 10, 71, 29);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("回訂單主頁");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
				
			}
		});
		btnNewButton_3.setBounds(214, 13, 103, 23);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(53, 69, 327, 182);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LCD");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 21, 36, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setFont(new Font("新細明體", Font.BOLD, 14));
		lblRam.setBounds(27, 55, 36, 24);
		panel_1.add(lblRam);
		
		JLabel lblMouse = new JLabel("MOUSE");
		lblMouse.setFont(new Font("新細明體", Font.BOLD, 14));
		lblMouse.setBounds(27, 89, 61, 24);
		panel_1.add(lblMouse);
		
		lcd = new JTextField();
		lcd.setBounds(98, 23, 143, 21);
		panel_1.add(lcd);
		lcd.setColumns(10);
		
		ram = new JTextField();
		ram.setBounds(98, 57, 143, 21);
		panel_1.add(ram);
		ram.setColumns(10);
		
		mouse = new JTextField();
		mouse.setBounds(98, 91, 143, 21);
		panel_1.add(mouse);
		mouse.setColumns(10);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=member.getName();
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				
				Porder p=new Porder(Name,Lcd,Ram,Mouse);
				
				porderserviceimpl.addPorder(p);
				
				
			}
		});
		btnNewButton.setBounds(98, 131, 143, 23);
		panel_1.add(btnNewButton);
	}
}
