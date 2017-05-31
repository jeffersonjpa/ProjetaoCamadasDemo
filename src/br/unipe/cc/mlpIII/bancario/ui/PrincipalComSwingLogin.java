package br.unipe.cc.mlpIII.bancario.ui;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import br.unipe.cc.mlpIII.bancario.fachada.Bancario;

/**
 * Principal classe da interface gráfica com o usuário. 
 *
 */
public class PrincipalComSwingLogin extends javax.swing.JFrame {

	private static final long serialVersionUID = -1303772655025065144L;
	private javax.swing.JButton acesso;
	private javax.swing.JPasswordField senha;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JTextField login;

	/**
	 * Creates new form Login
	 */
	public PrincipalComSwingLogin() {
		initComponents();
	}

	private void initComponents() {
		acesso = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		login = new javax.swing.JTextField();
		senha = new javax.swing.JPasswordField();
		jLabel3 = new javax.swing.JLabel();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Tela de Login");
		setResizable(false);
		setSize(new java.awt.Dimension(0, 0));
		getContentPane().setLayout(null);
		acesso.setFont(new java.awt.Font("Tahoma", 1, 14));
		acesso.setText("Entrar");
		acesso.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AcessoActionPerformed(evt);
			}
		});
		acesso.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				AcessoKeyPressed(evt);
			}
		});
		getContentPane().add(acesso);
		acesso.setBounds(570, 160, 77, 44);
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Usuario:");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(200, 122, 76, 30);
		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel2.setText("Senha:");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(210, 210, 64, 30);

		getContentPane().add(login);
		login.setBounds(290, 120, 266, 32);
		
		senha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SenhaActionPerformed(evt);
			}
		});
		senha.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				SenhaKeyPressed(evt);
			}
		});
		getContentPane().add(senha);
		senha.setBounds(290, 210, 265, 32);
		getContentPane().add(jLabel3);
		jLabel3.setBounds(-20, -20, 870, 390);
		setBounds(250, 150, 866, 409);
	}

	private void SenhaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void AcessoActionPerformed(java.awt.event.ActionEvent evt) {
		boolean retorno = false;

		String user = login.getText();
		String password = String.valueOf(senha.getPassword()) ;

//		Momento de ligação entre a UI (essa classe) e a classe Bancário (fachada).
//		Importante perceber que essa classe UI é que chama a classe Bancario (fachada)
		Bancario bancario = new Bancario();
		retorno = bancario.login(user, password);

		if (retorno)
			JOptionPane.showMessageDialog(this, "Seja Bem Vindo Usuário.");
		else
			JOptionPane.showMessageDialog(this, "Acesso negado. Favor tentar novamente.");
	}

	private void SenhaKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER)
			acesso.requestFocus();
	}

	private void AcessoKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER)
			dispose();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Exemplo".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PrincipalComSwingLogin().setVisible(true);
			}
		});
	}
}