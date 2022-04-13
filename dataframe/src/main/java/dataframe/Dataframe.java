package dataframe;

import java.util.ArrayList;

public class Dataframe {
	
	private ArrayList<ArrayList<Object>> collones;
	private ArrayList<String> label;
	private int nb_lignes;

	public Dataframe(Object[]... tabs){
		
	}
	
	public Dataframe(String file){
		
	}
	
	public void print(){
	
	}
	
	public void printFirstLignes(int n){
	
	}
	
	public void printLastLines(int n){
	
	}
	
	public Dataframe selectLabels(String... labels) throws IndexError{
		return null;
	}
	
	public Dataframe selectLignes(int... indexs) throws IndexError{
		return null;
	}
}
