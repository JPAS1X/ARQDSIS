package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import to.CursoTO;

public class CursoTOTest {
	
	CursoTO to; 
	
	@Before
	public void setUp() throws Exception {
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
		to.setLivros("Deithel");
		to.setDescricao("Nenhuma");
	}

	@Test
	public void testGets() {
		assertEquals("getCodigo", to.getCodigo(), 1);
		assertEquals("getNome", to.getNome(), "Rafael");
		assertEquals("getTipo", to.getTipo(), "Informatica");
		assertEquals("getDataDeInicio", to.getDataDeInicio(), "10/10/15");
		assertEquals("getDataDeTermino", to.getDataDeTermino(), "10/10/15");
		assertEquals("getHorario", to.getHorario(), "10:00");
		assertEquals("getValor", to.getValor(), 10.00, 0.0);
		assertEquals("getNumeroDeVagas", to.getNumeroDeVagas(), 10);
		assertEquals("getTipoLab", to.getTipo(), "A");
		assertEquals("getSoftwares", to.getSoftwares(), "Nenhum");
		assertEquals("getLivros", to.getLivros(), "Deithel");	
		assertEquals("getDescricao", to.getDescricao(), "Nenhumaa");	
	}
	
	@Test
	public void testEquals(){
		CursoTO copia = new CursoTO();
		
		copia.setCodigo(to.getCodigo());
		copia.setNome(to.getNome());
		copia.setTipo(to.getTipo());
		copia.setDataDeInicio(to.getDataDeInicio());
		copia.setDataDeTermino(to.getDataDeInicio());
		copia.setHorario(to.getHorario());
		copia.setValor(to.getValor());
		copia.setNumeroDeVagas(to.getNumeroDeVagas());
		copia.setTipoLab(to.getTipo());
		copia.setSoftwares(to.getSoftwares());
		copia.setLivros(to.getLivros());
		copia.setDescricao(to.getDescricao());
		
		assertEquals("Teste para verificar se 'to' igual a 'copia'", to, copia);
	}
}
