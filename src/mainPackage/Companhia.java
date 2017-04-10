import java.util.Date;
import java.text.SimpleDateFormat;

public class Companhia {
	private String nome;
	private Voo[] listVoo = new Voo[1000];
	private int tamListVoo = 0;

	public Companhia(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Voo[] getListVoo() {
		return listVoo;
	}
	public void setListVoo(Voo[] listVoo) {
		this.listVoo = listVoo;
	}

	// Retorna um Voo da lista
	public Voo getVoo(int numVoo) {
		if (numVoo < this.listVoo.length)
			return this.listVoo[numVoo];
		else
			//TODO Tela de Erro - Valor Invalido
			return null;
	}

	// Cadastra os voo da Companhia Aerea
	public void cadastrarVoo(String infoVoo, int numVoo, String compAerea, Aviao aviao, Date data, Date horarioVoo, String statusVoo, String destino, String origem) {

		// Cria um novo voo
		Voo voo = new Voo(aviao);

		voo.setInfoVoo(infoVoo);
		voo.setNumVoo(numVoo);
		voo.setCompAerea(compAerea);
		voo.setAviao(aviao);
		voo.setData(data);
		voo.setHorarioVoo(horarioVoo);
		voo.setStatusVoo(statusVoo);
		voo.setDestino(destino);
		voo.setOrigem(origem);
		
		// Adiciona o novo voo a lista de voo's
		// Encontra uma posicao vazia na Lista de Voo's
		for (int i = 0; i < this.listVoo.length; i++) {
			if (this.listVoo[i] == null) {
				//Adiciona o voo na lista
				this.listVoo[i] = voo;
				//Atualiza o tamanho da lista
				this.tamListVoo = i;
				break;
			}
		}
	}

	// Exporta os dados da Companhia Aerea para um arquivo Json
	public void exportarVoo() {
		
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");
		int i;

		System.out.print("Tam "+this.tamListVoo+"\n");
		for (i = 0; i <= this.tamListVoo; i++) {
			System.out.print("Companhia "+getNome()+" --- Voo "+i+"\n"+
						"Info Voo: "+listVoo[i].getInfoVoo()+"\n"+
						"Numero Voo: "+listVoo[i].getNumVoo()+"\n"+
						"Companhia Aerea: "+listVoo[i].getCompAerea()+"\n"+
						"Aviao: "+listVoo[i].getAviao().getModelo()+"\n"+
						"Data: "+formData.format(listVoo[i].getData())+"\n"+
						"Horario Voo: "+ formHora.format(listVoo[i].getHorarioVoo())+"\n"+
						"Status Voo: "+listVoo[i].getStatusVoo()+"\n"+
						"Destino: "+listVoo[i].getDestino()+"\n"+
						"Origem: "+listVoo[i].getOrigem()+"\n");	
		}
	}
}