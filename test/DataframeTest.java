import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import Dataframe;

public class DataframeTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);//ajout du timeout
	
	//test simple sur les methodes
	@Test
	@DisplayName("get interger")
	public void testBasique() {
		Dataframe d = new Dataframe(10);
		assertEquals( 10, d.valeur());
	}
}
