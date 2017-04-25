package mainPackage;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

 public class Aeroporto {

 	private ArrayList<Companhia> listComp;
 	private int tamListComp;

 	public Aeroporto() {
 		this.listComp = new ArrayList<Companhia>();
 	}

    public ArrayList<Companhia> getListCompanhia() {
    	return this.listComp;
    }
    
    public Companhia getCompanhia(String nome) {
    	//System.out.println("aki");
    	for (Companhia c : this.listComp) {
			if(c.getNome().equals(nome)) {
				return c;
			}
		}
    	
    	//System.out.println("aki3");
    	cadastrarCompanhia(nome);
    	return getUltimaCompanhia();
    }
    
    // Retorna Ultimo Aviao Cadastrado
 	public Companhia getUltimaCompanhia() {
 		if (!(this.listComp.isEmpty())){
 			return this.listComp.get(listComp.size()-1);
 		}else return null;
 		//System.out.print("tams: "+this.tamListComp+"\n");
 		//System.out.println("Ult: "+this.listComp[this.tamListComp-1].getNome()+"\n");
 		
 	}

    public int getTamListComp() {
    	return this.tamListComp;
    }

 	// Cadastra Companhia Aerea
	public void cadastrarCompanhia(String nome) {
		Companhia c = new Companhia(nome);
		this.listComp.add(c);
	}

	//Voo's Mes cada Companhia realizou
	public int voosMesCompanhia(Companhia comp, int numMes) {
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
		ArrayList<Voo> lista = comp.getListVoo();
		for (Voo voo : lista) {
			dataVoo = voo.getDataVoo();
			//voo's que pertence aquele mes(dataAtual- 1 mes)
			if(dataVoo.after(dataInicial) && dataVoo.before(dataFinal)) {
				if((voo.getInfoVoo() == "INCLUIDO") && (voo.getStatusVoo() == "CONFIRMADO")) {
					qntdeVooMes++;
				}
			}
		}
		return qntdeVooMes;
	}

	//Lucro por Voo's
	public double lucroVoo(Voo voo) {
		if((voo.getInfoVoo() == "INCLUIDO") && (voo.getStatusVoo() == "CONFIRMADO")) {

			if(voo.getAviao().getCapacCarga() > 30) {
				// 10 mil por decolagem + R$1000,00 a cada tonelada excedente a 30 toneladas.
				return (Double)(10000 + (1000*(voo.getAviao().getCapacCarga() - 30)));
			}
			return (10000.0);
		}
		return 0.0;
	}

	//Tratar limite de 4 decolagens a cada 30 min
	/*
	public boolean limiteVoo30Min() {
		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formHora = new SimpleDateFormat("HH:mm");

		Companhia[] comps = getCompanhia();
		Date dataAtual = new Date();
		int tamComps = getTamListComp();
		int passouDoLimite = 0;

		for (int i=0; i < tamComps; i++) {
			for (int j=0; j < comps[i].getTamListVoo(); j++) {
				//Data do atual do sistema == data do voo
				if ((formData.format(dataAtual)) == (comps[i].listVoo[j].getDataVoo())) {
					//Horario do voo 
				}
				comps[i].listVoo[j].getDataVoo()
				comps[i].listVoo[j].getHorarioVoo()
				formData.format(dataAtual);
				formHora.format(dataAtual);

			}
		}
		return passouDoLimite;
	}
	
	//Listar os passageiros do voo pelo numero do voo
	public String listPsgPorNumVoo(int numVoo) {
		String dadosPsgs = "";

		Companhia[] comps = getCompanhia();

		for (int i=0; i < getTamListComp(); i++) {
			for (int j=0; j < comps[i].getTamListVoo(); j++) {
				if(comps[i].listVoo[j].getNumVoo() == numVoo) {
					for (int k=0; k < comps[i].listVoo[j].getQntdePsg(); k++) {
						dadosPsgs += "\n\n" + listaPsg[k].imprime();
					}
					break;
				}
			}
		}
		return dadosPsgs;
	}
	*/
 }