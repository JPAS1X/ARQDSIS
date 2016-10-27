package model;

import to.DiretoriaTO;

import dao.DiretoriaDAO;

public class Diretoria {
	private int id;
	private String nome;	
	private String rg;
	private String fone;
	private String unidade;
	private String foneF;
	private String email;
	private String usuario;
	private String senha;
	private String permissao;
		

	public Diretoria(int id, String nome,  String rg, String unidade, String foneF, String fone, String email, String usuario, String senha, String permissao) {
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.unidade = unidade;
		this.foneF = foneF;
		this.fone = fone;
		this.email = email;
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

	public String getFoneF() {
		return foneF;
	}

	public void setFoneF(String foneF) {
		this.foneF = foneF;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
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
		DiretoriaDAO dao = new DiretoriaDAO();
		DiretoriaTO to = getTO();
		dao.incluir(to);
		//como o campo id da tabela diretoria é auto_increment, um novo id será criado 
		this.id = to.getId();
	}

	public DiretoriaTO getTO() {
		DiretoriaTO to = new DiretoriaTO();
		to.setId(id);
		to.setNome(nome);
		to.setRg(rg);
		to.setUnidade(unidade);
		to.setFoneF(foneF);
		to.setFone(fone);		
		to.setEmail(email);
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setPermissao(permissao);
		
		return to;
	}

	public void atualizar() {
		DiretoriaDAO dao = new DiretoriaDAO();
		DiretoriaTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		DiretoriaDAO dao = new DiretoriaDAO();
		DiretoriaTO to = new DiretoriaTO();
		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		DiretoriaDAO dao = new DiretoriaDAO();
		DiretoriaTO to = dao.carregar(id);
		nome = to.getNome();
		rg = to.getRg();
		unidade = to.getUnidade();
		foneF = to.getFoneF();
		fone = to.getFone();
		email = to.getEmail();
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
		Diretoria other = (Diretoria) obj;
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




	

