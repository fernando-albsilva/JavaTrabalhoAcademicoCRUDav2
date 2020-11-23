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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class FrameBuscaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsultaCodigo;
	private JTextField txtImprimeConsulta;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameBuscaConsulta frame = new FrameBuscaConsulta();
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
	public FrameBuscaConsulta() {
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
		lblSair.setBounds(1468, 46, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameBuscaConsulta.this.dispose();
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
		pnlPacienteCadastrar_1.setBounds(905, 46, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameBuscaConsulta.this.dispose();
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
		
		JLabel lblBuscarConsulta = new JLabel("Buscar  Consulta");
		lblBuscarConsulta.setForeground(Color.WHITE);
		lblBuscarConsulta.setFont(new Font("Dialog", Font.BOLD, 30));
		lblBuscarConsulta.setBounds(401, 168, 380, 44);
		contentPane.add(lblBuscarConsulta);
		
		JLabel lblCodigoDaConsulta = new JLabel("Codigo da Consulta :");
		lblCodigoDaConsulta.setForeground(Color.WHITE);
		lblCodigoDaConsulta.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCodigoDaConsulta.setBounds(401, 261, 291, 32);
		contentPane.add(lblCodigoDaConsulta);
		
		txtConsultaCodigo = new JTextField();
		txtConsultaCodigo.setColumns(10);
		txtConsultaCodigo.setBounds(401, 317, 380, 37);
		contentPane.add(txtConsultaCodigo);
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(401, 406, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Consulta consulta = new Consulta();
				consulta.setCodigo(txtConsultaCodigo.getText());
				
				ConsultaController controller = new ConsultaController();
				
				ResultSet rs=controller.read(consulta);
				
				txtImprimeConsulta.setText("");

				try {
					while(rs.next()){
						
						txtImprimeConsulta.setText(txtImprimeConsulta.getText()+ "//" + "Codigo : " + rs.getString("codigo") + " ->  Cpf Paciente : " + rs.getString("fk_paciente_cpf")  + " -> Codigo Tratamento : " + rs.getString("fk_tratamento_codigo") + " -> Descrição : " + rs.getString("descricao"));
					 
						
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller= null;
				consulta=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Consulta Buscada", " Aviso", JOptionPane.CLOSED_OPTION );
				
				txtConsultaCodigo.setText("");
				
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
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setForeground(Color.WHITE);
		lblConsulta.setFont(new Font("Dialog", Font.BOLD, 30));
		lblConsulta.setBounds(401, 537, 380, 44);
		contentPane.add(lblConsulta);
		
		txtImprimeConsulta = new JTextField();
		txtImprimeConsulta.setColumns(10);
		txtImprimeConsulta.setBounds(401, 621, 738, 42);
		contentPane.add(txtImprimeConsulta);
	}

}
