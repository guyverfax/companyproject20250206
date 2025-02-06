package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lcd;
	private JTextField ram;
	private JTextField mouse;
	private JTextField deleteId;
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JTextField updateId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
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
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(72, 27, 556, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 522, 71);
		panel.add(scrollPane);
		
		
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(72, 169, 556, 67);
		contentPane.add(panel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("lcd:");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 42, 33, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblRam = new JLabel("ram:");
		lblRam.setFont(new Font("新細明體", Font.BOLD, 14));
		lblRam.setBounds(218, 42, 33, 15);
		panel_1.add(lblRam);
		
		JLabel lblMouse = new JLabel("mouse:");
		lblMouse.setFont(new Font("新細明體", Font.BOLD, 14));
		lblMouse.setBounds(363, 42, 52, 15);
		panel_1.add(lblMouse);
		
		lcd = new JTextField();
		lcd.setBounds(73, 39, 96, 21);
		panel_1.add(lcd);
		lcd.setColumns(10);
		
		ram = new JTextField();
		ram.setBounds(246, 39, 96, 21);
		panel_1.add(ram);
		ram.setColumns(10);
		
		mouse = new JTextField();
		mouse.setBounds(406, 39, 96, 21);
		panel_1.add(mouse);
		mouse.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setBounds(118, 14, 26, 15);
		panel_1.add(lblNewLabel_2);
		
		updateId = new JTextField();
		updateId.setBounds(172, 11, 96, 21);
		panel_1.add(updateId);
		updateId.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(72, 246, 556, 58);
		contentPane.add(panel_2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(136, 14, 38, 15);
		panel_2.add(lblNewLabel_1);
		
		deleteId = new JTextField();
		deleteId.setBounds(184, 11, 96, 21);
		panel_2.add(deleteId);
		deleteId.setColumns(10);
		
		/*********Button**********/
		JButton btnNewButton_3 = new JButton("回訂單主頁");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_3.setBounds(72, 322, 121, 23);
		contentPane.add(btnNewButton_3);
		
		
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(porderserviceimpl.AllPorder());
				
			}
		});
		btnNewButton.setBounds(10, 10, 87, 23);
		panel.add(btnNewButton);
		
		
		
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id=Integer.parseInt(updateId.getText());
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				
				
				porderserviceimpl.updatePorder(Lcd, Ram, Mouse, Id);
			}
		});
		btnNewButton_1.setBounds(10, 10, 87, 23);
		panel_1.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id=Integer.parseInt(deleteId.getText());
				porderserviceimpl.deletePorderById(Id);
				
				
			}
		});
		btnNewButton_2.setBounds(10, 10, 87, 23);
		panel_2.add(btnNewButton_2);
	}
}
