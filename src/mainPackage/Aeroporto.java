 public class Aeroporto {

 	private Companhia[] listComp = new Companhia[1000];
 	private int tamListComp;

    //comitar essa bosta
 	// Cadastra Companhia Aerea
	public void cadastrarCompanhia(String nome, Voo[] listVoo, int tamListVoo) {
		
		// Adiciona o novo voo a lista de voo's
		// Encontra uma posicao vazia na Lista de Voo's
		for (int i = 0; i < this.listComp.length; i++) {
			if (this.listComp[i] == null) {

				// Cria uma nova Companhia
				this.listComp[i] = new Companhia();
				//Adiciona os dados da Companhia na lista
				this.listComp[i].setNome(nome);
				this.listComp[i].setListVoo(listVoo);
				this.listComp[i].setQntdeVoo(tamListVoo);

				//Atualiza o tamanho da lista
				this.tamListComp = i;
				break;
			}
		}
	}

	//Voo's Mes cada Companhia realizou

	//Lucro por Voo's

	//Tratar limite de 4 decolagens a cada 30 min

	//Listar os passageiros do voo pelo numero do voo
 }