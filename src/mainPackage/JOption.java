//package mainPackage;

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
		int opcao = 0;
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Exibir todos os voos\n" +
				"2 - Exibir informações dos voos do usuario\n" + // exibir info voo do usuario
				"3 - Alterar dados\n" + // usuario, voo ou aviao
				"4 - Excluir dados\n" + // usuario, voo ou aviao
				"5 - Cadastrar/Importar novas informações\n" + // usuario, voo ou aviao
				"6 - Cadastrar/Exportar voos\n" + // em arquivos json
				"7 - Exibir total de voos por companhia\n" +
				"8 - Exibir lucro\n" +
				"9 - Listar passageiros do voo\n" +
				"0 - Sair","Menu", JOptionPane.QUESTION_MESSAGE));
		return opcao;
	}

	public int inputJOptionInteger(String str) {
			return Integer.parseInt(JOptionPane.showInputDialog(null,str, JOptionPane.QUESTION_MESSAGE);
	}

	public void erro(String valor) {
		if(valor.equals(""))
			JOptionPane.showMessageDialog(null,"Valor inserido inválido.\n","Valor Inválido",JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Valor inserido invalido.\nValor esperado: "+valor,"Valor Invalido",JOptionPane.ERROR_MESSAGE);
	}
}