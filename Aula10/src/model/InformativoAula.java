package model;

import dao.InformativoAulaDAO;
import to.InformativoAulaTO;

public class InformativoAula {
	private int codigo;
	private String data;
	private String nomeProfessor;
	private String conteudo;
		

	public InformativoAula(int codigo, String data, String nomeProfessor, String conteudo) {
		this.codigo= codigo;
		this.data = data;
		this.nomeProfessor = nomeProfessor;
		this.conteudo = conteudo;
		
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

	public void criar() {
		InformativoAulaDAO dao = new InformativoAulaDAO();
		InformativoAulaTO to = getTO();
		dao.incluir(to);
		//como o campo id da tabela professor é auto_increment, um novo id será criado 
		this.codigo = to.getCodigo();
	}

	public InformativoAulaTO getTO() {
		InformativoAulaTO to = new InformativoAulaTO();
		to.setCodigo(codigo);
		to.setData(data);
		to.setNomeProfessor(nomeProfessor);
		to.setConteudo(conteudo);
		
		return to;
	}

	public void atualizar() {
		InformativoAulaDAO dao = new InformativoAulaDAO();
		InformativoAulaTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		InformativoAulaDAO dao = new InformativoAulaDAO();
		InformativoAulaTO to = new InformativoAulaTO();
		to.setCodigo(codigo);
		dao.excluir(to);
	}

	public void carregar() {
		InformativoAulaDAO dao = new InformativoAulaDAO();
		InformativoAulaTO to = dao.carregar(codigo);
		data = to.getData();
		nomeProfessor = to.getNomeProfessor();
		conteudo= to.getConteudo();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformativoAula other = (InformativoAula) obj;
			if (data == null) {
			if (other.data!= null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (codigo != other.codigo)
			return false;
		if (nomeProfessor == null) {
			if (other.nomeProfessor != null)
				return false;
		} else if (!nomeProfessor.equals(other.nomeProfessor))
			return false;
		return true;
	}


	}
