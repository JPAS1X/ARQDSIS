package model;


import dao.CursoDAO;
import to.CursoTO;

public class ManterCurso {
	
	String  tipo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, disponibilidade;
	int codigo;
	CursoTO TO;

	public ManterCurso (CursoTO cursoTO){
		
		this.codigo = cursoTO.getCodigo();
		this.tipo = cursoTO.getTipo();
		this.nome = cursoTO.getNome();
		this.dataInicio =  cursoTO.getDataInicio();
		this.dataTermino = cursoTO.getDataTermino();
		this.horario = cursoTO.getHorario();
		this.numeroVagas =  cursoTO.getNumeroVagas();
		this.valor = cursoTO.getValor();
		this.disponibilidade= cursoTO.getDisponibilidade();

	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public CursoTO getTO() {
		CursoTO to = new CursoTO();
    
		to.setCodigo(codigo);
		to.setTipo(tipo);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setDisponibilidade(disponibilidade);
			
		return to;
	}
	
	// criar
	public void cadastrar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		dao.inserir(to);
		this.codigo = to.getCodigo();

	}
	
	
	

	public void alterar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();

		to.setCodigo(codigo);
		to.setTipo(tipo);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setDisponibilidade(disponibilidade);

		dao.alterar(to);
	}

	public void deletar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();

		to.setCodigo(codigo);
		dao.deletar(to);
	}

	
	public void carregar() {
		CursoDAO dao = new CursoDAO();
	   CursoTO armazenaCodigo = new CursoTO();
	    armazenaCodigo.setCodigo(codigo);
		CursoTO to = dao.carregar(armazenaCodigo);

	    nome = to.getNome();
	    tipo = to.getTipo();
		dataInicio =  to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		numeroVagas =  to.getNumeroVagas();
		valor = to.getValor();
		disponibilidade= to.getDisponibilidade();
				
	}

	
	public CursoTO consultar() {
		CursoDAO dao = new CursoDAO();
		CursoTO armazenaCodigo = new CursoTO();
		armazenaCodigo.setCodigo(codigo);
		CursoTO TO = dao.carregar(armazenaCodigo);

		return TO;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManterCurso other = (ManterCurso) obj;
		if (codigo != other.codigo)
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (disponibilidade == null) {
			if (other.disponibilidade != null)
				return false;
		} else if (!disponibilidade.equals(other.disponibilidade))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (numeroVagas == null) {
			if (other.numeroVagas != null)
				return false;
		} else if (!numeroVagas.equals(other.numeroVagas))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
