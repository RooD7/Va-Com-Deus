package mainPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Voo {

	private String infoVoo; // incluido, alterado, excluido
	private int numVoo;
	private String compAerea;
	private Aviao aviao;
	private Date dataVoo;
	private Date horarioVoo;
	private String statusVoo; // confirmado, cancelado, atrasado
	private String destino;
	private String origem;

	private ArrayList<Passageiro> listPsg;


	public Voo() {
		infoVoo = "";
		numVoo = 0;
		compAerea = "";
		dataVoo = null;
		horarioVoo = null;
		statusVoo = "";
		destino = "";
		origem = "";
		this.listPsg = new ArrayList<Passageiro>();

	}

	public Voo(Voo vooJson, Aviao aviao) {
		infoVoo = vooJson.getInfoVoo();
		numVoo = vooJson.getNumVoo();
		compAerea = vooJson.getCompAerea();
		this.aviao = aviao;
		dataVoo = vooJson.getDataVoo();
		horarioVoo = vooJson.getHorarioVoo();
		statusVoo = vooJson.getStatusVoo();
		destino = vooJson.getDestino();
		origem = vooJson.getOrigem();
		this.listPsg = new ArrayList<Passageiro>();

	}

	public String getInfoVoo() {
		return infoVoo;
	}
	public void setInfoVoo(String infoVoo) {
		this.infoVoo = infoVoo;
	}

	public int getNumVoo() {
		return numVoo;
	}
	public void setNumVoo(int numVoo) {
		this.numVoo = numVoo;
	}

	public String getCompAerea() {
		return compAerea;
	}
	public void setCompAerea(String compAerea) {
		this.compAerea = compAerea;
	}

	public Aviao getAviao() {
		return aviao;
	}
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Date getDataVoo() {
		return dataVoo;
	}
	public void setDataVoo(Date dataVoo) {
		this.dataVoo = dataVoo;
	}

	public Date getHorarioVoo() {
		return horarioVoo;
	}
	public void setHorarioVoo(Date horarioVoo) {
		this.horarioVoo = horarioVoo;
	}

	public String getStatusVoo() {
		return statusVoo;
	}
	public void setStatusVoo(String statusVoo) {
		this.statusVoo = statusVoo;
	}

	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public ArrayList<Passageiro> getListPsg() {
		return listPsg;
	}
	public void setListPsg(ArrayList<Passageiro> listPsg) {
		this.listPsg = listPsg;
	}


	// Cadastra o passageiro do Voo
	public void cadastrarPassageiro(String nome, String telef, String email, String cpf, Date dataNasc) {

		// Adiciona o novo passageiro a lista de Passageiros
		Passageiro p = new Passageiro();
		
		// Adiciona o novo passageiro a lista de Passageiros
		p.setNome(nome);
		p.setCpf(cpf);
		p.setTelef(telef);
		p.setEmail(email);
		p.setDataNasc(dataNasc);
		
		this.listPsg.add(p);

	}

	public void cadastrarPassageiro(Passageiro passageiro) {
		// Adiciona o novo passageiro a lista de Passageiros
		this.listPsg.add(passageiro);

	}

	public String imprime() {

		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		return "Voo\n"+
				"Info Voo: "+getInfoVoo()+"\n"+
				"Numero Voo: "+getNumVoo()+"\n"+
				"Companhia Aerea: "+getCompAerea()+"\n"+
				"Aviao: "+getAviao().getModelo()+"\n"+
				"Data: "+formData.format(getDataVoo())+"\n"+
				"Horario Voo: "+ formHora.format(getHorarioVoo())+"\n"+
				"Status Voo: "+getStatusVoo()+"\n"+
				"Destino: "+getDestino()+"\n"+
				"Origem: "+getOrigem()+"\n"+
				"ListaPsg: "+getListPsg()+"\n";
	}

}