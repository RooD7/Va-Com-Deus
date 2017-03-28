public class Aviao {

	private Double autonomiaVoo;
	private Double altura;
	private Double enverAsa;
	private Double comprAsa;
	private Double capacCarga;
	private Passageiro[] listaPsg;
	private int qntdePsg;

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

	public Double getComprAsa() {
		return comprAsa;
	}
	public void setComprAsa(Double comprAsa) {
		this.comprAsa = comprAsa;
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