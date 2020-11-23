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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class FrameBuscaTratamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeTratamento;
	private JTextField txtImprimeTratamento;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameBuscaTratamento frame = new FrameBuscaTratamento();
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
	public FrameBuscaTratamento() {
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
		lblSair.setBounds(1468, 39, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameBuscaTratamento.this.dispose();
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
		pnlPacienteCadastrar_1.setBounds(905, 39, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameBuscaTratamento.this.dispose();
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
		
		JLabel lblBuscarTratamento = new JLabel("Buscar  Tratamento");
		lblBuscarTratamento.setForeground(Color.WHITE);
		lblBuscarTratamento.setFont(new Font("Dialog", Font.BOLD, 30));
		lblBuscarTratamento.setBounds(401, 161, 380, 44);
		contentPane.add(lblBuscarTratamento);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNome.setBounds(401, 254, 99, 32);
		contentPane.add(lblNome);
		
		txtNomeTratamento = new JTextField();
		txtNomeTratamento.setColumns(10);
		txtNomeTratamento.setBounds(401, 310, 380, 37);
		contentPane.add(txtNomeTratamento);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(401, 399, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tratamento tratamento = new Tratamento();
				tratamento.setNome(txtNomeTratamento.getText());
				
				TratamentoController controller = new TratamentoController();
				
				ResultSet rs=controller.read(tratamento);
				
				txtImprimeTratamento.setText("");

				try {
					while(rs.next()){
						
						txtImprimeTratamento.setText(txtImprimeTratamento.getText()+ "//" + "Nome : " + rs.getString("nome") + " -> \\n Valor : " + rs.getString("valor")  + " -> Codigo : " + rs.getString("Codigo"));
					 
						
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller= null;
				tratamento=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Tratamento Buscado", " Aviso", JOptionPane.CLOSED_OPTION );
				
				txtNomeTratamento.setText("");
				
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
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar.add(lblBuscar);
		
		JLabel lblTratamento = new JLabel("Tratamento");
		lblTratamento.setForeground(Color.WHITE);
		lblTratamento.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTratamento.setBounds(401, 530, 380, 44);
		contentPane.add(lblTratamento);
		
		txtImprimeTratamento = new JTextField();
		txtImprimeTratamento.setColumns(10);
		txtImprimeTratamento.setBounds(401, 614, 738, 42);
		contentPane.add(txtImprimeTratamento);
	}

}
