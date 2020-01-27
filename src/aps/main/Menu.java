package aps.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame implements ActionListener {

	/**
	 * Classe Menu que da ao usuario opcao de qual metodo de ordenação ele deseja
	 * utilizar.
	 **/

	// Serial gerado pelo eclipse
	private static final long serialVersionUID = -7902102429110297622L;

	private JPanel contentPane;
	JButton btbb = new JButton("<html>BUBBLE<br>SORT</html>");
	JButton btqs = new JButton("<html>QUICK<br>SORT</html>");
	JButton btis = new JButton("<html>INSERTION<br>SORT</html>");

	// Construtor
	public Menu() {
		setTitle("APS: MENU");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel menu = new JLabel("MENU:");
		menu.setFont(new Font("Comic Sans MS", Font.BOLD, 140));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setBounds(40, 20, 500, 200);
		contentPane.add(menu);

		btbb.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btbb.setBounds(40, 280, 103, 53);
		btbb.addActionListener(this);
		contentPane.add(btbb);

		btqs.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btqs.setBounds(241, 280, 105, 53);
		btqs.addActionListener(this);
		contentPane.add(btqs);

		btis.setHorizontalAlignment(SwingConstants.LEFT);
		btis.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btis.setBounds(440, 280, 103, 53);
		btis.addActionListener(this);
		contentPane.add(btis);
		setLocationRelativeTo(null);
	}

	// Metodo de ação vindo da interface "ActionPerfomed".
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btbb) {
			this.dispose();
			BubbleSort bb = new BubbleSort();
			bb.setVisible(true);
		}
		if (e.getSource() == btis) {
			this.dispose();
			InsertionSort is = new InsertionSort();
			is.setVisible(true);
		}
		if (e.getSource() == btqs) {
			this.dispose();
			QuickSort qs = new QuickSort();
			qs.setVisible(true);
		}
	}

}
