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

public class FrameExcluiTratamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameExcluiTratamento frame = new FrameExcluiTratamento();
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
	public FrameExcluiTratamento() {
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
		lblSair.setBounds(1468, 26, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameExcluiTratamento.this.dispose();
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
		pnlPacienteCadastrar_1.setBounds(958, 26, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameExcluiTratamento.this.dispose();
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
		
		JLabel lblExcluirTratamento = new JLabel("Excluir  Tratamento");
		lblExcluirTratamento.setForeground(Color.WHITE);
		lblExcluirTratamento.setFont(new Font("Dialog", Font.BOLD, 30));
		lblExcluirTratamento.setBounds(477, 149, 428, 44);
		contentPane.add(lblExcluirTratamento);
		
		JLabel lblCodigo = new JLabel("Codigo  :");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCodigo.setBounds(477, 317, 112, 32);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(477, 377, 380, 37);
		contentPane.add(txtCodigo);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(477, 487, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tratamento tratamento = new Tratamento();
				tratamento.setCodigo(txtCodigo.getText());
				
			
				TratamentoController controller = new TratamentoController();
				controller.delete(tratamento);
				controller= null;
				tratamento=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Tratamento Excluido", " Aviso", JOptionPane.CLOSED_OPTION );
				txtCodigo.setText("");
				
				
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
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar.add(lblExcluir);
	}

}
