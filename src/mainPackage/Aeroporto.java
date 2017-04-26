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

	public Date ultimoDiaMes(Date data) {
		// calendar recebe data atual
		Calendar c = Calendar.getInstance();
		c.setTime(data);

		// (29-30-31)/**/20**
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
		
		return c.getTime(); 
	}
	
	//Voo's Mes cada Companhia realizou
	public int voosMesCompanhia(Companhia comp) {
		Calendar c = Calendar.getInstance();
		Date dataAtual = new Date();
		Date dataInicial;
		Date dataFinal;
		Date dataVoo;
		int qntdeVooMes = 0;

		// calendar recebe data atual
		c.setTime(dataAtual);
		
		// dataInicial = 01/**/20**
		c.set(Calendar.DAY_OF_MONTH, 1);
		dataInicial = c.getTime();

		// dataFinal = (29-30-31)/**/20**
		dataFinal = ultimoDiaMes(dataAtual);

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
	
	public boolean passouLimiteVoo30Min() {

		Date horaAtual = new Date();
		Date hora30Depois =  new Date(horaAtual.getTime() + 30 * 60 * 1000);
		Date horaVoo;
		int passouDoLimite = 0;

		for (Companhia c : listComp) {
			for (Voo v : c.getListVoo()) {
				//Data do atual do sistema == data do voo
				horaVoo = v.getHorarioVoo();
				if ((horaVoo.before(horaAtual)) && (horaVoo.after(hora30Depois))) {
					passouDoLimite++; 
				}
			}
		}
		if(passouDoLimite > 3)
			return true;	
		return false;
	}
	
	//Listar os passageiros do voo pelo numero do voo
	public String listPsgPorNumVoo(int numVoo) {
		String dadosPsgs = "";

		for (Companhia c : listComp) {
			for (Voo v : c.getListVoo()) {
				if(v.getNumVoo() == numVoo) {
					for (Passageiro p : v.getListPsg()) {
						dadosPsgs += "\n\n" + p.imprime();
					}
					break;
				}
			}
		}
		return dadosPsgs;
	}
 }