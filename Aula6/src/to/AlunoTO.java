package to;

public class AlunoTO {

	private String nome, dataNascimento, sexo, endereco, complemento, rg, cpf, email, telefone;
	private int codigo, numero;

	//Métodos de acesso
	public int getCodigo() {

		return codigo;
	}

	public String getNome() {

		return nome;
	}

	public String getSexo() {

		return sexo;
	}

	public String getDataNascimento() {

		return dataNascimento;
	}

	public String getEndereco() {

		return endereco;
	}

	public int getNumero() {

		return numero;
	}

	public String getComplemento() {

		return complemento;
	}

	public String getRG() {

		return rg;
	}

	public String getCPF() {

		return cpf;
	}

	public String getEmail() {

		return email;
	}

	public String getTelefone() {

		return telefone;
	}

	//Métodos modificadores
	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}
	
	public void setNome(String nome) {

		this.nome = nome;
	}

	public void setSexo(String sexo) {

		this.sexo = sexo;
	}

	public void setDataNascimento(String nvData) {

		this.dataNascimento = nvData;
	}

	public void setCPF(String cpf) {

		this.cpf = cpf;
	}

	public void setRG(String rg) {

		this.rg = rg;
	}

	public void setEndereco(String nvEndereco) {

		this.endereco = nvEndereco;
	}

	public void setNumero(int numero) {

		this.numero = numero;
	}

	public void setComplemento(String complemento) {

		this.complemento = complemento;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoTO other = (AlunoTO) obj;
		if (codigo != other.codigo)
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}