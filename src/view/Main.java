package view;


import java.util.List;

import model.Contato;

import services.ContatoServices;

public class Main {

	public static void main(String[] args) {
	
		Contato contato = new Contato();
		
		//contato.addContatoForm();
		
		ContatoServices cs = new ContatoServices();
		//cs.addContato(contato);
		//cs.deleteContato(3);
		//List<Contato> lista = cs.getAll();
//		List<Contato> lista = cs.procurarContatoId(3);
//		for(Contato ctt: lista) {
//			System.out.println(ctt.getId() + ": " + ctt.getNome());
//		}
//		System.out.println("Contato deletado com sucesso");
		
		contato.deletarContato();
		
	
		

	}

}
