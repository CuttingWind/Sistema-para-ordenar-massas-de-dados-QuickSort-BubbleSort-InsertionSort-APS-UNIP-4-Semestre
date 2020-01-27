package aps.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.UnknownException;

public class InsertionSort extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2397976143096258193L;

	private JPanel contentPane;
	ArrayList<String> dado = new ArrayList<String>();
	ArrayList<String> dadoD = new ArrayList<String>();
	int i;
	String tempo;
	private JTextField txtTempo;
	private JButton btptxt;
	private JButton btVoltar;

	private void lerArq() {
		try {
			FileReader arq = new FileReader("dados.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";

			try {
				while (linha != null) {
					linha = lerArq.readLine();
					dado.add(linha);
					i++;
				}

				arq.close();
			} catch (IOException e) {

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void Inserction(ArrayList<String> list) {
		for (int i = 1; i < list.size() - 1; i++) {
			String key = list.get(i);
			int j = i - 1;
			while ((j > -1) && (list.get(j).compareToIgnoreCase(key) < 0)) {
				list.set(j + 1, list.get(j));
				j--;

			}
			list.set(j + 1, key);
		}
	}

	private void tempoDeExecucao() {

		long segundos = 00;
		long minutos = 00;
		long horas = 00;

		long ms1 = System.currentTimeMillis();

		Inserction(dado);

		long ms = System.currentTimeMillis() - ms1;

		if (ms >= 1000) {
			segundos = ms / 1000;
			segundos = segundos % 60;
			if (ms >= 60000) {
				minutos = ms / 60000;
				minutos = minutos % 60;
				if (ms >= 3600000) {
					horas = ms / 3600000;
					horas = (horas % 60);
				}
			}
		}
		tempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);

		System.out.println(tempo);
	}

	public InsertionSort() {
		setTitle("APS: INSERTION SORT");
		lerArq();
		dadoD.addAll(dado);
			
		System.out.println(dado.size());

		tempoDeExecucao();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("InsertionSort");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
		lblNewLabel.setBounds(10, 0, 564, 60);
		contentPane.add(lblNewLabel);

		btptxt = new JButton("Passar para txt");
		btptxt.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btptxt.setBounds(419, 218, 129, 38);
		btptxt.addActionListener(this);
		contentPane.add(btptxt);

		btVoltar = new JButton("Voltar ao inicio");
		btVoltar.setBackground(Color.RED);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btVoltar.setBounds(419, 278, 129, 38);
		btVoltar.addActionListener(this);
		contentPane.add(btVoltar);

		txtTempo = new JTextField();
		txtTempo.setText(tempo);
		txtTempo.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		txtTempo.setEditable(false);
		txtTempo.setBounds(419, 157, 129, 38);
		contentPane.add(txtTempo);
		txtTempo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("O tempo foi de:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_2.setBounds(419, 120, 129, 26);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 150, 230);
		contentPane.add(scrollPane);
		
		JList<Object> list = new JList<>(dadoD.toArray());
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(208, 120, 150, 230);
		contentPane.add(scrollPane_1);
		
		JList<Object> list_1 = new JList<>(dado.toArray());
		scrollPane_1.setViewportView(list_1);
		
		JLabel label = new JLabel("Arquivo Desordenado:");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label.setBounds(10, 84, 167, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Arquivo Ordenado:");
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label_1.setBounds(208, 85, 150, 29);
		contentPane.add(label_1);
		setLocationRelativeTo(null);
	}

	public void gravaTxt() {
		File file1 = new File("DadosOrdenados.txt");
		file1.delete();
		File file = new File("DadosOrdenados.txt");
		String nome = "";
		String conteudo;
		try {
			FileWriter f = new FileWriter(file, true);
			for (int i = 0; i < dado.size(); i++) {
				nome = dado.get(i);
				conteudo = nome;
				conteudo += "\r\n";
				f.write(conteudo);
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnknownException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btVoltar) {
			dispose();
			Inicio ini = new Inicio();
			ini.setVisible(true);
		}
		if (e.getSource() == btptxt) {
			gravaTxt();
			JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");
		}
	}

}
