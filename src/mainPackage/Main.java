//package mainPackage;

public class Main {

	public static void main(String[] args) {
		Aviao aviao = new Aviao();
		Voo voo = new Voo(aviao);
		Passageiro psg = new Passageiro();
		Passageiro[] listaPsg;
		listaPsg = new Passageiro[1000];

		// Boeing 747
		aviao.setAutonomiaVoo(13450.0);
		aviao.setAltura(19.33);
		aviao.setEnverAsa(68.4);
		aviao.setComprimento(76.3);
		aviao.setCapacCarga(447700.0);
		aviao.setListaPsg(null);
		aviao.setQntdePsg(660);

		System.out.print("Avião\n"+
						"Autonomia: "+aviao.getAutonomiaVoo()+"\n"+
						"Altura: "+aviao.getAltura()+"\n"+
						"Envergadura da asa: "+aviao.getEnverAsa()+"\n"+
						"Comprimento: "+aviao.getComprimento()+"\n"+
						"Capacidade carga: "+aviao.getCapacCarga()+"\n"+
						"ListaPsg: "+aviao.getListaPsg()+"\n"+
						"Quantidade Psg: "+aviao.getQntdePsg()+"\n");
	}
}
