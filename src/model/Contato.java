package model;

import java.util.List;
import java.util.Scanner;

import services.ContatoServices;

public class Contato {

	private int id;
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	
	public Contato(int id, String nome, String telefone, String celular, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public Contato() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addContatoForm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Adicione o nome do contato:");
		this.nome = sc.nextLine();
		System.out.println("Adicione o telefone do contato:");
		this.telefone = sc.nextLine();
		System.out.println("Adicione o celular do contato:");
		this.celular = sc.nextLine();
		System.out.println("Adicione o email do contato:");
		this.email = sc.nextLine();
		
	}
	
	public void deletarContato() {
		Scanner sc = new Scanner(System.in);
		ContatoServices cs = new ContatoServices();
		System.out.println("Digite o 'id' do contato para deletar:");
		this.id = sc.nextInt();
		
		cs.deleteContato(this.id);
		
		System.out.println("Contato deletado com sucesso");
	}
	
	public void listarContatos() {
		ContatoServices cs = new ContatoServices();
		List<Contato> lista = cs.getAll();
		for(Contato ctt: lista) {
			System.out.println(ctt.getId() + ": " + ctt.getNome());
		}
	}
	
	
	
	
}
