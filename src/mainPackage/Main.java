package mainPackage;

import javax.swing.*;
import java.util.*;
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

		// Captura Mes atual
		Date dataAtual = new Date();
		Date dataFinalMes = vaComDeus.ultimoDiaMes(dataAtual);
				
		while (opcao != 0){
			if(dataAtual.equals(dataFinalMes)) {
				// RESETA DADOS
				vaComDeus = new Aeroporto();
				jopt.showJOptionResultado("Banco de dados", "Banco de dados foi resetado!");
			}
			
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
									
									if(vaComDeus.passouLimiteVoo30Min()) {
										jopt.erro("Limite de voo's atingido num intervalo de 30 min.");
									}
									else
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
							opcao5 = jopt.showJOptionSubMenuCadastroViaTela(); // criar menu pra cadastro via tela
							
							switch (opcao5) {
								case 1:	{//aviao
									
									String modelo = JOptionPane.showInputDialog("Digite o modelo: ");									
									Double autonomiaVoo = Double.parseDouble(JOptionPane.showInputDialog("Digite a autonomia de voo: "));
									Double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura: "));
									Double enverAsa = Double.parseDouble(JOptionPane.showInputDialog("Digite a envergadura da asa: "));
									Double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento: "));
									Double capacCarga = Double.parseDouble(JOptionPane.showInputDialog("Digite a capacidade de carga: "));
									
									vaComDeus.getUltimaCompanhia().cadastrarAviao(modelo, autonomiaVoo, altura, enverAsa, comprimento, capacCarga);
									
									break;
								}
								case 2:	{//voo
									
									String infoVoo = JOptionPane.showInputDialog("Digite a informação do Voo: ");									
									int numVo = Integer.parseInt((JOptionPane.showInputDialog("Digite o número do Voo: ")));
									String compAer = JOptionPane.showInputDialog("Digite a companhia aerea: ");
									Date dataV = formData.parse(JOptionPane.showInputDialog("Digite a data: "));
									Date horaV = formHora.parse(JOptionPane.showInputDialog("Digite o horário: "));
									String statusVoo = JOptionPane.showInputDialog("Digite o status do Voo: ");
									String origem = JOptionPane.showInputDialog("Digite a origem: ");
									String destino = JOptionPane.showInputDialog("Digite o destino: ");
									
									if(vaComDeus.passouLimiteVoo30Min()) {
										jopt.erro("Limite de voo's atingido num intervalo de 30 min.");
									} 
									else
										vaComDeus.getUltimaCompanhia().cadastrarVoo(infoVoo, numVo, compAer, dataV, horaV, statusVoo, origem, destino);
									
									break;
								}
								case 3:	{	// Passageiro
									String nom = JOptionPane.showInputDialog("Digite o nome: ");
									String tel = JOptionPane.showInputDialog("Digite o telefone: ");
									String email = "";
									String cpf = "";
									boolean ok;
									do {
										email = JOptionPane.showInputDialog("Digite o e-mail: ");
										ok = vaComDeus.getUltimaCompanhia().validarEmail(email); 
										if (!ok) {
											jopt.erro("");
										}
									} while(!ok);
						
									do {
										cpf = JOptionPane.showInputDialog("Digite o cpf: ");
										ok = vaComDeus.getUltimaCompanhia().validarCpf(cpf); 
										if (!ok) {
											jopt.erro("");
										}
									} while(!ok);
									Date dataN = formData.parse(JOptionPane.showInputDialog("Digite a data de nascimento: "));
									
									vaComDeus.getUltimaCompanhia().getUltimoVoo().cadastrarPassageiro(nom, tel, email, cpf, dataN);
									break;	
								}
								case 0:	{ //sair
									break;
								}
								default: jopt.erro();
							}
							opcao5 = -1;
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
					String str = "";
					for (Companhia c : vaComDeus.getListCompanhia()) {
						str += "Companhia: "+c.getNome()+
								"\tNúmero de voo's: "+ vaComDeus.voosMesCompanhia(c)+"\n";
					}
					jopt.showJOptionResultado("Voo's por companhia no mês", str);
					break;
				}
				// Exibir lucro
				case 8: {
					// (double) lucroVoo(Voo voo)
					Double lucro = 0.0;
					for (Companhia c : vaComDeus.getListCompanhia()) {
						for (Voo v : c.getListVoo()) {
							lucro += vaComDeus.lucroVoo(v);
						}
					}
					jopt.showJOptionResultado("Lucro Aeroporto", "R$ "+lucro+"\n");
					break;
				}
				//Listar passageiros do voo
				case 9: {
					String str = "";
					do {
						//Recebe o numero do voo
						int num = jopt.inputJOptionInteger("Digite o numero do voo [0-100]\n");
						//Busca a lista de passageiros pelo num
						str = vaComDeus.listPsgPorNumVoo(num);
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
