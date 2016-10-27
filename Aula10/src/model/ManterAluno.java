/*
package model;

import dao.*;
import to.AlunoTO;

public class ManterAluno {

	String nome, nomeM, rg, endereco, foneF, fone, email, login ,senha;

	public ManterAluno(AlunoTO alunoTO){
		this.nome = alunoTO.getNome();
		this.nomeM = alunoTO.getNomeM();
		this.rg = alunoTO.getRg();
		this.endereco = alunoTO.getEndereco();
		this.foneF = alunoTO.getFone();
		this.fone = alunoTO.getFone();
		this.email = alunoTO.getEmail();
		this.login = alunoTO.getLogin();
		this.senha = alunoTO.getSenha();		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeM() {
		return nomeM;
	}

	public void setNomeM(String nomeM) {
		this.nomeM = nomeM;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFoneF() {
		return foneF;
	}

	public void setFoneF(String foneF) {
		this.foneF = foneF;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setFoneF(foneF);
		to.setFone(fone);
		to.setRg(rg);
		to.setNomeM(nomeM);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);
		return to;
	}
	
	// criar
	public void cadastrar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setFoneF(foneF);
		to.setFone(fone);
		to.setRg(rg);
		to.setNomeM(nomeM);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);

		dao.incluir(to);
	}
	
	public void alterar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setFoneF(foneF);
		to.setFone(fone);
		to.setRg(rg);
		to.setNomeM(nomeM);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);

		dao.atualizar(to);
	}

	public void deletar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setRg(rg);
		dao.excluir(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO armazenaRg = new AlunoTO();
		armazenaRg.setRg(rg);
		AlunoTO to = dao.carregar(armazenaRg);

		nome = to.getNome();
		endereco = to.getEndereco();
		foneF = to.getFoneF();
		fone = to.getFone();
		rg = to.getRg();
		nomeM = to.getNomeM();
		email = to.getEmail();
		login = to.getLogin();
		senha = to.getSenha();

	}

	
	public AlunoTO consultar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO armazenaCpf = new AlunoTO();
		armazenaCpf.setRg(rg);
		AlunoTO to = dao.consultarRg(armazenaRg);

		return to;
	}
	
	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.atualizar(to);
	}
	
	//public String consultarTodos(){
		//AlunoDAO dao = new AlunoDAO();
		//String resp = dao.consultarTodos();
		//return resp;  }

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManterAluno other = (ManterAluno) obj;
		if (nomeM == null) {
			if (other.nomeM != null)
				return false;
		} else if (!nomeM.equals(other.nomeM))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (foneF == null) {
			if (other.foneF != null)
				return false;
		} else if (!foneF.equals(other.foneF))
			return false;
		return true;
	}
}
*/
