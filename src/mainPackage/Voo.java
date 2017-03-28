//package mainPackage;

import java.util.Date;

public class Voo {

	private String infoVoo; // incluido, alterado, excluido
	private int numVoo;
	private String compAerea;
	private Aviao aviao;
	private Date data;
	private Date horarioVoo;
	private String statusVoo; // confirmado, cancelado, atrasado
	private String destino;
	private String origem;

	public Voo(Aviao aviao) {
		infoVoo = "";
		numVoo = 0;
		compAerea = "";
		aviao = new Aviao();
		data = null;
		horarioVoo = null;
		statusVoo = "";
		destino = "";
		origem = "";
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

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
}