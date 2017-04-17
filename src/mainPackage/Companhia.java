//package mainPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Companhia {
	
	private String nome;
	private Voo[] listVoo = new Voo[100];
	private int tamListVoo;
	private int qntdeVoo; //qntde voos realizados


	public Companhia(){

		this.nome = "";
		this.listVoo = null;
		this.tamListVoo = 0;
		this.qntdeVoo = 0;

	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Voo[] getListVoo() {
		return listVoo;
	}
	public void setListVoo(Voo[] listVoo) {
		this.listVoo = listVoo;
	}

	// Retorna um Voo da lista
	public Voo getVoo(int numVoo) {
		if (numVoo < this.listVoo.length)
			return this.listVoo[numVoo];
		else
			//TODO Tela de Erro - Valor Invalido
			return null;
	}

	// Cadastra os voo da Companhia Aerea
	public void cadastrarVoo(String infoVoo, int numVoo, String compAerea, Aviao aviao, Date dataVoo, 
		Date horarioVoo, String statusVoo, String destino, String origem, Passageiro[] listaPsg, int qntdePsg) {
		
		// Adiciona o novo voo a lista de voo's
		// Encontra uma posicao vazia na Lista de Voo's
		for (int i = 0; i < this.listVoo.length; i++) {
			if (this.listVoo[i] == null) {
				// Cria um novo voo
				this.listVoo[i] = new Voo(aviao);

				// Adiciona o novo voo a lista de voo's
				this.listVoo[i].setInfoVoo(infoVoo);
				this.listVoo[i].setNumVoo(numVoo);
				this.listVoo[i].setCompAerea(compAerea);
				this.listVoo[i].setAviao(aviao);
				this.listVoo[i].setDataVoo(dataVoo);
				this.listVoo[i].setHorarioVoo(horarioVoo);
				this.listVoo[i].setStatusVoo(statusVoo);
				this.listVoo[i].setDestino(destino);
				this.listVoo[i].setOrigem(origem);
				this.listVoo[i].setListaPsg(listaPsg);
				this.listVoo[i].setQntdePsg(qntdePsg);

				//Atualiza o tamanho da lista
				this.tamListVoo = i;
				break;
			}
		}
	}

	// Exporta os dados da Companhia Aerea para um arquivo Json
	public void exportarVoo() {
		
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		int i;

		System.out.print("Tam "+this.tamListVoo+"\n");
		for (i = 0; i <= this.tamListVoo; i++) {
			System.out.print("Companhia "+getNome()+" --- Voo "+i+"\n"+
						"Info Voo: "+listVoo[i].getInfoVoo()+"\n"+
						"Numero Voo: "+listVoo[i].getNumVoo()+"\n"+
						"Companhia Aerea: "+listVoo[i].getCompAerea()+"\n"+
						"Aviao: "+listVoo[i].getAviao().getModelo()+"\n"+
						"Data: "+formData.format(listVoo[i].getDataVoo())+"\n"+
						"Horario Voo: "+ formHora.format(listVoo[i].getHorarioVoo())+"\n"+
						"Status Voo: "+listVoo[i].getStatusVoo()+"\n"+
						"Destino: "+listVoo[i].getDestino()+"\n"+
						"Origem: "+listVoo[i].getOrigem()+"\n");	
		}
	}

	public void setQntdeVoo(int qntdeVoo) {
		this.qntdeVoo = qntdeVoo;
	}
}