package mainPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

public class JOption {

	public void showJOptionResultado(String titulo, String result) {
		JOptionPane.showMessageDialog(null, result, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void showJOptionAviao(Aviao aviao) {
		JOptionPane.showMessageDialog(null, aviao.imprime(), "Aviao", JOptionPane.PLAIN_MESSAGE);
	}

	public void showJOptionVoo(Voo voo) {
		JOptionPane.showMessageDialog(null,voo.imprime(), "Voo", JOptionPane.PLAIN_MESSAGE);
	}

	public void showJOptionPassageiro(Passageiro passageiro) {
		JOptionPane.showMessageDialog(null,passageiro.imprime(), "Passageiro", JOptionPane.PLAIN_MESSAGE);
	}

	public int showJOptionMenu() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Exibir voos do dia: \n" +
				"2 - Exibir informacoes dos voos do usuario\n" + // exibir info voo do usuario #PARCIALMENTE OK - SO FAZER MAIS TESTES
				"3 - Alterar dados\n" + // usuario, voo ou aviao ##PROXIMA ETAPA
				"4 - Excluir dados\n" + // usuario, voo ou aviao
				"5 - Cadastrar/Importar novas informacoes\n" + // usuario, voo ou aviao #PARCIALMENTE OK - SO FAZER MAIS TESTES
				"6 - Cadastrar/Exportar voos\n" + // em arquivos json
				"7 - Exibir total de voos por companhia\n" +
				"8 - Exibir lucro\n" +
				"9 - Listar passageiros do voo\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
		
	}

	public int showJOptionSubMenu4() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Excluir Aviao\n" +
				"2 - Excluir Voo\n" +
				"3 - Excluir Passageiro\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
	}
	
	public int showJOptionSubMenu5Tipo() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Cadastrar Aviao\n" +
				"2 - Cadastrar Voo\n" +
				"3 - Cadastrar Passageiro\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
	}
	
	public int showJOptionSubMenu5() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Cadastro via Tela\n" +
				"2 - Cadastro via arquivo JSON\n"+"0 - Voltar\n", JOptionPane.QUESTION_MESSAGE));
	}
	
	public String showJOptionSubMenu5Str() {
		return JOptionPane.showInputDialog(null,"Digite o nome do arquivo:", JOptionPane.QUESTION_MESSAGE);
	}
	
	public int inputJOptionInteger(String str) {
			return Integer.parseInt(JOptionPane.showInputDialog(null,str, JOptionPane.QUESTION_MESSAGE));
	}

	public void erro() {
			JOptionPane.showMessageDialog(null,"Valor inserido invalido.\n","Valor Invalido",JOptionPane.ERROR_MESSAGE);
	}
	public void erro(String valor) {
		JOptionPane.showMessageDialog(null,"Valor inserido invalido.\nValor esperado: "+valor,"Valor Invalido",JOptionPane.ERROR_MESSAGE);
	}

	public int showJOptionSubMenuCadastroViaTela() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Cadastrar Aviao\n" +
				"2 - Cadastrar Voo\n" +
				"3 - Cadastrar Passageiro\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
	}

	public void showJOptionSair() throws IllegalStateException {
		// display the showOptionDialog
		Object[] options = { "OK", "Cancelar" };
		int choice = JOptionPane.showOptionDialog(null, 
		    "Voce realmente quer sair?", 
		    "Sair?", 
		    JOptionPane.YES_NO_OPTION, 
		    JOptionPane.QUESTION_MESSAGE, 
		    null, 
		    options, 
		    options[0]);

		// interpret the user's choice
		if (choice == JOptionPane.YES_OPTION)
		{
		  System.exit(0);
		}
	}

	public void showJOptionPassageiroIfoVoo(ArrayList<Companhia> listComp, String cpf) {
		/*
		 * exibir nome passageiro
		 * exibir num voo do passageiro
		 * exibir data e hr do voo do passageiro
		 * */
		// TODO Auto-generated method stub
		
		ArrayList<Voo> listVoo;
		ArrayList<Passageiro> listPsg;

		Passageiro passageiro = null;
		Voo voo = null;
		
		for (Companhia c : listComp) {
			listVoo = c.getListVoo();
			listVoo.toString();
			for (Voo v : listVoo) {
				listPsg = v.getListPsg();
				listPsg.toString();
				for (Passageiro p : listPsg) {
					if(p.getCpf().equals(cpf)) {
						passageiro = p;
						voo = v;
						exibeTelaCelular(p, c.getUltimoVoo());
						break;
					}
				}
			}
		}
		if (passageiro == null) {
			JOptionPane.showMessageDialog(null,"Passageiro nao encontrado.\n","Valor Invalido",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void exibeTelaCelular(Passageiro passageiro, Voo voo) {
		
		
		/*
		 * Busca voo passageiro
		 * */

		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		if(!voo.equals(null)){
			JOptionPane.showMessageDialog(null, "Nome Passageiro: "+ passageiro.getNome()+"\n"+
					"Numero Voo: "+voo.getNumVoo()+"\n"+
					"Companhia Aerea: "+voo.getCompAerea()+"\n"+
					"Data: "+formData.format(voo.getDataVoo())+"\n"+
					"Horario Voo: "+ formHora.format(voo.getHorarioVoo())+"\n"+
					"Status Voo: "+voo.getStatusVoo()+"\n"+
					"Destino: "+voo.getDestino()+"\n"+
					"Origem: "+voo.getOrigem()+"\n");
		}else{
			System.out.println("voo nulo"); // exibir mensagem de erro;
		}
		
	}

	public String inputJOptionCPF() {
		String str = JOptionPane.showInputDialog("Digite o CPF do passageiro desejado: ");
		return str;
	}

	public void showJOptionTodosVoos() {
		// TODO Auto-generated method stub
		
	}
}