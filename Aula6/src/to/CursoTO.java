package to;

public class CursoTO {
	private int codigo, numeroDeVagas;
	private String nome, tipo, dataDeInicio, dataDeTermino, horario, tipoLab, softwares, livros, descricaoMaterial;
	private double valor;

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

	//Metodos de Modificação
	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}

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

	public void setDescricao(String descricao) {

		this.descricaoMaterial = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoTO other = (CursoTO) obj;
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
	
}
