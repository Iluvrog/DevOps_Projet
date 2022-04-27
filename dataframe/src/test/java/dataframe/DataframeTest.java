import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class DataframeTest {

	Dataframe data;
	Dataframe data_csv;
	
	//----------------------test constructeurs-------------------------
	
	@BeforeEach 
	public void init() throws DimensionError{
		data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		data_csv = new Dataframe("csv/test2.csv");
		System.out.println("ok");
	}
	
	@Test
	public void testErrorDimensionColonne() throws DimensionError{
		assertThrows(DimensionError.class, () -> {
			data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} );
	    });
	}
	
	@Test
	public void testErrorDimensionLignes() throws DimensionError{
		assertThrows(DimensionError.class, () -> {
			data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} );
	    });
	}
	
	@Test
	public void testErrorDimensionColonneCSV() throws DimensionError{
		assertThrows(DimensionError.class, () -> {
			data = new Dataframe("csv/testErreurDim1.csv");
	    });
	}
	
	@Test
	public void testErrorDimensionLignesCSV() throws DimensionError{
		assertThrows(DimensionError.class, () -> {
			data = new Dataframe("csv/testErreurDim2.csv");
	    });
	}

	//test simple sur les methodes
	@Test
	@DisplayName("nb de lignes :")
	public void testnbdelignes() {
		assertEquals( 5, data.nbLignes());
	}
	
	@Test
	@DisplayName("nb de colonnes :")
	public void testnbdecolonnes() {
		assertEquals( 3, data.nbColonnes());
	}
	
}
