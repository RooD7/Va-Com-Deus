//package mainPackage;
//merge funcionou

import javax.swing.*;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws Exception {

		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");

		Aeroporto vaComDeus = new Aeroporto();
		
		Aviao aviao = new Aviao();
		Voo voo = new Voo(aviao);
		Passageiro passageiro = new Passageiro();
		String entrada;
		int opcao = -1;

		Passageiro[] listaPsg;
		listaPsg = new Passageiro[1000];

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
				//Exibir todos os voos
				case 1: {
					break;
				}
				// Exibir informações dos voos do usuario
				case 2: {
					break;
				}
				// Alterar dados
				case 3: {
					break;
				}
				// Excluir dados
				case 4: {
					break;
				}
				// Cadastrar/Importar novas informações
				case 5: {
					// CRIAR E ADICIONAR AQUI O SUB MENU
					// vaComDeus.listComp[].cadastrarAviao(Double autonomiaVoo, Double altura, Double enverAsa, Double comprimento, Double capacCarga);
					// vaComDeus.listComp[].cadastrarVoo(String infoVoo, int numVoo, String compAerea, Aviao aviao, Date dataVoo, Date horarioVoo, String statusVoo, String destino, String origem, Passageiro[] listaPsg, int qntdePsg); 
					break;
				}
				// Cadastrar/Exportar voos
				case 6: {
					// vaComDeus.exportarVoo()
					break;
				}
				// Exibir total de voos por companhia
				case 7: {
					// (int) vaComDeus.voosMesCompanhia(Companhia comp, int numMes)
					break;
				}
				// Exibir lucro
				case 8: {
					// (double) lucroVoo(Voo voo)
					break;
				}
				//Listar passageiros do voo
				case 9: {
					do {
						//Recebe o numero do voo
						int num = jopt.inputJOptionInteger("Digite o número do voo [0-100]\n");
						//Busca a lista de passageiros pelo num
						String str = vaComDeus.listPsgPorNumVoo(num);
						//Nao encontrou o voo
						if (str.equals("")) {
							jopt.erro("");
						}
					} while(str.equals(""));
					break;
				}
				case 0: {
					break;
				}
				default: jopt.erro("[0-9]");
			}
		}

	}
}
