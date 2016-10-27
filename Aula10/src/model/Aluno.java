package model;

import to.AlunoTO;

import dao.AlunoDAO;

public class Aluno {
	private int id;
	private String nome;
	private String nomeM;
	private String rg;
	private String endereco;
	private String foneF;
	private String fone;
	private String email;
	private String codProfessor;
	private String usuario;
	private String senha;
	private String permissao;
		

	public Aluno(int id, String nome,  String nomeM, String rg, String endereco,String foneF, String fone, String email, String codProfessor, String usuario, String senha, String permissao) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.nomeM = nomeM;
		this.rg = rg;
		this.endereco = endereco;
		this.foneF = foneF;
		this.fone = fone;
		this.email = email;
		this.codProfessor = codProfessor;
		this.usuario = usuario;
		this.senha = senha;
		this.permissao = permissao;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCodProfessor() {
		return codProfessor;
	}
	
	public void setCodProfessor(String codProfessor) {
		this.codProfessor = codProfessor;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	

	public void criar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.incluir(to);
		this.id = to.getId();
	}

	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setId(id);
		to.setNome(nome);
		to.setNomeM(nomeM);
		to.setRg(rg);
		to.setEndereco(endereco);
		to.setFoneF(foneF);
		to.setFone(fone);		
		to.setEmail(email);
		to.setCodProfessor(codProfessor);
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setPermissao(permissao);
		return to;
	}

	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar(id);
		nome = to.getNome();
		nomeM = to.getNomeM();
		rg = to.getRg();
		endereco = to.getEndereco();
		foneF = to.getFoneF();
		fone = to.getFone();
		email = to.getEmail();
		codProfessor = to.getCodProfessor();
		usuario = to.getUsuario();
		senha = to.getSenha();
		permissao = to.getPermissao();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
			if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


	



}




	

