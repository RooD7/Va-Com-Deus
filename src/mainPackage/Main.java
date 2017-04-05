//package mainPackage;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws Exception {

		Companhia cmpAer = new Companhia("TAM");
		Aviao aviao = new Aviao();
		//Voo voo = new Voo(aviao);
		Passageiro passageiro = new Passageiro();
		
		Passageiro[] listaPsg;
		listaPsg = new Passageiro[1000];
		
		Date data = new Date();
		Date dataNasc = new Date();
		Date horarioVoo = new Date();
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");

		System.out.print("\n\n----------\t----------\t----------\n\n");
		// Boeing 747
		aviao.setModelo("Boeing 747");
		aviao.setAutonomiaVoo(13450.0);
		aviao.setAltura(19.33);
		aviao.setEnverAsa(68.4);
		aviao.setComprimento(76.3);
		aviao.setCapacCarga(447700.0);
		aviao.setListaPsg(null);
		aviao.setQntdePsg(660);

		System.out.print("Avião\n"+
						"Modelo: "+aviao.getModelo()+"\n"+
						"Autonomia: "+aviao.getAutonomiaVoo()+"\n"+
						"Altura: "+aviao.getAltura()+"\n"+
						"Envergadura da asa: "+aviao.getEnverAsa()+"\n"+
						"Comprimento: "+aviao.getComprimento()+"\n"+
						"Capacidade carga: "+aviao.getCapacCarga()+"\n"+
						"ListaPsg: "+aviao.getListaPsg()+"\n"+
						"Quantidade Psg: "+aviao.getQntdePsg()+"\n");

		System.out.print("\n\n----------\t----------\t----------\n\n");
		
		horarioVoo = formHora.parse("12:30");
		cmpAer.cadastrarVoo("incluido", 1, "TAM", aviao, data, horarioVoo, "Confirmado", "Dubai", "Belo Horizonte");
		cmpAer.exportarVoo();
		/*
		System.out.print("Voo\n"+
						"Info Voo: "+voo.getInfoVoo()+"\n"+
						"Numero Voo: "+voo.getNumVoo()+"\n"+
						"Companhia Aerea: "+voo.getCompAerea()+"\n"+
						"Aviao: "+voo.getAviao().getModelo()+"\n"+
						"Data: "+formData.format(voo.getData())+"\n"+
						"Horario Voo: "+ formHora.format(voo.getHorarioVoo())+"\n"+
						"Status Voo: "+voo.getStatusVoo()+"\n"+
						"Destino: "+voo.getDestino()+"\n"+
						"Origem: "+voo.getOrigem()+"\n");
		*/
		System.out.print("\n\n----------\t----------\t----------\n\n");
		//Passageiro
		passageiro.setNome("João Lucas");
		passageiro.setTelef("37 9 9921-3455");
		passageiro.setEmail("joaozin@gmail.com");
		passageiro.setCpf("12345678910");
		dataNasc = formData.parse("29/03/2017");
		passageiro.setDataNasc(dataNasc);

		System.out.print("Passageiro\n"+
						"Nome: "+passageiro.getNome()+"\n"+
						"Telefone: "+passageiro.getTelef()+"\n"+
						"E-mail: "+passageiro.getEmail()+"\n"+
						"CPF: "+passageiro.getCpf()+"\n"+
						"Data Nascimento: "+formData.format(passageiro.getDataNasc())+"\n");

		System.out.print("\n\n----------\t----------\t----------\n\n");

		//ArquivoJson js = new ArquivoJson();
		//js.json();	
	}
}
