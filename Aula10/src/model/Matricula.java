package model;

import to.MatriculaTO;

import dao.MatriculaDAO;

public class Matricula {
	private int codigo;
	private String valor;
	private String data;
	private String statusPagamento;
	private String statusMatricula;
	private String codProfessor;
	private String curso;
	private String aluno;
	
	
	public Matricula(int codigo, String valor, String data, String statusPagamento, String statusMatricula, String codProfessor, String curso, String aluno) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
		this.statusPagamento = statusPagamento;
		this.statusMatricula = statusMatricula;
		this.codProfessor = codProfessor;
		this.curso = curso;
		this.aluno = aluno;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}
	
	public String getCodProfessor() {
		return codProfessor;
	}

	public void setCodProfessor(String codProfessor) {
		this.codProfessor = codProfessor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	
	public void criar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = getTO();
		dao.incluir(to);
		//como o campo id da tabela matricula é auto_increment, um novo id será criado 
		this.codigo = to.getCodigo();
	}

	public MatriculaTO getTO() {
		MatriculaTO to = new MatriculaTO();
		to.setCodigo(codigo);
		to.setValor(valor);
		to.setData(data);
		to.setStatusPagamento(statusPagamento);
		to.setStatusMatricula(statusMatricula);
		to.setCodProfessor(codProfessor);
		to.setCurso(curso);		
		to.setAluno(aluno);
		return to;
	}

	public void atualizar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = new MatriculaTO();
		to.setCodigo(codigo);
		dao.excluir(to);
	}

	public void carregar() {
		MatriculaDAO dao = new MatriculaDAO();
		MatriculaTO to = dao.carregar(codigo);
		valor = to.getValor();
		data = to.getData();
		statusPagamento = to.getStatusPagamento();
		statusMatricula = to.getStatusMatricula();
		codProfessor = to.getCodProfessor();
		curso = to.getCurso();
		aluno = to.getAluno();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
			if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (codigo != other.codigo)
			return false;
		if (data == null) {
			if (other.data!= null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}




	

