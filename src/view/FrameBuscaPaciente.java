package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bo.Paciente;
import controller.PacienteController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class FrameBuscaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePaciente;
	private JTextField txtImprimeConsulta;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameBuscaPaciente frame = new FrameBuscaPaciente();
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
	public FrameBuscaPaciente() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlPacienteCadastrar_1 = new JPanel();
		pnlPacienteCadastrar_1.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar_1.setBounds(874, 66, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1);
		pnlPacienteCadastrar_1.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameBuscaPaciente.this.dispose();
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
		
		JLabel lblSair = new JLabel("X");
		lblSair.setForeground(Color.WHITE);
		lblSair.setBounds(1428, 66, 20, 20);
		contentPane.add(lblSair);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameBuscaPaciente.this.dispose();
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
		
		JLabel lblBuscarPaciente = new JLabel("Buscar  Paciente");
		lblBuscarPaciente.setForeground(Color.WHITE);
		lblBuscarPaciente.setFont(new Font("Dialog", Font.BOLD, 30));
		lblBuscarPaciente.setBounds(393, 252, 380, 44);
		contentPane.add(lblBuscarPaciente);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNome.setBounds(393, 345, 99, 32);
		contentPane.add(lblNome);
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setColumns(10);
		txtNomePaciente.setBounds(393, 401, 380, 37);
		contentPane.add(txtNomePaciente);
		
		
		
		JPanel pnlPacienteCadastrar = new JPanel();
		pnlPacienteCadastrar.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar.setBounds(393, 490, 165, 42);
		contentPane.add(pnlPacienteCadastrar);
		pnlPacienteCadastrar.addMouseListener(new MouseAdapter() {
			//faz o teste de login "usuario e senha"
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Paciente paciente = new Paciente();
				paciente.setNome(txtNomePaciente.getText());
				
				PacienteController controller = new PacienteController();
				
				ResultSet rs=controller.read(paciente);
				
				txtImprimeConsulta.setText("");

				try {
					while(rs.next()){
						
						txtImprimeConsulta.setText(txtImprimeConsulta.getText()+ "//" + "Nome : " + rs.getString("nome") + " -> \\n Email : " + rs.getString("email")  + " -> Cpf : " + rs.getString("cpf"));
					 
						
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller= null;
				paciente=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Paciente Buscado", " Aviso", JOptionPane.CLOSED_OPTION );
				
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
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar.add(lblBuscar);
		
		txtImprimeConsulta = new JTextField();
		txtImprimeConsulta.setBounds(393, 705, 738, 42);
		contentPane.add(txtImprimeConsulta);
		txtImprimeConsulta.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setForeground(Color.WHITE);
		lblPaciente.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPaciente.setBounds(393, 621, 380, 44);
		contentPane.add(lblPaciente);
		
		
		
		
		
		
	}
}
