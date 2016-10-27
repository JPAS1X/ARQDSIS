package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import to.AlunoTO;

public class AlunoTOTest {
	AlunoTO to;
	@Before
	public void setUp() throws Exception {
		to = new AlunoTO();
		to.setFone("123456789");
		to.setNome("Bela Lugosi");
		to.setId(3);
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getNome(), "Bela Lugosi");
		assertEquals("getFone", to.getFone(), "123456789");
		assertEquals("getId", to.getId(), 3);
	}
	
	@Test
	public void testEquals(){
		AlunoTO copia = new AlunoTO();
		copia.setFone(to.getFone());
		copia.setNome(to.getNome());
		copia.setId(to.getId());
		assertEquals("teste to igual a copia", to, copia);
	}

}
