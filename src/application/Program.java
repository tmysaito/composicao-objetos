package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemItem;
import entities.Produto;
import entities.enums.OrdemStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner (System.in);
	
	System.out.println("Entre com os dados do cliente: ");
	System.out.print("Nome: ");
	String nome = sc.nextLine();
	System.out.print("Email: ");
	String email = sc.nextLine();
	System.out.print("Data de nascimento (DD/MM/YYYY): ");
	String nascimento = sc.next();
	
	Cliente cliente = new Cliente(nome, email, nascimento);
	
	System.out.println("Entre com os dados do pedido: ");
	System.out.print("Status: ");
	String status = sc.next();
	System.out.print("Quantos itens?  ");
	int quantidade = sc.nextInt();
	sc.nextLine();
	
	Ordem ordem = new Ordem(new Date(), OrdemStatus.valueOf(status), cliente);
	
	for(int i=1; i<=quantidade; i++) {
		System.out.println("Digite os dados do item #" + i + ":" );
		System.out.print("Nome do produto: ");
		String nomeProduto = sc.nextLine();
		System.out.print("Pre�o do produto: ");
		double preco = sc.nextDouble();
		System.out.print("Quantidade: ");
		int quantidadeProduto = sc.nextInt();
		sc.nextLine();
		OrdemItem ordemItem = new OrdemItem(quantidadeProduto, preco, new Produto(nomeProduto, preco));		
		ordem.addItem(ordemItem);
	}
	
	System.out.println();
	System.out.println(ordem);
	
	sc.close();

	}

}
