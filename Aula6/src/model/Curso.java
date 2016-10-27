package model;

import dao.CursoDAO;
import to.CursoTO;

public class Curso {
	private int codigo, numeroDeVagas;
	private String nome, tipo, dataDeInicio, dataDeTermino, horario, tipoLab, softwares, livros, descricaoMaterial;
	private double valor;

	public Curso() {
		codigo = 0;
		nome = "";
		tipo = "";
		dataDeInicio = "";
		dataDeTermino = "";
		horario = "";
		numeroDeVagas = 0;
		valor = 0.0;
		tipoLab = "";
		softwares = "";
		livros = "";
		descricaoMaterial = "";
	}

	public Curso(int codigo, String nome, String tipo, String dataDeInicio, String dataDeTermino, String horario,
			double valor, int numeroDeVagas, String tipoLab, String softwares, String livros,
			String descricaoMaterial) {

		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.horario = horario;
		this.valor = valor;
		this.numeroDeVagas = numeroDeVagas;
		this.tipoLab = tipoLab;
		this.softwares = softwares;
		this.livros = livros;
		this.descricaoMaterial = descricaoMaterial;
	}
	
	//Metodos de acesso
	public int getCodigo() {

		return codigo;
	}

	public String getNome() {

		return nome;
	}

	public String getTipo() {

		return tipo;
	}

	public String getDataDeInicio() {

		return dataDeInicio;
	}

	public String getDataDeTermino() {

		return dataDeTermino;
	}

	public String getHorario() {

		return horario;
	}

	public int getNumeroDeVagas() {

		return numeroDeVagas;
	}

	public double getValor() {

		return valor;
	}

	public String getTipoLab() {

		return tipoLab;
	}

	public String getSoftwares() {

		return softwares;
	}

	public String getLivros() {

		return livros;
	}

	public String getDescricao() {

		return descricaoMaterial;
	}

	//Métodos de Modificação
	public void setNome(String nome) {

		this.nome = nome;
	}

	public void setTipo(String tipo) {

		this.tipo = tipo;
	}

	public void setDataDeInicio(String dataDeInicio) {

		this.dataDeInicio = dataDeInicio;
	}

	public void setDataDeTermino(String dataDeTermino) {

		this.dataDeTermino = dataDeTermino;
	}

	public void setHorario(String horario) {

		this.horario = horario;
	}

	public void setNumeroDeVagas(int numeroDeVagas) {

		this.numeroDeVagas = numeroDeVagas;
	}

	public void setValor(double valor) {

		this.valor = valor;
	}

	public void setTipoLab(String tipoLab) {

		this.tipoLab = tipoLab;
	}

	public void setSoftwares(String softwares) {

		this.softwares = softwares;
	}

	public void setLivros(String livros) {

		this.livros = livros;
	}

	public void setDescricao(String descricaoMaterial) {

		this.descricaoMaterial = descricaoMaterial;
	}

	public void criar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();

		to.setCodigo(codigo);
		to.setNome(nome);
		to.setTipo(tipo);
		to.setDataDeInicio(dataDeInicio);
		to.setDataDeTermino(dataDeTermino);
		to.setHorario(horario);
		to.setValor(valor);
		to.setNumeroDeVagas(numeroDeVagas);
		to.setTipoLab(tipoLab);
		to.setSoftwares(softwares);
		to.setLivros(livros);
		to.setDescricao(descricaoMaterial);

		dao.incluir(to);
	}

	public void atualizar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();

		to.setCodigo(codigo);
		to.setNome(nome);
		to.setTipo(tipo);
		to.setDataDeInicio(dataDeInicio);
		to.setDataDeTermino(dataDeTermino);
		to.setHorario(horario);
		to.setValor(valor);
		to.setNumeroDeVagas(numeroDeVagas);
		to.setTipoLab(tipoLab);
		to.setSoftwares(softwares);
		to.setLivros(livros);
		to.setDescricao(descricaoMaterial);

		dao.atualizar(to);
	}

	public void excluir() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		
		to.setCodigo(codigo);
		
		dao.excluir(to);
	}

	public void carregar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = dao.carregar(codigo);
		
		codigo = to.getCodigo();
		nome = to.getNome();
		tipo = to.getTipo();
		dataDeInicio = to.getDataDeInicio();
		dataDeTermino = to.getDataDeTermino();
		horario = to.getHorario();
		valor = to.getValor();
		numeroDeVagas = to.getNumeroDeVagas();
		tipoLab = to.getTipo();
		softwares = to.getSoftwares();
		livros = to.getLivros();
		descricaoMaterial = to.getDescricao();
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
		if (codigo != other.codigo)
			return false;
		if (dataDeInicio == null) {
			if (other.dataDeInicio != null)
				return false;
		} else if (!dataDeInicio.equals(other.dataDeInicio))
			return false;
		if (dataDeTermino == null) {
			if (other.dataDeTermino != null)
				return false;
		} else if (!dataDeTermino.equals(other.dataDeTermino))
			return false;
		if (descricaoMaterial == null) {
			if (other.descricaoMaterial != null)
				return false;
		} else if (!descricaoMaterial.equals(other.descricaoMaterial))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroDeVagas != other.numeroDeVagas)
			return false;
		if (softwares == null) {
			if (other.softwares != null)
				return false;
		} else if (!softwares.equals(other.softwares))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoLab == null) {
			if (other.tipoLab != null)
				return false;
		} else if (!tipoLab.equals(other.tipoLab))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", numeroDeVagas=" + numeroDeVagas + ", nome=" + nome + ", tipo=" + tipo
				+ ", dataDeInicio=" + dataDeInicio + ", dataDeTermino=" + dataDeTermino + ", horario=" + horario
				+ ", tipoLab=" + tipoLab + ", softwares=" + softwares + ", livros=" + livros + ", descricaoMaterial="
				+ descricaoMaterial + ", valor=" + valor + "]";
	}
}
