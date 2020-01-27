package aps.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuArq extends JFrame implements ActionListener {

	/**
	 * Classe MenuArq que da o usuario a opçao de escolher entre 3 massas de dados
	 **/

	// Serial gerado pelo eclipse
	private static final long serialVersionUID = 8202388980408570622L;

	private JPanel contentPane;
	private JButton bt3k = new JButton("3.000");
	private JButton bt100k = new JButton("100.000");
	private JButton bt1kk = new JButton("1.000.000");
	Random rand = new Random();

	// Esta funçao gera numeros aleatorios para o arquivo.
	private void geraNum(int tam) {
		int x = 0;
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("dados.txt"));
			int numero[];
			numero = new int[tam - 1];
			String num[] = new String[tam - 1];
			while (x < tam - 1) {
				numero[x] = rand.nextInt(8999) + 1000;
				num[x] = String.valueOf(numero[x]);
				out.write(num[x]);
				out.newLine();
				x++;

			}
			out.close();
		} catch (IOException e) {

		}
	}

	// Construtor
	public MenuArq() {
		setTitle("APS: SELE\u00C7\u00C3O A QUANTIA\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 584, 361);
		contentPane.add(panel);

		JLabel titulo = new JLabel("<html>Selecione quantos<br>dados deseja<br>ordenar:</html>");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 53));
		titulo.setBounds(40, 20, 500, 200);
		panel.add(titulo);

		bt3k.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		bt3k.setBounds(40, 280, 103, 53);
		bt3k.addActionListener(this);
		panel.add(bt3k);

		bt100k.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		bt100k.setBounds(241, 280, 103, 53);
		bt100k.addActionListener(this);
		panel.add(bt100k);

		bt1kk.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		bt1kk.setBounds(440, 280, 103, 53);
		bt1kk.addActionListener(this);
		panel.add(bt1kk);
		setLocationRelativeTo(null);
	}

	// Metodo de ação vindo da interface "ActionPerfomed".
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt3k) {
			geraNum(3001);
			this.dispose();
			Menu m = new Menu();
			m.setVisible(true);
		}
		if (e.getSource() == bt100k) {
			geraNum(100001);
			this.dispose();
			Menu m = new Menu();
			m.setVisible(true);
		}
		if (e.getSource() == bt1kk) {
			geraNum(1000001);
			this.dispose();
			Menu m = new Menu();
			m.setVisible(true);
		}
	}
}
