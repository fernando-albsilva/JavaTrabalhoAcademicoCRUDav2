package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.Tratamento;
import controller.TratamentoController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class FrameAlteraTratamento extends JFrame {

	private JPanel contentPane;
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
//					FrameAlteraTratamento frame = new FrameAlteraTratamento();
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
	public FrameAlteraTratamento() {
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
		lblSair.setBounds(1468, 25, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameAlteraTratamento.this.dispose();
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
		pnlPacienteCadastrar_1.setBounds(958, 25, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameAlteraTratamento.this.dispose();
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
		
		JLabel lblAterarTratamento = new JLabel("Alterar  Tratamento");
		lblAterarTratamento.setForeground(Color.WHITE);
		lblAterarTratamento.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAterarTratamento.setBounds(477, 148, 428, 44);
		contentPane.add(lblAterarTratamento);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNome.setBounds(477, 264, 99, 32);
		contentPane.add(lblNome);
		
		txtNomeTratamento = new JTextField();
		txtNomeTratamento.setColumns(10);
		txtNomeTratamento.setBounds(477, 320, 380, 37);
		contentPane.add(txtNomeTratamento);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblValor.setBounds(477, 420, 99, 32);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(477, 480, 380, 37);
		contentPane.add(txtValor);
		
		JLabel lblCodigo = new JLabel("Codigo  :");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCodigo.setBounds(477, 583, 112, 32);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(477, 643, 380, 37);
		contentPane.add(txtCodigo);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(477, 753, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tratamento tratamento = new Tratamento();
				tratamento.setCodigo(txtCodigo.getText());
				tratamento.setNome(txtNomeTratamento.getText());
				tratamento.setValor(Float.parseFloat(txtValor.getText()));
				TratamentoController controller = new TratamentoController();
				controller.update(tratamento);
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
		
		JLabel lblCadastrar = new JLabel("Alterar");
		lblCadastrar.setForeground(Color.WHITE);
		lblCadastrar.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar.add(lblCadastrar);
	}

}
