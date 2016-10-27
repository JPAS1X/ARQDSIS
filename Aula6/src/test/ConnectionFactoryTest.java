package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import factory.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void testObterConexao() {
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			assertNotNull("Irá testar se a conexão não é nula", conn);
			assertTrue("Irá verificar se é um objeto de conexão", conn instanceof Connection );
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Caso der errado, gerou SQLException");
		}
	}


}
