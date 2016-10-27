
package model;

import to.CursoTO;

import dao.CursoDAO;

public class Curso {
	private int codigo;
	private String nome;
	private String tipo;
	private String dataInicio;
	private String dataTermino;
	private String horario;
	private String numeroVagas;
	private String valor;
	private String disponibilidade;
		

	public Curso(int codigo, String tipo , String nome, String dataTermino, String dataInicio, String horario, String numeroVagas, String valor, String disponibilidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.dataTermino = dataTermino;
		this.dataInicio = dataInicio;
		this.horario = horario;
		this.numeroVagas = numeroVagas;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		
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
	
	public String getTipo() {
		return nome;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(String numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	
	public String getDisponibilidade() {
		return disponibilidade;
	}


	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public void criar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getTO();
		dao.inserir(to);
		//como o campo codigo da tabela Aluno é auto_increment, um novo codigo será criado 
		this.codigo = to.getCodigo();
	}

	public CursoTO getTO() {
		CursoTO to = new CursoTO();
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setTipo(tipo);
		to.setDataInicio(dataInicio);
		to.setNumeroVagas(numeroVagas);
		to.setHorario(horario);
		to.setDataTermino(dataTermino);		
		to.setValor(valor);
		to.setDisponibilidade(disponibilidade);
			
		return to;
	}

	public void atualizar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getTO();
		dao.alterar(to);
	}

	public void excluir() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		to.setCodigo(codigo);
		dao.deletar(to);
	}

	public void carregar() {
		CursoDAO dao = new CursoDAO();
		CursoTO too = dao.carregar2(codigo);
		nome = too.getNome();
		dataInicio = too.getDataInicio();
		numeroVagas = too.getNumeroVagas();
		horario = too.getHorario();
		dataTermino = too.getDataTermino();
		valor = too.getValor();
		disponibilidade = too.getDisponibilidade();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
			if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
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


