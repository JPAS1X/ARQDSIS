package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import to.AlunoTO;

public class AlunoTOTest {
	AlunoTO to;

	@Before
	public void setUp() throws Exception{
		to = new AlunoTO();
		to.setNome("Igor Apolinário");
		to.setSexo("Masculino");
		to.setDataNascimento("20/06/1996");
		to.setTelefone("0000-1234");
		to.setEndereco("Rua A");
		to.setNumero(1);
		to.setComplemento("Apartamento");
		to.setRG("000-000-000");
		to.setCPF("000-000-000");
		to.setEmail("igor@hotmail.com");
	}
	
	@Test
	public void testGets(){
		assertEquals("getNome", to.getNome(), "Igor Apolinário");
		assertEquals("getSexo", to.getSexo(), "Masculino");
		assertEquals("getDataNascimento", to.getDataNascimento(), "20/06/1996");
		assertEquals("getTelefone", to.getTelefone(), "0000-1234");
		assertEquals("getEndereco", to.getEndereco(), "Rua A");
		assertEquals("getNumero", to.getNumero(), 1);
		assertEquals("getComplemento", to.getComplemento(), "Apartamento");
		assertEquals("getRG", to.getRG(), "000-000-000");
		assertEquals("getCPF", to.getCPF(), "000-000-000");
		assertEquals("getEmail", to.getEmail(), "igor@hotmail.com");
	}
	
	@Test
	public void testEquals(){		
		AlunoTO alu = new AlunoTO();
		
		alu.setNome(to.getNome());
		alu.setSexo(to.getSexo());
		alu.setDataNascimento(to.getDataNascimento());
		alu.setTelefone(to.getTelefone());
		alu.setEndereco(to.getEndereco());
		alu.setNumero(to.getNumero());
		alu.setComplemento(to.getComplemento());
		alu.setRG(to.getRG());
		alu.setCPF(to.getCPF());
		alu.setEmail(to.getEmail());
		
		assertEquals("Teste para verificar se 'to' igual a 'alu'", to, alu);
	}
}
