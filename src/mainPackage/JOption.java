package mainPackage;

import javax.swing.*;

public class JOption {

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
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Exibir todos os voos\n" +
				"2 - Exibir informações dos voos do usuario\n" + // exibir info voo do usuario
				"3 - Alterar dados\n" + // usuario, voo ou aviao
				"4 - Excluir dados\n" + // usuario, voo ou aviao
				"5 - Cadastrar/Importar novas informações\n" + // usuario, voo ou aviao
				"6 - Cadastrar/Exportar voos\n" + // em arquivos json
				"7 - Exibir total de voos por companhia\n" +
				"8 - Exibir lucro\n" +
				"9 - Listar passageiros do voo\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
		
	}

	public int showJOptionSubMenu5Tipo() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Cadastrar Avião\n" +
				"2 - Cadastrar Voo\n" +
				"3 - Cadastrar Passageiro\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
	}
	
	public int showJOptionSubMenu5() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Cadastro via Tela\n" +
				"2 - Cadastro via arquivo JSON\n", JOptionPane.QUESTION_MESSAGE));
	}
	
	public String showJOptionSubMenu5Str() {
		return JOptionPane.showInputDialog(null,"Digite o nome do arquivo:", JOptionPane.QUESTION_MESSAGE);
	}
	
	public int inputJOptionInteger(String str) {
			return Integer.parseInt(JOptionPane.showInputDialog(null,str, JOptionPane.QUESTION_MESSAGE));
	}

	public void erro() {
			JOptionPane.showMessageDialog(null,"Valor inserido inválido.\n","Valor Inválido",JOptionPane.ERROR_MESSAGE);
	}
	public void erro(String valor) {
		JOptionPane.showMessageDialog(null,"Valor inserido inválido.\nValor esperado: "+valor,"Valor Inválido",JOptionPane.ERROR_MESSAGE);
	}
}