//package mainPackage;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws Exception {

		Aviao aviao = new Aviao();
		Voo voo = new Voo(aviao);
		Passageiro passageiro = new Passageiro();
		String entrada;
		int opcao = -1;

		Passageiro[] listaPsg;
		listaPsg = new Passageiro[1000];
		
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");

		Json json = new Json();
		JOption jopt = new JOption();

		// Aviao
		entrada = "entrada-aviao.json";
		aviao = json.getJsonAviao(entrada, aviao);
		jopt.showJOptionAviao(aviao);

		// Voo 01
		entrada = "entrada-voo.json";
		voo = json.getJsonVoo(entrada, voo, aviao);
		jopt.showJOptionVoo(voo);

		// Passageiro
		entrada = "entrada-passageiro.json";
		passageiro = json.getJsonPassageiro(entrada, passageiro);
		jopt.showJOptionPassageiro(passageiro);

		while (opcao != 0){

			opcao = jopt.showJOptionMenu();

			switch (opcao) {
				case 1: break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 9: break;
				case 0: break;
				default: jopt.erro("[0-9]");
			}
		}

	}
}
