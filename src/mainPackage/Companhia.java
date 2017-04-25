package mainPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Date;

public class Companhia {
	
	private String nome;
	private ArrayList<Voo> listVoo;
	private ArrayList<Aviao> listAviao;

	private int qntdeVoo; //qntde voos realizados


	public Companhia(String nome){

		this.nome = nome;
		this.listVoo = new ArrayList<Voo>();
		this.listAviao = new ArrayList<Aviao>();
		this.qntdeVoo = 0;

	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Voo> getListVoo() {
		return listVoo;
	}
	public void setListVoo(ArrayList<Voo> listVoo) {
		this.listVoo = new ArrayList<Voo>(listVoo);
	}

	public ArrayList<Aviao> getListAviao() {
		return listAviao;
	}
	public void setListAviao(ArrayList<Aviao> listAviao) {
		this.listAviao = new ArrayList<Aviao>(listAviao);
	}

	// Retorna um Voo da lista
	public Voo getVoo(int numVoo) {
		if (numVoo < this.listVoo.size())
			return this.listVoo.get(numVoo);
		else
			//TODO Tela de Erro - Valor Invalido
			return null;
	}
	
	// Retorna Ultimo Aviao Cadastrado
	public Aviao getUltimoAviao() {
		if(!(listAviao.isEmpty()))
			return this.listAviao.get(listAviao.size()-1);
		else
			return null;
	}
	
	// Retorna Ultimo Voo Cadastrado
		public Voo getUltimoVoo() {
			//System.out.println(this.tamListAviao);
			
			if(!(listVoo.isEmpty()))
				return this.listVoo.get(listVoo.size()-1);
			else
				return null;
		}

	// Cadastra o aviao da Companhia Aerea
	public void cadastrarAviao(Double autonomiaVoo, Double altura, Double enverAsa, Double comprimento, Double capacCarga) {
		// Adiciona o novo aviao a lista de avioes

		Aviao a = new Aviao();

		// Adiciona o novo aviao a lista de avioes
		a.setAutonomiaVoo(autonomiaVoo);
		a.setAltura(altura);
		a.setEnverAsa(enverAsa);
		a.setComprimento(comprimento);
		a.setCapacCarga(capacCarga);

		this.listAviao.add(a);
	}

	// Cadastra o aviao da Companhia Aerea
	public void cadastrarAviao(Aviao aviao) {
		this.listAviao.add(aviao);
	}

	// Cadastra os voo's da Companhia Aerea
	public void cadastrarVoo(String infoVoo, int numVoo, String compAerea, Aviao aviao, Date dataVoo, 
		Date horarioVoo, String statusVoo, String destino, String origem, ArrayList<Passageiro> listaPsg, int qntdePsg) {	
		Voo voo = new Voo();
		// Adiciona o novo voo a lista de voo's

		// Adiciona o novo voo a lista de voo's
		voo.setInfoVoo(infoVoo);
		voo.setNumVoo(numVoo);
		voo.setCompAerea(compAerea);
		voo.setAviao(aviao);
		voo.setDataVoo(dataVoo);
		voo.setHorarioVoo(horarioVoo);
		voo.setStatusVoo(statusVoo);
		voo.setDestino(destino);
		voo.setOrigem(origem);
		voo.setListPsg(listaPsg);
		
		this.listVoo.add(voo);

	}

	// Cadastra os voo's da Companhia Aerea
	public void cadastrarVoo(Voo voo, Aviao aviao) {
		// Adiciona o novo voo a lista de voo's
		this.listVoo.add(voo);
	}
	

	// Exporta os dados da Companhia Aerea para um arquivo Json
	public void exportarVoo() {
		
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		int i = 0;

		//System.out.print("Tam "+this.tamListVoo+"\n");
		for (Voo v : listVoo) {
			System.out.print("Companhia "+getNome()+" --- Voo "+i+"\n"+
						"Info Voo: "+v.getInfoVoo()+"\n"+
						"Numero Voo: "+v.getNumVoo()+"\n"+
						"Companhia Aerea: "+v.getCompAerea()+"\n"+
						"Aviao: "+v.getAviao().getModelo()+"\n"+
						"Data: "+formData.format(v.getDataVoo())+"\n"+
						"Horario Voo: "+ formHora.format(v.getHorarioVoo())+"\n"+
						"Status Voo: "+v.getStatusVoo()+"\n"+
						"Destino: "+v.getDestino()+"\n"+
						"Origem: "+v.getOrigem()+"\n");	
			i++;
		}
	}

	public void setQntdeVoo(int qntdeVoo) {
		this.qntdeVoo = qntdeVoo;
	}
}