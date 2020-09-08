package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrdemStatus;

public class Ordem {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date momento = new Date();
	private OrdemStatus status;
	private Cliente cliente;
	private List<OrdemItem> listaOrdemItem = new ArrayList<>();

	public Ordem() {

	}

	public Ordem(Date momento, OrdemStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public void addItem(OrdemItem item) {
		listaOrdemItem.add(item);
	}

	public void removeItem(OrdemItem item) {
		listaOrdemItem.remove(item);
	}

	public Double total() {
		double total = 0;
		for (OrdemItem o : listaOrdemItem) {
			total += o.subTotal();
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RESUMO DO PEDIDO:\n");
		sb.append("Data do pedido: " + sdf.format(getMomento()) + "\n");
		sb.append("Status do pedido: " + getStatus() + "\n");
		sb.append("Cliente: " + cliente.getNome() + " " + "(" + sdf1.format(cliente.getNascimento()) + ")" + " - "
				+ cliente.getEmail() + "\n");
		sb.append("Itens do pedido:\n");
		for (OrdemItem o : listaOrdemItem) {
			sb.append(o.getProduto().getNome() + ", $" + String.format("%.2f", o.getProduto().getPreco()) + ", Quantidade: " + o.getQuantidade() + ", Subtotal: $"
					+ String.format("%.2f", o.subTotal()) + "\n");
		}
		sb.append("Preço total: $" + String.format("%.2f", total()));
		return sb.toString();
	}

}
