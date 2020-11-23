package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.Paciente;
import bo.Tratamento;
import controller.PacienteController;
import controller.TratamentoController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class FrameCadastraTratamento extends JFrame {
	private JTextField txtNomeTratamento;
	private JTextField txtValor;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameCadastraTratamento frame = new FrameCadastraTratamento();
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
	public FrameCadastraTratamento() {
		getContentPane().setBackground(new Color(47, 79, 79));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		getContentPane().setLayout(null);
		
		JLabel lblSair = new JLabel("X");
		lblSair.setForeground(Color.WHITE);
		lblSair.setBounds(1452, 34, 20, 20);
		getContentPane().add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameCadastraTratamento.this.dispose();
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
		pnlPacienteCadastrar_1.setBounds(963, 34, 257, 42);
		getContentPane().add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameCadastraTratamento.this.dispose();
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
		
		JLabel lblCadastroDeTratamento = new JLabel("Cadastro de Tratamento");
		lblCadastroDeTratamento.setForeground(Color.WHITE);
		lblCadastroDeTratamento.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCadastroDeTratamento.setBounds(482, 157, 428, 44);
		getContentPane().add(lblCadastroDeTratamento);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNome.setBounds(482, 273, 99, 32);
		getContentPane().add(lblNome);
		
		txtNomeTratamento = new JTextField();
		txtNomeTratamento.setColumns(10);
		txtNomeTratamento.setBounds(482, 329, 380, 37);
		getContentPane().add(txtNomeTratamento);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblValor.setBounds(482, 429, 99, 32);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(482, 489, 380, 37);
		getContentPane().add(txtValor);
		
		JLabel lblCodigo = new JLabel("Codigo  :");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCodigo.setBounds(482, 592, 112, 32);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(482, 652, 380, 37);
		getContentPane().add(txtCodigo);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(482, 762, 165, 42);
		getContentPane().add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tratamento tratamento = new Tratamento();
				tratamento.setCodigo(txtCodigo.getText());
				tratamento.setNome(txtNomeTratamento.getText());
				tratamento.setValor(Float.parseFloat(txtValor.getText()));
				TratamentoController controller = new TratamentoController();
				controller.create(tratamento);
				controller= null;
				tratamento=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Paciente Cadastrado", " Aviso", JOptionPane.CLOSED_OPTION );
				txtCodigo.setText("");
				txtNomeTratamento.setText("");
				txtValor.setText("");
				
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
	}

}
