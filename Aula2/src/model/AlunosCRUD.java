package model;
import dao.AlunosDAO;
import to.AlunosTO;

public class AlunosCRUD {

	private String nome, rg, end, email;
	private int cpf, tel;

	public AlunosCRUD(String nome, String rg, String end, String email, int cpf, int tel) {

		this.nome = nome;
		this.rg = rg;
		this.end = end;
		this.email = email;
		this.cpf = cpf;
		this.tel = tel;
	}

	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public String getRg() {
		return rg;

	}

	public void setRg(String rg) {

		this.rg = rg;

	}

	public String getEnd() {

		return end;

	}

	public void setEnd(String end) {

		this.end = end;

	}

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public int getCpf() {
		return cpf;

	}

	public void setCpf(int cpf) {

		this.cpf = cpf;

	}

	public int getTel() {
		return tel;

	}

	public void setTel(int tel) {

		this.tel = tel;

	}

	public void cadastrar() {

		AlunosDAO dao = new AlunosDAO();
		AlunosTO to = new AlunosTO();

		to.setNome(nome);
		to.setRg(rg);
		to.setCpf(cpf);
		to.setEnd(end);
		to.setEmail(email);
		to.setTel(tel);
		dao.cadastrar(to);

	}

	public void consultar() {

		AlunosDAO dao = new AlunosDAO();
		AlunosTO to = dao.consultar(cpf);

		nome = to.getNome();
		rg = to.getRg();
		cpf = to.getCpf();
		end = to.getEnd();
		email = to.getEmail();
		tel = to.getTel();
	}

	public void alterar() {

		AlunosDAO dao = new AlunosDAO();
		AlunosTO to = new AlunosTO();

		to.setNome(nome);
		to.setRg(rg);
		to.setCpf(cpf);
		to.setEnd(end);
		to.setEmail(email);
		to.setTel(tel);
		dao.alterar(to);
		
		System.out.println("Dados Alterados");

	}

	public void deletar() {

		AlunosDAO dao = new AlunosDAO();
		AlunosTO to = new AlunosTO();

		to.setCpf(cpf);
		dao.deletar(to);
		
		System.out.println("Dados Excuidos");

	}

	public String toString() {

		return "Aluno Nome" + nome + "\nRg=" + rg + "\nCpf " + cpf + "\nEndereço=" + end + "\nEmail" + email
				+ "\nTelefone " + tel + "]";
	}

}
