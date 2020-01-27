package aps.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame implements ActionListener {

	/**
	 * Classe inicio um JFrame que apenas serve como "capa" do projeto.
	 **/

	// Serial gerado pelo eclipse.
	private static final long serialVersionUID = 7038862462158577803L;

	private JPanel contentPane;
	private JLabel titulo = new JLabel("<html>APS:<br>\tORDENA\u00C7\u00C3O<br>\tDE DADOS</html>");
	private JButton btInicio = new JButton("INICIAR");

	// Construtor
	public Inicio() {

		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("APS: ORDENA\u00C7\u00C3O DE DADOS\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 70));
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setBounds(40, 20, 510, 260);
		contentPane.add(titulo);
		btInicio.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		btInicio.setBounds(407, 316, 153, 44);
		btInicio.addActionListener(this);
		contentPane.add(btInicio);
		setLocationRelativeTo(null);
	}

	// Metodo de ação vindo da interface "ActionPerfomed".
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btInicio) {
			System.out.println("oi");
			this.dispose();
			MenuArq ma = new MenuArq();
			ma.setVisible(true);
		}

	}
}
