//Vinicius
import java.util.Date;
import java.text.SimpleDateFormat;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/*
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/
public class Main {

	public static void main(String[] args) throws Exception {

		Aviao aviao = new Aviao();
		Voo voo = new Voo(aviao);
		Passageiro passageiro = new Passageiro();
		
		Passageiro[] listaPsg;
		listaPsg = new Passageiro[1000];
		
		Date data = new Date();
		Date dataNasc = new Date();
		Date horarioVoo = new Date();
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");

		/*
		JSONObject jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		//Variaveis que irao armazenar os dados do arquivo JSON
		// Boeing 747


		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"entrada-aviao.json"));

			//Salva nas variaveis os dados retirados do arquivo


			aviao.setModelo((String) jsonObject.get("Modelo"));
			aviao.setAutonomiaVoo(Double.parseDouble((String) jsonObject.get("Autonomia")));
			aviao.setAltura(Double.parseDouble((String) jsonObject.get("Altura")));
			aviao.setEnverAsa(Double.parseDouble((String) jsonObject.get("Envergadura da asa")));
			aviao.setComprimento(Double.parseDouble((String) jsonObject.get("Comprimento")));
			aviao.setCapacCarga(Double.parseDouble((String) jsonObject.get("Capacidade carga")));
			aviao.setListaPsg((Passageiro[]) jsonObject.get("Lista Psg"));
			aviao.setQntdePsg(Integer.parseInt((String) jsonObject.get("Quantidade Psg")));


			System.out.printf("Passou!");
		}
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null,"Avião\n"+
                "Modelo: "+aviao.getModelo()+"\n"+
                "Autonomia: "+aviao.getAutonomiaVoo()+"\n"+
                "Altura: "+aviao.getAltura()+"\n"+
                "Envergadura da asa: "+aviao.getEnverAsa()+"\n"+
                "Comprimento: "+aviao.getComprimento()+"\n"+
                "Capacidade carga: "+aviao.getCapacCarga()+"\n"+
                "ListaPsg: "+aviao.getListaPsg()+"\n"+
                "Quantidade Psg: "+aviao.getQntdePsg()+"\n");
	*/
		System.out.print("Avião\n"+
						"Modelo: "+aviao.getModelo()+"\n"+
						"Autonomia: "+aviao.getAutonomiaVoo()+"\n"+
						"Altura: "+aviao.getAltura()+"\n"+
						"Envergadura da asa: "+aviao.getEnverAsa()+"\n"+
						"Comprimento: "+aviao.getComprimento()+"\n"+
						"Capacidade carga: "+aviao.getCapacCarga()+"\n");

		System.out.print("\n\n----------\t----------\t----------\n\n");
		// Voo 01
		voo.setInfoVoo("incluido");
		voo.setNumVoo(01);
		voo.setCompAerea("TAM");
		voo.setAviao(aviao);
		voo.setData(data);
		
		horarioVoo = formHora.parse("12:30");
		voo.setHorarioVoo(horarioVoo);

		voo.setStatusVoo("Confirmado");
		voo.setDestino("Dubai");
		voo.setOrigem("Belo Horizonte");

		System.out.print("Voo\n"+
						"Info Voo: "+voo.getInfoVoo()+"\n"+
						"Numero Voo: "+voo.getNumVoo()+"\n"+
						"Companhia Aerea: "+voo.getCompAerea()+"\n"+
						"Aviao: "+voo.getAviao().getModelo()+"\n"+
						"Data: "+formData.format(voo.getData())+"\n"+
						"Horario Voo: "+ formHora.format(voo.getHorarioVoo())+"\n"+
						"Status Voo: "+voo.getStatusVoo()+"\n"+
						"Destino: "+voo.getDestino()+"\n"+
						"Origem: "+voo.getOrigem()+"\n"+
						"ListaPsg: "+voo.getListaPsg()+"\n"+
						"Quantidade Psg: "+voo.getQntdePsg()+"\n");

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
	}
}
