//package mainPackage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Json {

	JSONObject jsonObject;
	//Cria o parse de tratamento
	JSONParser parser = new JSONParser();
	//Variaveis que irao armazenar os dados do arquivo JSON

	public Aviao getJsonAviao(String entrada, Aviao aviao) {

		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					entrada));

			//Salva nas variaveis os dados retirados do arquivo
			aviao.setModelo((String) jsonObject.get("Modelo"));
			aviao.setAutonomiaVoo(Double.parseDouble((String) jsonObject.get("Autonomia")));
			aviao.setAltura(Double.parseDouble((String) jsonObject.get("Altura")));
			aviao.setEnverAsa(Double.parseDouble((String) jsonObject.get("Envergadura da asa")));
			aviao.setComprimento(Double.parseDouble((String) jsonObject.get("Comprimento")));
			aviao.setCapacCarga(Double.parseDouble((String) jsonObject.get("Capacidade carga")));
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
		return aviao;
	}

	public Voo getJsonVoo(String entrada, Voo voo, Aviao aviao) throws Exception {
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					entrada));

			//Salva nas variaveis os dados retirados do arquivo

			voo.setInfoVoo((String) jsonObject.get("InfoVoo"));
			voo.setNumVoo(Integer.parseInt((String) jsonObject.get("NumVoo")));
			voo.setCompAerea((String) jsonObject.get("CompAerea"));
			//voo.setListaPsg((Passageiro[]) jsonObject.get("Lista Psg"));
			voo.setQntdePsg(Integer.parseInt((String) jsonObject.get("Quantidade Psg")));
			voo.setAviao(aviao);

			Date data = new Date();
			voo.setDataVoo(data);	//Data atual do sistema

			Date horarioVoo = new Date();
			horarioVoo = formHora.parse((String) jsonObject.get("HorarioVoo"));
			
			voo.setHorarioVoo(horarioVoo);

			voo.setStatusVoo((String) jsonObject.get("StatusVoo"));
			voo.setDestino((String) jsonObject.get("Destino"));
			voo.setOrigem((String) jsonObject.get("Origem"));
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
		return voo;
	}

	public Passageiro getJsonPassageiro(String entrada, Passageiro passageiro) throws Exception {
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					entrada));

			//Salva nas variaveis os dados retirados do arquivo

			//System.out.println("DATA Nascimento:" + jsonObject.get("DataNasc"));
			passageiro.setNome((String) jsonObject.get("Nome"));
			passageiro.setTelef((String) jsonObject.get("Telef"));
			passageiro.setEmail((String) jsonObject.get("Email"));
			passageiro.setCpf((String) jsonObject.get("Cpf"));
			Date dataNasc = new Date();
			dataNasc = formData.parse((String) jsonObject.get("DataNasc"));
			passageiro.setDataNasc(dataNasc);
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
		return passageiro;
	}
}