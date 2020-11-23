package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.Consulta;
import controller.ConsultaController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class FrameExcluiConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsultaCodigo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameExcluiConsulta frame = new FrameExcluiConsulta();
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
	public FrameExcluiConsulta() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSair_1 = new JLabel("X");
		lblSair_1.setForeground(Color.WHITE);
		lblSair_1.setBounds(1419, 34, 20, 20);
		contentPane.add(lblSair_1);
		lblSair_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fecha o frame
				FrameExcluiConsulta.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSair_1.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSair_1.setForeground(Color.WHITE);
			}
		});
		
		
		JPanel pnlPacienteCadastrar_1_1 = new JPanel();
		pnlPacienteCadastrar_1_1.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar_1_1.setBounds(930, 34, 257, 42);
		contentPane.add(pnlPacienteCadastrar_1_1);
		pnlPacienteCadastrar_1_1.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameExcluiConsulta.this.dispose();
				FrameHomePage frame = new FrameHomePage();
				frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlPacienteCadastrar_1_1.setBackground(new Color (0,120,120));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlPacienteCadastrar_1_1.setBackground(new Color (0,139,139));
			}
		});
		
		JLabel lblVoltarATela_1 = new JLabel("Voltar a Tela Inicial");
		lblVoltarATela_1.setForeground(Color.WHITE);
		lblVoltarATela_1.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar_1_1.add(lblVoltarATela_1);
		
		JPanel pnlPacienteCadastrar_2 = new JPanel();
		pnlPacienteCadastrar_2.setBackground(new Color(0, 139, 139));
		pnlPacienteCadastrar_2.setBounds(449, 611, 165, 42);
		contentPane.add(pnlPacienteCadastrar_2);
		pnlPacienteCadastrar_2.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Consulta consulta = new Consulta();
				consulta.setCodigo(txtConsultaCodigo.getText());
				
				
				ConsultaController controller = new ConsultaController();
				controller.delete(consulta);
				controller= null;
				consulta=null;
				
				
				
				
				JOptionPane.showConfirmDialog(null,"Consulta Excluida", " Aviso", JOptionPane.CLOSED_OPTION );
				txtConsultaCodigo.setText("");
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlPacienteCadastrar_2.setBackground(new Color (0,120,120));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlPacienteCadastrar_2.setBackground(new Color (0,139,139));
			}
		});
		
		JLabel lblAlterar = new JLabel("Excluir");
		lblAlterar.setForeground(Color.WHITE);
		lblAlterar.setFont(new Font("Dialog", Font.BOLD, 18));
		pnlPacienteCadastrar_2.add(lblAlterar);
		
		JLabel lblExcluirConsulta = new JLabel("Excluir  Consulta");
		lblExcluirConsulta.setForeground(Color.WHITE);
		lblExcluirConsulta.setFont(new Font("Dialog", Font.BOLD, 30));
		lblExcluirConsulta.setBounds(449, 157, 428, 44);
		contentPane.add(lblExcluirConsulta);
		
		JLabel txtCodigoConsulta_1 = new JLabel("Codigo da Consulta :");
		txtCodigoConsulta_1.setForeground(Color.WHITE);
		txtCodigoConsulta_1.setFont(new Font("Dialog", Font.BOLD, 20));
		txtCodigoConsulta_1.setBounds(449, 321, 263, 32);
		contentPane.add(txtCodigoConsulta_1);
		
		txtConsultaCodigo = new JTextField();
		txtConsultaCodigo.setColumns(10);
		txtConsultaCodigo.setBounds(449, 381, 380, 37);
		contentPane.add(txtConsultaCodigo);
	}

}
