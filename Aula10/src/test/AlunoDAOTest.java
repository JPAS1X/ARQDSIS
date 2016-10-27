package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import to.AlunoTO;
import dao.AlunoDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
	static AlunoDAO dao;
	static AlunoTO to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture aluno 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe AlunoTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		dao = new AlunoDAO();
		to = new AlunoTO();
		to.setFone("123456789");
		to.setNome("Bela Lugosi");
		to.setEndereco("rua jasmin");
		to.setFoneF("12343443334");
		to.setNomeM("Belar vitor");
		to.setRg("494775958");
		to.setId(-1);
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o aluno 1 deve ter sido carregado no banco por fora
		//delete from aluno;
		//insert into aluno (nome, fone, email) values ('nome1', 'fone1', 'email1');
		AlunoTO fixture = new AlunoTO();
		fixture.setFone("fone1");
		fixture.setNome("nome1");
		fixture.setRg("rg1");
		fixture.setFoneF("foneF1");
		fixture.setNomeM("nome1");
		fixture.setEndereco("endereco1");
		fixture.setId(1);
		AlunoTO novo = dao.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		AlunoTO novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setFone("999999");
		dao.atualizar(to);
		AlunoTO novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setFone(null);
		to.setEndereco(null);
		to.setNomeM(null);
		to.setFoneF(null);
		to.setRg(null);
		dao.excluir(to);
		AlunoTO novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
}
