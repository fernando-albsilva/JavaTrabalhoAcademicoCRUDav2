package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					

					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(180, 117, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textUserName = new JTextField();
		textUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textUserName.setText("");
			}
		});
		textUserName.setBorder(null);
		textUserName.setText("Usuário");
		textUserName.setBounds(12, 12, 170, 20);
		panel.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblIconeUsuario = new JLabel("");
		lblIconeUsuario.setIcon(new ImageIcon(FrameLogin.class.getResource("/res/iconeUsuarioJava.jpg")));
		lblIconeUsuario.setBounds(200, 0, 40, 40);
		panel.add(lblIconeUsuario);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(180, 173, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText("");
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setText("Password");
		txtPassword.setBounds(12, 12, 170, 20);
		panel_1.add(txtPassword);
		
		JLabel lblIconeChave = new JLabel("");
		lblIconeChave.setIcon(new ImageIcon(FrameLogin.class.getResource("/res/iconeChaveJava.png")));
		lblIconeChave.setBounds(200, 0, 40, 40);
		panel_1.add(lblIconeChave);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if( textUserName.getText().contentEquals("admin") && txtPassword.getText().contentEquals("123456"))
				{
					FrameLogin.this.dispose();
					FrameHomePage frameHome = new FrameHomePage();
					frameHome.setVisible(true);
					
					
				}else {
					
					JOptionPane.showConfirmDialog(null,"usuario ou senha incorreta", " Aviso", JOptionPane.CLOSED_OPTION );
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color (0,120,120));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color (0,139,139));
			}
		});
		pnlBtnLogin.setBackground(new Color(0, 139, 139));
		pnlBtnLogin.setBounds(180, 244, 250, 40);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOG IN");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(92, 0, 52, 40);
		pnlBtnLogin.add(lblLogin);
		
		JLabel lblSair = new JLabel("X");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameLogin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSair.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSair.setForeground(Color.WHITE);
			}
		});
		lblSair.setForeground(new Color(255, 255, 255));
		lblSair.setBounds(568, 12, 20, 20);
		contentPane.add(lblSair);
		setLocationRelativeTo(null);
	}

}
