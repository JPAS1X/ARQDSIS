package model;

import to.ProfessorTO;

import dao.ProfessorDAO;

public class Professor {

	private int codigo;
	private String nome;
	private String rg;
	private String dataAdm;
	private String telefone;
	private String celular;
	private String email;
	private String curso;
	private String usuario;
	private String senha;
	private String permissao;
		

	public Professor(int codigo, String nome,  String rg,  String dataAdm, String telefone, String celular, String email, String curso, String usuario, String senha, String permissao) {
		this.codigo= codigo;
		this.nome = nome;
		this.rg = rg;
		this.dataAdm = dataAdm;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.curso = curso;
		this.usuario = usuario;
		this.senha = senha;
		this.permissao = permissao;
		
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getDataAdm() {
		return dataAdm;
	}


	public void setDataAdm(String dataAdm) {
		this.dataAdm = dataAdm;
	}


	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = getTO();
		dao.incluir(to);
		//como o campo id da tabela professor é auto_increment, um novo id será criado 
		this.codigo = to.getCodigo();
	}

	public ProfessorTO getTO() {
		ProfessorTO to = new ProfessorTO();
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setRg(rg);
		to.setTelefone(telefone);
		to.setCelular(celular);
		to.setDataAdm(dataAdm);		
		to.setEmail(email);
		to.setCurso(curso);
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setPermissao(permissao);
		
		return to;
	}

	public void atualizar() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = new ProfessorTO();
		to.setCodigo(codigo);
		dao.excluir(to);
	}

	public void carregar() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = dao.carregar(codigo);
		nome = to.getNome();
		rg = to.getRg();
		telefone = to.getTelefone();
		celular = to.getCelular();
		dataAdm = to.getDataAdm();
		email = to.getEmail();
		curso = to.getCurso();
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
		Professor other = (Professor) obj;
			if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


	}




	

