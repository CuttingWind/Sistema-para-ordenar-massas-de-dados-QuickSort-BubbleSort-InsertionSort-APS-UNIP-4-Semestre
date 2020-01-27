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
import java.util.Random;

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

public class QuickSort extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3708202383165490382L;

	private JPanel contentPane;
	static ArrayList<String> dado = new ArrayList<String>();
	ArrayList<Integer> al;
	ArrayList<String> s;
	static String[] arrayDado;
	static int[] arrayDadoI;
	int i;
	String tempo;
	private JTextField txtTempo;
	private JButton btptxt;
	private JButton btVoltar;

	// Le o arquivo.
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

	// Converte o ArrayList para um simples array para ser realizado o quickSort.
	public static void converterArray() {
		arrayDado = dado.toArray(new String[dado.size()]);
		arrayDadoI = new int[arrayDado.length - 1];

		for (int i = 0; i < arrayDadoI.length; i++) {
			arrayDadoI[i] = Integer.parseInt(arrayDado[i]);// Parsing from string to int
		}
	}

	// Inicio QuickSort.
	public void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int low, int high) {
		if (low < high + 1) {
			int p = partition(a, low, high);
			quickSort(a, low, p - 1);
			quickSort(a, p + 1, high);
		}
	}

	private void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}

	private int partition(int[] a, int low, int high) {
		swap(a, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (a[i] < a[low]) {
				swap(a, i, border++);
			}
		}
		swap(a, low, border - 1);
		return border - 1;
	}
	// Fim QuickSort

	// Calcula o tempo que demorou para ser realizado a ordenaçao
	private void tempoDeExecucao() {
		long segundos = 00;
		long minutos = 00;
		long horas = 00;

		long ms1 = System.currentTimeMillis();

		quickSort(arrayDadoI);

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
		} else {
			System.out.println(ms + " Milesimos");
		}
		tempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
		System.out.println(tempo);
	}

	// Cria um arraylist para gravar no arq
	private void arrayParaGravar() {
		int aux;
		String aux1;
		al = new ArrayList<Integer>();
		s = new ArrayList<String>();
		for (int i = 0; i < arrayDadoI.length; i++) {
			al.add(arrayDadoI[i]);
			aux = arrayDadoI[i];
			aux1 = "" + aux;
			s.add(aux1);
		}
	}

	// Construtor
	public QuickSort() {
		
		lerArq();
		converterArray();
		tempoDeExecucao();
		arrayParaGravar();
		
		setTitle("APS: QUICK SORT\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QuickSort");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
		lblNewLabel.setBounds(10, 0, 564, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Arquivo Ordenado:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(208, 81, 150, 29);
		contentPane.add(lblNewLabel_1);

		btptxt = new JButton("Passar para txt");
		btptxt.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btptxt.setBounds(419, 215, 129, 38);
		btptxt.addActionListener(this);
		contentPane.add(btptxt);

		btVoltar = new JButton("Voltar ao inicio");
		btVoltar.setBackground(Color.RED);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btVoltar.setBounds(419, 286, 129, 38);
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
				
		JLabel lblArquivoDesordenado = new JLabel("Arquivo Desordenado:");
		lblArquivoDesordenado.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblArquivoDesordenado.setBounds(10, 80, 167, 29);
		contentPane.add(lblArquivoDesordenado);
		
		JScrollPane scrollPanee = new JScrollPane();
		scrollPanee.setBounds(10, 120, 150, 230);
		contentPane.add(scrollPanee);

		JList<Object> jListSource = new JList<>(dado.toArray());
		jListSource.setName("jListSource");
		scrollPanee.setViewportView(jListSource);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 120, 150, 230);
		contentPane.add(scrollPane);
		
		JList<Object> list = new JList<>(al.toArray());
		scrollPane.setViewportView(list);
		
		setLocationRelativeTo(null);
	}

	// Grava a ordenaçao em um txt
	public void gravaTxt() {
		System.out.println(dado);
		File file1 = new File("DadosOrdenados.txt");
		file1.delete();
		File file = new File("DadosOrdenados.txt");
		String nome = "";
		String conteudo;
		try {
			FileWriter f = new FileWriter(file, true);
			for (int i = 0; i < s.size(); i++) {
				nome = s.get(i);
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
