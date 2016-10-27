package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Aluno;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoTest {
	
	Aluno aluno, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno(2, "Igor Apolinário", "Masculino", "20/06/1996", "1234-5678", 70, "Rua A", "Apartamento", "000-000", "1111-1111", "igor@hotmail.com");
		copia = new Aluno(2, "Igor Apolinário", "Masculino", "20/06/1996", "1234-5678", 70, "Rua A", "Apartamento", "000-000", "1111-1111", "igor@hotmail.com");
	}
	
	@Test
	public void testCarregar01() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		Aluno fixture = new Aluno(2, "nome1", "sexo1", "data1", "fone1", 1, "end1", "complemento1", "rg1", "cpf1", "email1");
		Aluno novo = new Aluno(2, null, null, null, null, 0, null, null, null, null, null);
		novo.carregar();
		assertEquals("Testa a consulta", novo, fixture);
	}

	@Test
	public void testCriar02() {
		aluno.criar();
		aluno.carregar();
		assertEquals("Testa a inclusão", aluno, copia);
	}

	@Test
	public void testAtualizar03() {
		aluno.setEndereco("Rua Silvianópolis");
		aluno.setCPF("2565-5412-544");
		copia.setEmail("teste@teste.com.br");
		aluno.atualizar();
		assertEquals("Testa a atualização", aluno, copia);
	}

	@Test
	public void testExcluir04() {
		aluno.setNome(null);
		aluno.setSexo(null);
		aluno.setDataNascimento(null);
		aluno.setTelefone(null);
		aluno.setEndereco(null);
		aluno.setNumero(0);
		aluno.setComplemento(null);
		aluno.setRG(null);
		aluno.setCPF(null);
		aluno.setEmail(null);
		
		copia.setNome(null);
		copia.setSexo(null);
		copia.setDataNascimento(null);
		copia.setTelefone(null);
		copia.setEndereco(null);
		copia.setNumero(0);
		copia.setComplemento(null);
		copia.setRG(null);
		copia.setCPF(null);
		copia.setEmail(null);
		
		aluno.excluir();
		assertEquals("Testa a exclusão", aluno, copia);
	}

}
