package model;
import dao.CursosDAO;
import to.CursosTO;

public class CursosCRUD {

	private String cod, nome, numLab, regSoft, material, livro, dataIni, dataTer, horario;
	private int vagas;
	private double valor;

	public CursosCRUD(String cod, String nome, String numLab, String regSoft, String material, String livro,
			String dataIni, String dataTer, String horario, int vagas, double valor) {

		this.cod = cod;
		this.nome = nome;
		this.numLab = numLab;
		this.regSoft = regSoft;
		this.material = material;
		this.livro = livro;
		this.dataIni = dataIni;
		this.dataTer = dataTer;
		this.horario = horario;
		this.vagas = vagas;
		this.valor = valor;

	}

	public String getCod() {
		return cod;

	}

	public void setCod(String cod) {

		this.cod = cod;

	}

	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public String getNumLab() {
		return numLab;

	}

	public void setNumLab(String numLab) {

		this.numLab = numLab;

	}

	public String getRegSoft() {
		return regSoft;

	}

	public void setRegSoft(String regSoft) {

		this.regSoft = regSoft;

	}

	public String getMaterial() {
		return material;

	}

	public void setMaterial(String material) {

		this.material = material;

	}

	public String getLivro() {
		return livro;

	}

	public void setLivro(String livro) {

		this.livro = livro;

	}

	public String getDataIni() {
		return dataIni;

	}

	public void setDataIni(String dataIni) {

		this.dataIni = dataIni;

	}

	public String getDataTer() {
		return dataTer;

	}

	public void setDataTer(String dataTer) {

		this.dataTer = dataTer;

	}

	public String getHorario() {
		return horario;

	}

	public void setHorario(String horario) {

		this.horario = horario;

	}

	public int getVagas() {
		return vagas;

	}

	public void setVagas(int vagas) {

		this.vagas = vagas;

	}

	public double getValor() {
		return valor;

	}

	public void setValor(double valor) {

		this.valor = valor;

	}

	public void cadastrar() {

		CursosDAO dao = new CursosDAO();
		CursosTO to = new CursosTO();

		to.setCod(cod);
		to.setNome(nome);
		to.setDataIni(dataIni);
		to.setDataTer(dataTer);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.getNumLab();
		to.getRegSoft();
		to.setMaterial(material);
		to.setLivro(livro);
		dao.cadastrar(to);

	}

	public void consultar() {

		CursosDAO dao = new CursosDAO();
		CursosTO to = dao.consultar(cod);

		nome = to.getNome();
		dataIni = to.getDataIni();
		dataTer = to.getDataTer();
		horario = to.getHorario();
		vagas = to.getVagas();
		valor = to.getValor();
		material = to.getMaterial();
		livro = to.getLivro();
		numLab = to.getNumLab();
		regSoft = to.getRegSoft();

	}

	public void alterar() {

		CursosDAO dao = new CursosDAO();
		CursosTO to = new CursosTO();

		to.setCod(cod);
		to.setNome(nome);
		to.setDataIni(dataIni);
		to.setDataTer(dataTer);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.getNumLab();
		to.getRegSoft();
		to.setMaterial(material);
		to.setLivro(livro);
		dao.alterar(to);
		
		System.out.println("Dados Alterdos");

	}

	public void deletar() {

		CursosDAO dao = new CursosDAO();
		CursosTO to = new CursosTO();

		to.setCod(cod);
		dao.deletar(to);
		
		System.out.println("Dados Excluidos");

	}

	public String toString() {

		return "Curso Codigo=" + cod + "\nNome=" + nome + "\nLaboratorio=" + numLab + "\nRegistro Software=" + regSoft
				+ "\nMaterial=" + material + "\nLivro=" + livro + "\nData inicio= " + dataIni + "\nData Termino="
				+ dataTer + "\nHorario=" + horario + "\nVagas=" + vagas + "\nValor=" + valor;

	}

}
