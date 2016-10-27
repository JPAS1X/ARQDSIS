package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.CursoDAO;
import to.CursoTO;

public class CursoDAOTest {	
	CursoDAO dao;
	CursoTO to;
	
	@Before
	public void setUp() throws Exception {
		dao = new CursoDAO();
		to = new CursoTO();
		to.setCodigo(1);
		to.setNome("Rafael");
		to.setTipo("Informatica");
		to.setDataDeInicio("10/10/15");
		to.setDataDeTermino("10/10/15");
		to.setHorario("10:00");
		to.setValor(10.00);
		to.setNumeroDeVagas(10);
		to.setTipoLab("A");
		to.setSoftwares("Nenhum");
		to.setLivros("Alguns");
		to.setDescricao("Nenhum");
	}
	
	public void testCarregar01() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		CursoTO fixture = new CursoTO();
		fixture.setCodigo(1);
		fixture.setNome("Rafael");
		fixture.setTipo("Informatica");
		fixture.setDataDeInicio("10/10/15");
		fixture.setDataDeTermino("10/10/15");
		fixture.setHorario("10:00");
		fixture.setValor(10.00);
		fixture.setNumeroDeVagas(10);
		fixture.setTipoLab("A");
		fixture.setSoftwares("Nenhum");
		fixture.setLivros("Alguns");
		fixture.setDescricao("Nenhum");
		CursoTO novo = dao.carregar(1);
		novo.setCodigo(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void testInserir02() {
		dao.incluir(to);
		CursoTO novo = dao.carregar(to.getCodigo());
		
		novo.setCodigo(to.getCodigo());
		assertEquals("Testa a inserção", novo, to);
	}
	
	@Test
	public void testAtualizar03() {
		to.setNome("Segurança da informação");
		to.setDescricao("Cuida da segurança dos dados");
		dao.atualizar(to);
		
		CursoTO novo = dao.carregar(to.getCodigo());
		novo.setCodigo(to.getCodigo());
		assertEquals("Testa a alteração", novo, to);
	}
	
	@Test
	public void testExcluir04() {
		to.setNome(null);
		to.setTipo(null);
		to.setDataDeInicio(null);
		to.setDataDeTermino(null);
		to.setHorario(null);
		to.setValor(0.00);
		to.setNumeroDeVagas(0);
		to.setTipoLab(null);
		to.setSoftwares(null);
		to.setLivros(null);
		to.setDescricao(null);
		
		dao.excluir(to);
		CursoTO novo = dao.carregar(to.getCodigo());
		novo.setCodigo(to.getCodigo());
		
		assertEquals("Testa a exclusão", novo, to);
	}
}
