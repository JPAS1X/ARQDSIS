package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConnectionFactoryTest.class, 
				ExtratoDAOTest.class, ExtratoTest.class, ExtratoTOTest.class, 
				SaqueDAOTest.class, SaqueTest.class, SaqueTOTest.class})
public class AllTests {

}
