package mainPackage;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class Main {

	// Quando o usuário cadastrar Voo e digitar o nome da companhia, criar companhia com aquele nome
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		Json json = new Json();
		JOption jopt = new JOption();

		int numComp = 0;
		int numAviao = 0;
		int numVoo = 0;
		String nameInputFile;
		String nameComp;
		int opcao = -1;
		int opcao5 = 2; //MUDAR
		boolean inputFile;
		
		
		Aeroporto vaComDeus = new Aeroporto();
		vaComDeus.cadastrarCompanhia("Do Chão Não Passa!");
		
		Aviao aviao;
		Voo voo;
		Passageiro passageiro;

		while (opcao != 0){
			System.out.println("OPCAO5: "+opcao5);
			opcao = jopt.showJOptionMenu();
			System.out.println("OPCAO: "+opcao);

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
					opcao5 = jopt.showJOptionSubMenu5(); // tela ou arquivo
					if(opcao5 == 2) { //arquivo
						opcao5 = jopt.showJOptionSubMenu5Tipo(); // tipo (aviao(1), voo(2), pass(3))
						nameInputFile = jopt.showJOptionSubMenu5Str();
						switch (opcao5) {
							case 1:	//aviao
								aviao = new Aviao();
								nameInputFile = "entrada-aviao.json";	//apagar
								aviao = json.getJsonAviao(nameInputFile, aviao);
								vaComDeus.getUltimaCompanhia().cadastrarAviao(aviao);
								jopt.showJOptionAviao(aviao);	//apagar
								break;
							case 2:	//voo
								voo = new Voo();
								nameInputFile = "entrada-voo.json"; //apagar
								voo = json.getJsonVoo(nameInputFile, voo, null);
								System.out.println("Companhia: "+voo.getCompAerea()+"\n\n");
								vaComDeus.getCompanhia(voo.getCompAerea()); // se a comp no existe, ele cria
								vaComDeus.getUltimaCompanhia().cadastrarVoo(voo, null);
								
								
								vaComDeus.getCompanhia(voo.getCompAerea()).cadastrarVoo(voo, vaComDeus.getCompanhia(voo.getCompAerea()).getUltimoAviao());
								jopt.showJOptionVoo(voo); //apagar
								break;
							case 3:	//passageiro
								passageiro = new Passageiro();
								nameInputFile = "entrada-passageiro.json";	//apagar
								passageiro = json.getJsonPassageiro(nameInputFile, passageiro);
								vaComDeus.getUltimaCompanhia().getUltimoVoo().cadastrarPassageiro(passageiro);
								jopt.showJOptionPassageiro(passageiro);	//apagar
								break;
						}
						opcao5 = -1;
					}
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
					String str = "";
					do {
						//Recebe o numero do voo
						int num = jopt.inputJOptionInteger("Digite o número do voo [0-100]\n");
						//Busca a lista de passageiros pelo num
						//str = vaComDeus.listPsgPorNumVoo(num);
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
			opcao = -1;
		}

	}
}
