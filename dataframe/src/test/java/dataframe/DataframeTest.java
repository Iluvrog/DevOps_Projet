import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class DataframeTest {
	
	//----------------------test constructeurs-------------------------
	
	//data_small = new Dataframe( new String[]{"numero","nom"} ,(Object[]) new Integer[]{12,15} ,(Object[]) new String[]{"chien","chat"});
	//data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
	//data_csv = new Dataframe("csv/test2.csv");
	
	@Test
	public void testErrorDimensionColonne() throws Exception{
		assertThrows(DimensionError.class, () -> {
			Dataframe data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} );
	    });
	}
	
	@Test
	public void testErrorDimensionLignes() throws Exception{
		assertThrows(DimensionError.class, () -> {
			Dataframe data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} );
	    });
	}
	
	@Test
	public void testErrorDimensionColonneCSV() throws Exception{
		assertThrows(DimensionError.class, () -> {
			Dataframe data = new Dataframe("csv/testErreurDim1.csv");
	    });
	}
	
	@Test
	public void testIOException() throws Exception{
		assertThrows(IOException.class, () -> {
			Dataframe data = new Dataframe("csv/existepas.csv");
	    });
	}
	
	@Test
	public void testErrorDimensionLignesCSV() throws Exception{
		assertThrows(DimensionError.class, () -> {
			Dataframe data = new Dataframe("csv/testErreurDim2.csv");
	    });
	}

	//test simple sur les methodes
	@Test
	@DisplayName("nb de lignes :")
	public void testnbdelignes() throws Exception{
		Dataframe data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		assertEquals( 5, data.nbLignes());
	}
	
	@Test
	@DisplayName("nb de colonnes :")
	public void testnbdecolonnes() throws Exception{
		Dataframe data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		assertEquals( 3, data.nbColonnes());
	}
	
	@Test
	@DisplayName("nb de lignes :")
	public void testnbdelignes0() throws Exception{
		Dataframe data = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{} ,(Object[]) new String[]{} , (Object[]) new Double[]{} );
		assertEquals( 0, data.nbLignes());
	}
	
	@Test
	@DisplayName("nb de lignes :")
	public void testnbdelignes0CSV() throws Exception{
		Dataframe data = new Dataframe("csv/nolignes.csv");
		assertEquals( 0, data.nbLignes());
	}
	
	@Test
	@DisplayName("nb de colonnes :")
	public void testnbdecolonnes0() throws Exception{
		Dataframe data = new Dataframe( new String[]{} );
		assertEquals( 0, data.nbColonnes());
	}
	
	@Test
	@DisplayName("nb de colonnes :")
	public void testnbdecolonnesCSV() throws Exception{
		Dataframe data = new Dataframe( "csv/vide.csv");
		assertEquals( 0, data.nbColonnes());
	}
	
	@Test
	@DisplayName("test selection colonnes")
	public void testSelectionColonnes() throws Exception{
		Dataframe d = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		Dataframe d2 = d.selectLabels("nom","poids");
		assertEquals( 2, d2.nbColonnes());
		assertEquals( 5, d2.nbLignes());
	}
	
	@Test
	@DisplayName("test selection lignes")
	public void testSelectionlignes() throws Exception{
		Dataframe d = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		Dataframe d2 = d.selectLignes(0,2);
		assertEquals( 3, d2.nbColonnes());
		assertEquals( 2, d2.nbLignes());
	}
	
	@Test
	@DisplayName("test selection lignes index invalide")
	public void testSelectionErrorIndex1() throws Exception{
		Dataframe d = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		assertThrows(IndexError.class, () -> {
			Dataframe d2 = d.selectLignes(-1);
	    });
	}
	
	@Test
	@DisplayName("test selection lignes index invalide")
	public void testSelectionErrorIndex2() throws Exception{
		Dataframe d = new Dataframe( new String[]{"numero","nom", "poids"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"loup","chien","chat","poule","renard"} , (Object[]) new Double[]{17.1,45.5,87.6,45.6,13.8} );
		assertThrows(IndexError.class, () -> {
			Dataframe d2 = d.selectLignes(5);
	    });
	}
}
