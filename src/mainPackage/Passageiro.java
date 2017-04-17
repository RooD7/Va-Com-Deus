//package mainPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Passageiro {

	private String nome;
	private String telef;
	private String email;
	private String cpf;
	private Date dataNasc;

	public Passageiro() {
		nome = "";
		telef = "";
		email = "";
		cpf = "";
		dataNasc = null;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelef() {
		return telef;
	}
	public void setTelef(String telef) {
		this.telef = telef;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		//TODO realizar validacao
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		//TODO realizar validacao
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String imprime() {

		SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
		return "Passageiro\n"+
				"Nome: "+getNome()+"\n"+
				"Telefone: "+getTelef()+"\n"+
				"E-mail: "+getEmail()+"\n"+
				"CPF: "+getCpf()+"\n"+
				"Data Nascimento: "+formData.format(getDataNasc())+"\n";
	}

}