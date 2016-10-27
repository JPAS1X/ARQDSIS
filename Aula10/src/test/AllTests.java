package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunoDAOTest.class, AlunoTOTest.class, ConnectionFactoryTest.class })
public class AllTests {

}
