package mainPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Companhia {
	
	private String nome;
	private Voo[] listVoo = new Voo[100];
	private Aviao[] listAviao = new Aviao[100];
	private int tamListVoo;
	private int tamListAviao;
	private int qntdeVoo; //qntde voos realizados


	public Companhia(String nome){

		this.nome = nome;
		//this.listVoo = null;
		//this.listAviao = null;
		this.tamListVoo = 0;
		this.tamListAviao = 0;
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

	public Aviao[] getListAviao() {
		return listAviao;
	}
	public void setListAviao(Aviao[] listAviao) {
		this.listAviao = listAviao;
	}

	// Retorna um Voo da lista
	public Voo getVoo(int numVoo) {
		if (numVoo < this.listVoo.length)
			return this.listVoo[numVoo];
		else
			//TODO Tela de Erro - Valor Invalido
			return null;
	}
	
	// Retorna Ultimo Aviao Cadastrado
	public Aviao getUltimoAviao() {
		if(this.tamListAviao != 0)
			return this.listAviao[this.tamListAviao-1];
		else
			return null;
	}
	
	// Retorna Ultimo Voo Cadastrado
		public Voo getUltimoVoo() {
			if(this.tamListAviao != 0)
				return this.listVoo[this.tamListVoo-1];
			else
				return null;
		}

	// Cadastra o aviao da Companhia Aerea
	public void cadastrarAviao(Double autonomiaVoo, Double altura, Double enverAsa, Double comprimento, Double capacCarga) {
		// Adiciona o novo aviao a lista de avioes

		this.listAviao[this.tamListAviao] = new Aviao();

		// Adiciona o novo aviao a lista de avioes
		this.listAviao[this.tamListAviao].setAutonomiaVoo(autonomiaVoo);
		this.listAviao[this.tamListAviao].setAltura(altura);
		this.listAviao[this.tamListAviao].setEnverAsa(enverAsa);
		this.listAviao[this.tamListAviao].setComprimento(comprimento);
		this.listAviao[this.tamListAviao].setCapacCarga(capacCarga);

		//Atualiza o tamanho da lista
		this.tamListAviao++;
	}

	// Cadastra o aviao da Companhia Aerea
	public void cadastrarAviao(Aviao aviao) {
		// Adiciona o novo aviao a lista de avioes
		this.listAviao[this.tamListAviao] = aviao;
		//Atualiza o tamanho da lista
		this.tamListAviao++;
	}

	// Cadastra os voo's da Companhia Aerea
	public void cadastrarVoo(String infoVoo, int numVoo, String compAerea, Aviao aviao, Date dataVoo, 
		Date horarioVoo, String statusVoo, String destino, String origem, Passageiro[] listaPsg, int qntdePsg) {	
		
		// Adiciona o novo voo a lista de voo's
		this.listVoo[this.tamListVoo] = new Voo(aviao);

		// Adiciona o novo voo a lista de voo's
		this.listVoo[this.tamListVoo].setInfoVoo(infoVoo);
		this.listVoo[this.tamListVoo].setNumVoo(numVoo);
		this.listVoo[this.tamListVoo].setCompAerea(compAerea);
		this.listVoo[this.tamListVoo].setAviao(aviao);
		this.listVoo[this.tamListVoo].setDataVoo(dataVoo);
		this.listVoo[this.tamListVoo].setHorarioVoo(horarioVoo);
		this.listVoo[this.tamListVoo].setStatusVoo(statusVoo);
		this.listVoo[this.tamListVoo].setDestino(destino);
		this.listVoo[this.tamListVoo].setOrigem(origem);
		this.listVoo[this.tamListVoo].setListPsg(listaPsg);
		this.listVoo[this.tamListVoo].setQntdePsg(qntdePsg);

		//Atualiza o tamanho da lista
		this.tamListVoo++;
	}

	// Cadastra os voo's da Companhia Aerea
	public void cadastrarVoo(Voo voo, Aviao aviao) {
		// Adiciona o novo voo a lista de voo's
		this.listVoo[this.tamListVoo] = new Voo(aviao);
		//Atualiza o tamanho da lista
		this.tamListVoo++;
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