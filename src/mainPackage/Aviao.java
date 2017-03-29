//package mainPackage;

public class Aviao {

	private String modelo;
	private Double autonomiaVoo;
	private Double altura;
	private Double enverAsa;
	private Double comprimento;
	private Double capacCarga;
	private Passageiro[] listaPsg;
	private int qntdePsg;

	public Aviao() {
		modelo = "";
		autonomiaVoo = 0.0;
		altura = 0.0;
		enverAsa = 0.0;
		comprimento = 0.0;
		capacCarga = 0.0;
		listaPsg = null;
		qntdePsg = 0;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getAutonomiaVoo() {
		return autonomiaVoo;
	}
	public void setAutonomiaVoo(Double autonomiaVoo) {
		this.autonomiaVoo = autonomiaVoo;
	}

	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getEnverAsa() {
		return enverAsa;
	}
	public void setEnverAsa(Double enverAsa) {
		this.enverAsa = enverAsa;
	}

	public Double getComprimento() {
		return comprimento;
	}
	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getCapacCarga() {
		return capacCarga;
	}
	public void setCapacCarga(Double capacCarga) {
		this.capacCarga = capacCarga;
	}

	public Passageiro[] getListaPsg() {
		return listaPsg;
	}
	public void setListaPsg(Passageiro[] listaPsg) {
		this.listaPsg = listaPsg;
	}

	public int getQntdePsg() {
		return qntdePsg;
	}
	public void setQntdePsg(int qntdePsg) {
		this.qntdePsg = qntdePsg;
	}
}