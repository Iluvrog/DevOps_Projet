package dataframe;

public class DimensionError extends Exception {
	public DimensionError(){
		super();
	}
	
	public DimensionError(String mes){
		super(mes);
	}
}
