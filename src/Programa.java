import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Programa {
	static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private static class Pilha {
		public int numero;
		public double valor;
		public int pedido;
		public Pilha proximo;
	}

	public static void main(String[] args) {
		Pilha topoPilha = null;
		Pilha auxiliar;
		int op = 0;
		do {
			String menu = "\nMENU DE OPÇÕES\n" + "\n1 - Empilhar Chapas." + "\n2 - Consultar Todas as Chapas."
					+ "\n3 - Desempilhar Chapas." + "\n4 - Remover Todas as Chapas Da Pilha."
					+ "\n5 - Verificar Quantidade de Chapas." + "\n6 - Sair";

			op = Integer.parseInt(JOptionPane.showInputDialog(menu, "1"));
			if (op < 1 || op > 6) {
				log("Opção inválida. Escolha uma opção entre 1 e 6");
				JOptionPane.showMessageDialog(null, "A PILHA está vazia!", "Mensagem do Programa",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (op == 1) {				
				Pilha novo = new Pilha();
				novo.numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
				novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
				novo.pedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
				// Operacoes de empilhamento
				novo.proximo = topoPilha;
				topoPilha = novo;
				log("Opção 1 - Empilhar chapas");
			}
			if (op == 2) {				
				if (topoPilha == null) {					
					JOptionPane.showMessageDialog(null, "A PILHA está vazia!", "Mensagem do Programa",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					JTextArea saida = new JTextArea(6, 35); // ALTURA E LARGURA
					JScrollPane scroll = new JScrollPane(saida);
					saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
					saida.append("===============================\n");
					auxiliar = topoPilha;
					while (auxiliar != null) {
						System.out.println("Endereço de memória => " + auxiliar.hashCode());
						saida.append(auxiliar.numero + "\t" + auxiliar.valor + "\t" + auxiliar.pedido + "\n");
						auxiliar = auxiliar.proximo;
					}
					JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS",
							JOptionPane.INFORMATION_MESSAGE);
					log("Opção 2 - Consultar todas a chapas");
				}
			}
			if (op == 3) {
				if (topoPilha == null) {					
					JOptionPane.showMessageDialog(null, "A PILHA está vazia!", "Mensagem do Programa",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Número: " + topoPilha.numero + ", foi removido.",
							"Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
	                 topoPilha = topoPilha.proximo;
	                 log("Opção 3 - Desempilhar");
				}
			}
			if (op == 4) {
				if (topoPilha == null) {					
					JOptionPane.showMessageDialog(null, "A PILHA está vazia!", "Mensagem do Programa",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					topoPilha = null;
					JOptionPane.showMessageDialog(null, "A pilha foi esvaziada",
							"Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
					log("Opção 4 - Esvaziar Pilha de chapas");
				}
			}
			if (op == 5) {
				  if (op == 5) {
		                auxiliar = topoPilha;
		                int n = 0;
		                while (auxiliar != null) {
		                    auxiliar = auxiliar.proximo;
		                    n++;
		                }
		                JOptionPane.showMessageDialog(null, "A Pilha contém: " + n + " elementos.",
		                		"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
		                		log("Opção 5 - Verifica quantidade de chapas");
		            }
			}
		} while (op != 6);
		log("Opção 6 - >>> Programa finalizado!");
	}

	public static void log(String texto) {
		System.out.println("Acessou: " + texto + " - " + getDateTime());
	}

	public static String getDateTime() {
		Date date = new Date();
		return dateFormat.format(date);
	}
}
