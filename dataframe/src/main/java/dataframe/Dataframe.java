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
	
	private int maxStringSize(){
		int m = -1;
		int m2;
		for (int i = 0; i < nb_lignes; i++){
			for (int j = 0; j < collones.size(); j++){
				m2 = collones.get(j).get(i).toString().length();
				if (m2 > m) m = m2;
			}
		}
		for (String l : label){
			m2 = l.length();
			if (m2 > m) m = m2;
		}
		return m;
	}
	
	public void print(){
	
		printFirstLignes(nb_lignes);
	
	}
	
	public void printFirstLignes(int n){
	
		if ( n > nb_lignes) n = nb_lignes;
		
		int M = maxStringSize();
	
		int nb_colonnes = label.size();
		System.out.print("\t");
		
		for (int i = 0; i < label.size(); i++){
			System.out.print(label.get(i));
			for (int k = 0; k < M - label.get(i).length() + 3; k++) System.out.print(" ");
		}
		
		for (int i = 0; i < n; i++){
			System.out.print(i+"\t");
			for (int j = 0; j < collones.size(); j++){
				System.out.print(collones.get(j).get(i));
				for (int k = 0; k < M - collones.get(j).get(i).toString().length() + 3; k++) System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
	
	public void printLastLines(int n){
		
		if ( n > nb_lignes) n = nb_lignes;
		
		n = nb_lignes - n;
		
		int M = maxStringSize();
	
		int nb_colonnes = label.size();
		System.out.print("\t\t");
		
		for (int i = 0; i < label.size(); i++){
			System.out.print(label.get(i));
			for (int k = 0; k < M - label.get(i).length() + 3; k++) System.out.print(" ");
		}
		
		for (int i = n; i < nb_lignes; i++){
			System.out.print(i+"\t");
			for (int j = 0; j < collones.size(); j++){
				System.out.print(collones.get(j).get(i));
				for (int k = 0; k < M - collones.get(j).get(i).toString().length() + 3; k++) System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
	
	public Dataframe selectLabels(String... labels) throws IndexError{
		return null;
	}
	
	public Dataframe selectLignes(int... indexs) throws IndexError{
		return null;
	}
}
