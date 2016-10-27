package model;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno {

	private String nome, dataNascimento, sexo, endereco, complemento, rg, cpf,
			email, telefone;
	private int codigo, numero;

	public Aluno() {
		codigo = 0;
		nome = "";
		dataNascimento = "";
		sexo = "";
		endereco = "";
		numero = 0;
		complemento = "";
		rg = "";
		cpf = "";
		email = "";
		telefone = "";
	}

	public Aluno(int codigo, String nome, String sexo,
			String dataNascimento, String nvEndereco, int numero,
			String complemento, String rg, String cpf, String telefone,
			String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.endereco = nvEndereco;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
	}

	//Métodos de acesso
	public int getCodigo() {

		return codigo;
	}

	public String getNome() {

		return nome;
	}

	public String getSexo() {

		return sexo;
	}

	public String getDataNascimento() {

		return dataNascimento;
	}

	public String getEndereco() {

		return endereco;
	}

	public int getNumero() {

		return numero;
	}

	public String getComplemento() {

		return complemento;
	}

	public String getRG() {

		return rg;
	}

	public String getCPF() {

		return cpf;
	}

	public String getEmail() {

		return email;
	}

	public String getTelefone() {

		return telefone;
	}

	//Métodos modificadores
	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}
	
	public void setNome(String nome) {

		this.nome = nome;
	}

	public void setSexo(String sexo) {

		this.sexo = sexo;
	}

	public void setDataNascimento(String nvData) {

		this.dataNascimento = nvData;
	}

	public void setCPF(String cpf) {

		this.cpf = cpf;
	}

	public void setRG(String rg) {

		this.rg = rg;
	}

	public void setEndereco(String nvEndereco) {

		this.endereco = nvEndereco;
	}

	public void setNumero(int numero) {

		this.numero = numero;
	}

	public void setComplemento(String complemento) {

		this.complemento = complemento;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;
	}
	
	public void criar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setSexo(sexo);
		to.setDataNascimento(dataNascimento);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setNumero(numero);
		to.setComplemento(complemento);
		to.setRG(rg);
		to.setCPF(cpf);
		to.setEmail(email);
		
		dao.incluir(to);
	}

	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setSexo(sexo);
		to.setDataNascimento(dataNascimento);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setNumero(numero);
		to.setComplemento(complemento);
		to.setRG(rg);
		to.setCPF(cpf);
		to.setEmail(email);
		
		dao.atualizar(to);
	}

	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		
		to.setCodigo(codigo);
		
		dao.excluir(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar(codigo);
		
		codigo = to.getCodigo();
		nome = to.getNome();
		sexo = to.getSexo();
		dataNascimento = to.getDataNascimento();
		telefone = to.getTelefone();
		endereco = to.getEndereco();
		numero = to.getNumero();
		complemento = to.getComplemento();
		rg = to.getRG();
		cpf = to.getCPF();
		email = to.getEmail();
	}

	@Override
	public String toString() {
		return "Aluno [nome =" + nome + ", dataNascimento =" + dataNascimento + ", sexo =" + sexo + ", endereco ="
				+ endereco + ", complemento =" + complemento + ", rg =" + rg + ", cpf =" + cpf + ", email =" + email
				+ ", telefone =" + telefone + ", codigo =" + codigo + ", numero =" + numero + "]";
	}
}
