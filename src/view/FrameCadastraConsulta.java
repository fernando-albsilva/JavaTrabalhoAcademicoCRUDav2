package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.Consulta;
import bo.Tratamento;
import controller.ConsultaController;
import controller.TratamentoController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class FrameCadastraConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtPacienteCpf;
	private JTextField txtConsultaCodigo;
	private JTextField txtConsultaDescricao;
	private JTextField txtTratamentoCodigo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameCadastraConsulta frame = new FrameCadastraConsulta();
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
	public FrameCadastraConsulta() {
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
		lblSair.setBounds(1411, 37, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameCadastraConsulta.this.dispose();
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
		
		JPanel pnlPacienteCadastrar_1 = new JPanel();
		pnlPacienteCadastrar_1.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar_1.setBounds(922, 37, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameCadastraConsulta.this.dispose();
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
		
		JLabel lblCadastroDeConsulta = new JLabel("Cadastro de Consulta");
		lblCadastroDeConsulta.setForeground(Color.WHITE);
		lblCadastroDeConsulta.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCadastroDeConsulta.setBounds(441, 160, 428, 44);
		contentPane.add(lblCadastroDeConsulta);
		
		JLabel txtCpf = new JLabel("Cpf do Paciente :");
		txtCpf.setForeground(Color.WHITE);
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 20));
		txtCpf.setBounds(441, 236, 230, 32);
		contentPane.add(txtCpf);
		
		txtPacienteCpf = new JTextField();
		txtPacienteCpf.setColumns(10);
		txtPacienteCpf.setBounds(441, 292, 380, 37);
		contentPane.add(txtPacienteCpf);
		
		JLabel txtCodigoConsulta = new JLabel("Codigo da Consulta :");
		txtCodigoConsulta.setForeground(Color.WHITE);
		txtCodigoConsulta.setFont(new Font("Dialog", Font.BOLD, 20));
		txtCodigoConsulta.setBounds(441, 475, 263, 32);
		contentPane.add(txtCodigoConsulta);
		
		txtConsultaCodigo = new JTextField();
		txtConsultaCodigo.setColumns(10);
		txtConsultaCodigo.setBounds(441, 535, 380, 37);
		contentPane.add(txtConsultaCodigo);
		
		JLabel txtDescricao = new JLabel("Descrição da Consulta  :");
		txtDescricao.setForeground(Color.WHITE);
		txtDescricao.setFont(new Font("Dialog", Font.BOLD, 20));
		txtDescricao.setBounds(441, 595, 346, 32);
		contentPane.add(txtDescricao);
		
		txtConsultaDescricao = new JTextField();
		txtConsultaDescricao.setColumns(10);
		txtConsultaDescricao.setBounds(441, 655, 738, 37);
		contentPane.add(txtConsultaDescricao);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(441, 765, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Consulta consulta = new Consulta();
				consulta.setCodigo(txtConsultaCodigo.getText());
				consulta.setPacienteCpf(txtPacienteCpf.getText());
				//consulta.setTratamentoCodigo(Float.parseFloat(.getText()));
				consulta.setTratamentoCodigo(txtTratamentoCodigo.getText());
				consulta.setDescricao(txtConsultaDescricao.getText());
				
				ConsultaController controller = new ConsultaController();
				controller.create(consulta);
				controller= null;
				consulta=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Consulta Cadastrada", " Aviso", JOptionPane.CLOSED_OPTION );
				txtConsultaCodigo.setText("");
				txtPacienteCpf.setText("");
				txtTratamentoCodigo.setText("");
				txtConsultaDescricao.setText("");
				
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
		
		JLabel lblCodigoDoTratamento = new JLabel("Codigo do Tratamento :");
		lblCodigoDoTratamento.setForeground(Color.WHITE);
		lblCodigoDoTratamento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCodigoDoTratamento.setBounds(441, 349, 346, 32);
		contentPane.add(lblCodigoDoTratamento);
		
		txtTratamentoCodigo = new JTextField();
		txtTratamentoCodigo.setColumns(10);
		txtTratamentoCodigo.setBounds(441, 405, 380, 37);
		contentPane.add(txtTratamentoCodigo);
	}

}
