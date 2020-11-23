package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.Paciente;
import controller.PacienteController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class FrameCadastraPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePaciente;
	private JTextField txtEmail;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameCadastraPaciente frame = new FrameCadastraPaciente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrameCadastraPaciente() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSair = new JLabel("X");
		lblSair.setForeground(Color.WHITE);
		lblSair.setBounds(1393, 50, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameCadastraPaciente.this.dispose();
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
		
		JLabel lblCadastroDePaciente = new JLabel("Cadastro de Paciente");
		lblCadastroDePaciente.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCadastroDePaciente.setForeground(new Color(255, 255, 255));
		lblCadastroDePaciente.setBounds(544, 173, 380, 44);
		contentPane.add(lblCadastroDePaciente);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(544, 289, 99, 32);
		contentPane.add(lblNome);
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setBounds(544, 345, 380, 37);
		contentPane.add(txtNomePaciente);
		txtNomePaciente.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEmail.setBounds(544, 445, 99, 32);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(544, 505, 380, 37);
		contentPane.add(txtEmail);
		
		JLabel lblCpf = new JLabel("Cpf :");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCpf.setBounds(544, 608, 99, 32);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(544, 668, 380, 37);
		contentPane.add(txtCpf);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(544, 778, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Paciente paciente = new Paciente();
				paciente.setCpf(txtCpf.getText());
				paciente.setNome(txtNomePaciente.getText());
				paciente.setEmail(txtEmail.getText());
				PacienteController controller = new PacienteController();
				controller.create(paciente);
				controller= null;
				paciente=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Paciente Cadastrado", " Aviso", JOptionPane.CLOSED_OPTION );
				txtCpf.setText("");
				txtEmail.setText("");
				txtNomePaciente.setText("");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlPacienteCadastrar.setBackground(new Color (0,120,120));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlPacienteCadastrar.setBackground(new Color (0,139,139));
			}
		});
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setForeground(Color.WHITE);
		lblCadastrar.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar.add(lblCadastrar);
		
		JPanel pnlPacienteCadastrar_1 = new JPanel();
		pnlPacienteCadastrar_1.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar_1.setBounds(1025, 50, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameCadastraPaciente.this.dispose();
				FrameHomePage frame = new FrameHomePage();
				frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlPacienteCadastrar_1.setBackground(new Color (0,120,120));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlPacienteCadastrar_1.setBackground(new Color (0,139,139));
			}
		});
		
		JLabel lblVoltarATela = new JLabel("Voltar a Tela Inicial");
		lblVoltarATela.setForeground(Color.WHITE);
		lblVoltarATela.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar_1.add(lblVoltarATela);
	}

}
