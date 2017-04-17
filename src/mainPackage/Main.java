package mainPackage;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws Exception {

		Aviao aviao = new Aviao();
		Voo voo = new Voo(aviao);
		Passageiro passageiro = new Passageiro();
		
		Passageiro[] listaPsg;
		listaPsg = new Passageiro[1000];
		
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");

		Json json = new Json();
		JOption jopt = new JOption();

		// Aviao
		aviao = json.getJsonAviao(aviao);
        jopt.showJOptionAviao(aviao);

		// Voo 01
		voo = json.getJsonVoo(voo, aviao);
		jopt.showJOptionVoo(voo);

		// Passageiro
		passageiro = json.getJsonPassageiro(passageiro);
		jopt.showJOptionPassageiro(passageiro);
	}
}
