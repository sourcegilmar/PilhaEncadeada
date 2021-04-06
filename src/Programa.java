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
		Pilha topo = null;
		Pilha aux;
		int op = 0;
		do {
			String menu = "\nMENU DE OP��ES\n" + "\n1 - Empilhar Chapas." + "\n2 - Consultar Todas as Chapas."
					+ "\n3 - Desempilhar Chapas." + "\n4 - Remover Todas as Chapas Da Pilha."
					+ "\n5 - Verificar Quantidade de Chapas." + "\n6 - Sair";

			op = Integer.parseInt(JOptionPane.showInputDialog(menu, "1"));
			if (op < 1 || op > 6) {
				log("Op��o inv�lida. Escolha uma op��o entre 1 e 6");
				JOptionPane.showMessageDialog(null, "A PILHA est� vazia!", "Mensagem do Programa",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (op == 1) {
				log("Op��o 1 - Empilhar chapas");
				Pilha novo = new Pilha();
				novo.numero = Integer.parseInt(JOptionPane.showInputDialog("N�MERO DA CHAPA", "0"));
				novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
				novo.pedido = Integer.parseInt(JOptionPane.showInputDialog("N�MERO DO PEDIDO", "0"));
				// Operacoes de empilhamento
				novo.proximo = topo;
				topo = novo;
			}
			if (op == 2) {
				if (topo == null) {
					log("Op��o 2 - Consultar todas a chapas");
					JOptionPane.showMessageDialog(null, "A PILHA est� vazia!", "Mensagem do Programa",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					JTextArea saida = new JTextArea(6, 35); // ALTURA E LARGURA
					JScrollPane scroll = new JScrollPane(saida);
					saida.append("N�MERO\t" + "VALOR\t" + "PEDIDO\n");
					saida.append("===============================\n");
					aux = topo;
					while (aux != null) {
						System.out.println("Endere�o de mem�ria => " + aux.hashCode());
						saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
						aux = aux.proximo;
					}
					JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
			if (op == 3) {
				if (topo == null) {
					log("Op��o 3 - Desempilhar");
					JOptionPane.showMessageDialog(null, "A PILHA est� vazia!", "Mensagem do Programa",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"N�mero: " + topo.numero + ", foi removido.",
							"Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
	                 topo = topo.proximo;

				}
			}
			if (op == 4) {
				if (topo == null) {
					log("Op��o 4 - Esvaziar Pilha de chapas");
					JOptionPane.showMessageDialog(null, "A PILHA est� vazia!", "Mensagem do Programa",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

				}
			}
			if (op == 5) {
				log("Op��o 5 - Verifica quantidade de chapas");
			}
		} while (op != 6);
		log("Op��o 6 - >>> Programa finalizado!");
	}

	public static void log(String texto) {
		System.out.println("Acessou: " + texto + " - " + getDateTime());
	}

	public static String getDateTime() {
		Date date = new Date();
		return dateFormat.format(date);
	}
}
