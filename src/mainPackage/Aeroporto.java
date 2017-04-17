//package mainPackage;
import java.util.Date;
import java.util.Calendar;

 public class Aeroporto {

 	private Companhia[] listComp = new Companhia[100];
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
	public int VoosMesCompanhia(Companhia comp, int numMes) {
		Calendar c = Calendar.getInstance();
		Date dataAtual = new Date();
		Date dataInicial;
		Date dataFinal;
		Date dataVoo;
		int qntdeVooMes = 0;

		// calendar recebe data atual
		c.setTime(dataAtual);
		
		// dataInicial = 01/numMes/20**
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, numMes);
		dataInicial = c.getTime();

		// dataFinal = (29-30-31)/numMes/20**
		c.set(Calendar.MONTH, numMes+1);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
		dataFinal = c.getTime();

		System.out.print("Data Inicial: "+dataInicial.toString()+"\tData Final: "+dataFinal.toString()+"\n");
		
		//percorre a lista de voos
		Voo[] lista = comp.getListVoo();
		for (int i=0; lista[i] != null; i++) {
			dataVoo = lista[i].getDataVoo();
			//voo's que pertence aquele mes(dataAtual- 1 mes)
			if(dataVoo.after(dataInicial) && dataVoo.before(dataFinal)) {
				if((lista[i].getInfoVoo() == "INCLUIDO") && (lista[i].getStatusVoo() == "CONFIRMADO")) {
					qntdeVooMes++;
				}
			}
		}
		return qntdeVooMes;
	}

	//Lucro por Voo's
	public double LucroVoo() {
		return 0.0;
	}

	//Tratar limite de 4 decolagens a cada 30 min

	//Listar os passageiros do voo pelo numero do voo
 }