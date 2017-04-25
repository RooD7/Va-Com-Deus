package mainPackage;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class Main {

	// Quando o usuario cadastrar Voo e digitar o nome da companhia, criar companhia com aquele nome
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
		int opcao5 = -1; //MUDAR
		boolean inputFile;
		
		
		Aeroporto vaComDeus = new Aeroporto();
		vaComDeus.cadastrarCompanhia("Do Chao Nao Passa!");
		//nameComp = vaComDeus.getListCompanhia()[0].getNome();
		
		Aviao aviao = null;
		Voo voo = null;
		Passageiro passageiro = null;

		while (opcao != 0){
			//System.out.println("OPCAO5: "+opcao5);
			opcao = jopt.showJOptionMenu();
			//System.out.println("OPCAO: "+opcao);
			
			//System.out.println("Cadastrou aviao tamList Aviao: "+vaComDeus.getUltimaCompanhia().getTamListAviao());

			switch (opcao) {
				//Exibir todos os voos
				case 1: {
					jopt.showJOptionTodosVoos();
					break;
				}
				// Exibir informacoes dos voos do usuario
				case 2: {
					String cpf = jopt.inputJOptionCPF();
					jopt.showJOptionPassageiroIfoVoo(vaComDeus.getListCompanhia(),cpf);
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
				// Cadastrar/Importar novas informacoes
				case 5: {
					while (opcao5 != 0) {
						opcao5 = jopt.showJOptionSubMenu5(); // 1 - tela ou 2 - arquivo
						if(opcao5 == 2) { //arquivo
							opcao5 = jopt.showJOptionSubMenu5Tipo(); // tipo (aviao(1), voo(2), pass(3))
							nameInputFile = jopt.showJOptionSubMenu5Str(); // recebe nome do arquivo
							
							switch (opcao5) {
								case 1:	//aviao
									aviao = new Aviao();
									nameInputFile = "entrada-aviao.json";	//apagar
									aviao = json.getJsonAviao(nameInputFile, aviao);
									//nameComp = vaComDeus.getUltimaCompanhia().getNome();
									vaComDeus.getUltimaCompanhia().cadastrarAviao(aviao);
									
									
									//System.out.println("Nome Companhia: "+vaComDeus.getUltimaCompanhia().getNome());
									//jopt.showJOptionAviao(aviao);	//apagar
									break;
								case 2:	//voo
									voo = new Voo();
									nameInputFile = "entrada-voo1.json"; //apagar
									voo = json.getJsonVoo(nameInputFile, voo, aviao);
									//System.out.println("Companhia: "+voo.getCompAerea()+"\n\n");
									vaComDeus.getCompanhia(voo.getCompAerea()); // se a comp no existe, ele cria
									vaComDeus.getUltimaCompanhia().cadastrarVoo(voo, aviao);
									
									//jopt.showJOptionVoo(voo); //apagar
									break;
								case 3:	//passageiro
									passageiro = new Passageiro();
									nameInputFile = "entrada-passageiro.json";	//apagar
									passageiro = json.getJsonPassageiro(nameInputFile, passageiro);
									if (vaComDeus.getUltimaCompanhia().getUltimoVoo() == null) {
										jopt.erro();
									}else{
										vaComDeus.getUltimaCompanhia().getUltimoVoo().cadastrarPassageiro(passageiro);
										
										jopt.showJOptionPassageiro(passageiro);	//apagar
									}
									
									break;
							}
							opcao5 = -1;
						}else if (opcao5 == 1) {
							jopt.showJOptionSubMenuCadastroViaTela(); // criar menu pra cadastro via tela
						}else if (opcao5 == 0){
							break;
						}else jopt.erro();
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
						int num = jopt.inputJOptionInteger("Digite o numero do voo [0-100]\n");
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
					jopt.showJOptionSair();
					break;
				}
				default: jopt.erro("[0-9]");
			}
			opcao = -1;
		}

	}
}
