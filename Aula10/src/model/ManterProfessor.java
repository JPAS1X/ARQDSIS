/*package model;


import dao.ProfessorDAO;
import to.ProfessorTO;

public class ManterProfessor {
	
	String   nome, rg, dataAdm, telefone, celular, email, curso, usuario, senha , permissao;
	int codigo;
	ProfessorTO TO;

	public ManterProfessor (ProfessorTO professorTO){
		
		this.codigo = professorTO.getCodigo();
		this.rg = professorTO.getRg();
		this.nome = professorTO.getNome();
		this.dataAdm =  professorTO.getDataAdm();
		this.telefone = professorTO.getTelefone();
		this.celular =  professorTO.getCelular();
		this.email = professorTO.getEmail();
		this.curso= professorTO.getCurso();
		this.usuario =  professorTO.getUsuario();
		this.senha = professorTO.getSenha();
		this.permissao= professorTO.getPermissao();

	}

	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAdm() {
		return dataAdm;
	}

	public void setDataAdm(String dataAdm) {
		this.dataAdm = dataAdm;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public ProfessorTO getTO() {
		ProfessorTO to = new ProfessorTO();
    
		to.setCodigo(codigo);
		to.setRg(rg);
		to.setNome(nome);
		to.setDataAdm(dataAdm);
		to.setTelefone(telefone);
		to.setCelular(celular);
		to.setEmail(email);
		to.setCurso(curso);
			
		return to;
	}
	
	// criar
	public void cadastrar() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = new ProfessorTO();
		dao.inserir(to);
		this.codigo = to.getCodigo();

	}
	
	
	

	public void alterar() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = new ProfessorTO();

		to.setCodigo(codigo);
		to.setRg(rg);
		to.setNome(nome);
		to.setDataAdm(dataAdm);
		to.setTelefone(telefone);
		to.setCelular(celular);
		to.setEmail(email);
		to.setCurso(curso);

		dao.alterar(to);
	}

	public void deletar() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO to = new ProfessorTO();

		to.setCodigo(codigo);
		dao.deletar(to);
	}
public void carregar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = dao.carregar(id);
		nome = to.getNome();
		fone = to.getFone();
		email = to.getEmail();
	}
	
	public void carregar() {
		ProfessorDAO dao = new ProfessorDAO();
	   ProfessorTO armazenaCodigo = new ProfessorTO();
	    armazenaCodigo.setCodigo(codigo);
		ProfessorTO to = dao.carregar(armazenaCodigo);

	    nome = to.getNome();
	    rg = to.getRg();
		dataAdm =  to.getDataAdm();
		telefone = to.getTelefone();
		celular =  to.getCelular();
		email = to.getEmail();
		curso= to.getCurso();
				
	}

	
	public ProfessorTO consultar() {
		ProfessorDAO dao = new ProfessorDAO();
		ProfessorTO armazenaCodigo = new ProfessorTO();
		armazenaCodigo.setCodigo(codigo);
		ProfessorTO TO = dao.carregar(armazenaCodigo);

		return TO;
	}
	
	public String consultarTodos(){
		ProfessorDAO dao = new ProfessorDAO();
		String resp = dao.consultarTodos();
		return resp;
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManterProfessor other = (ManterProfessor) obj;
		if (codigo != other.codigo)
			return false;
		if (dataAdm == null) {
			if (other.dataAdm != null)
				return false;
		} else if (!dataAdm.equals(other.dataAdm))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
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
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}






	
}
*/