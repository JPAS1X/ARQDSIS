package test;

import static org.junit.Assert.assertEquals;
import model.Curso;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoTest {
	Curso curso, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete
	 * Certifique-se também que sobrecarregou o equals na classe Curso. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 */
	@Before
	public void setUp() throws Exception {
		curso = new Curso(3 , "Sistemas de informação", "Informática", "18/03/2016", "18/03/2020", "19hrs", 0.0, 100, "Tradicional/Informática", "Jgrasp e Eclipse", "Deithel", "Serão disponibilizados pdf com as aulas");
		copia = new Curso(3, "Sistemas de informação", "Informática", "18/03/2016", "18/03/2020", "19hrs",  0.0, 100, "Tradicional/Informática", "Jgrasp e Eclipse", "Deithel", "Serão disponibilizados pdf com as aulas");
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Curso fixture = new Curso(1, "nome1", "tipo1", "datainicio1", "datatermino1", "horario1", 0.0, 1, "tipolab1", "softwares1", "livros1", "descricao1");
		Curso novo = new Curso(1, "nome1", "tipo1", "datainicio1", "datatermino1", "horario1", 0.0, 1, "tipolab1", "softwares1", "livros1", "descricao1");
		novo.carregar();
		assertEquals("Testa a consulta/carregamento", novo, fixture);
	}

	@Test
	public void test01Criar() {
		curso.criar();
		curso.carregar();
		assertEquals("testa criacao", curso, copia);
	}
	
	@Test
	public void test02Atualizar() {
		curso.setTipo("999999");
		curso.setHorario("19hrs");
		curso.setDataDeInicio("10/10/2016");
		copia.setDataDeInicio("10/10/2016");
		copia.setHorario("19hrs");
		copia.setTipo("999999");		
		curso.atualizar();
		assertEquals("Testa a alteração", curso, copia);
	}

	@Test
	public void test03Excluir() {
		curso.setNome(null);
		curso.setTipo(null);
		curso.setDataDeInicio(null);
		curso.setDataDeTermino(null);
		curso.setHorario(null);
		curso.setValor(0.00);
		curso.setNumeroDeVagas(0);
		curso.setTipoLab(null);
		curso.setSoftwares(null);
		curso.setLivros(null);
		curso.setDescricao(null);
		
		copia.setNome(null);
		copia.setTipo(null);
		copia.setDataDeInicio(null);
		copia.setDataDeTermino(null);
		copia.setHorario(null);
		copia.setValor(0.00);
		copia.setNumeroDeVagas(0);
		copia.setTipoLab(null);
		copia.setSoftwares(null);
		copia.setLivros(null);
		copia.setDescricao(null);
		
		curso.excluir();
		assertEquals("Testa a exclusão", curso, copia);
	}
}