package mainPackage;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class JOption {

	public void showJOptionAviao(Aviao aviao) {
		JOptionPane.showMessageDialog(null,"Avião\n"+
                "Modelo: "+aviao.getModelo()+"\n"+
                "Autonomia: "+aviao.getAutonomiaVoo()+"\n"+
                "Altura: "+aviao.getAltura()+"\n"+
                "Envergadura da asa: "+aviao.getEnverAsa()+"\n"+
                "Comprimento: "+aviao.getComprimento()+"\n"+
                "Capacidade carga: "+aviao.getCapacCarga()+"\n");
	}

	public void showJOptionVoo(Voo voo) {
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		JOptionPane.showMessageDialog(null,"Voo\n"+
				"Info Voo: "+voo.getInfoVoo()+"\n"+
				"Numero Voo: "+voo.getNumVoo()+"\n"+
				"Companhia Aerea: "+voo.getCompAerea()+"\n"+
				"Aviao: "+voo.getAviao().getModelo()+"\n"+
				"Data: "+formData.format(voo.getData())+"\n"+
				"Horario Voo: "+ formHora.format(voo.getHorarioVoo())+"\n"+
				"Status Voo: "+voo.getStatusVoo()+"\n"+
				"Destino: "+voo.getDestino()+"\n"+
				"Origem: "+voo.getOrigem()+"\n"+
                "ListaPsg: "+voo.getListaPsg()+"\n"+
                "Quantidade Psg: "+voo.getQntdePsg()+"\n");
	}

	public void showJOptionPassageiro(Passageiro passageiro) {
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		JOptionPane.showMessageDialog(null,"Passageiro\n"+
						"Nome: "+passageiro.getNome()+"\n"+
						"Telefone: "+passageiro.getTelef()+"\n"+
						"E-mail: "+passageiro.getEmail()+"\n"+
						"CPF: "+passageiro.getCpf()+"\n"+
						"Data Nascimento: "+formData.format(passageiro.getDataNasc())+"\n");
	}
}