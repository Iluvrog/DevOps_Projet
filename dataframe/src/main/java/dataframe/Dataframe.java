package dataframe;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dataframe {
	
	private Colonne[] colonnes;
	private int nb_lignes;

	public Dataframe(String[] labels, Object[]... tabs) throws DimensionError{
		if(tabs.length != 0){
			nb_lignes = tabs[0].length;
			if(labels.length != nb_lignes)
				throw new DimensionError();
			colonnes = new Colonne[nb_lignes];
			for(int i = 0; i < tabs.length ; i++){
				if(tabs[i].length != nb_lignes)
					throw new DimensionError();
				Colonne c = new Colonne(nb_lignes, labels[i]);
				for(int j = 0; j < tabs[i].length ; j++){
					c.add(j,tabs[i][j]);
				}
			}
		}
	}
	
	public Dataframe(String file){
		/*try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String splitBy = ",";
			
			int n = -1;
			while ((line = br.readLine()) != null){
				String[] str = line.split(splitBy);
				if(n == -1){
					label = new ArrayList<String>();
					collones = new ArrayList<ArrayList<Object>>();
					for(int i = 0; i < str.length ; i++){
						label.add(str[i]);
					}
				}else{
					ArrayList<Object> l = new ArrayList<Object>();
					for(int i = 0; i < str.length ; i++){
						//l.add();
					}
					collones.add(l);
				}
				n++;
			}
			nb_lignes = n;
		}
		catch(IOException e) {
			e.printStackTrace();
		}*/
	}
	
	private int maxStringSize(){
		int m = -1;
		int m2;
		for (int i = 0; i < nb_lignes; i++){
			for (int j = 0; j < colonnes.length; j++){
				m2 = colonnes[j].get(i).toString().length();
				if (m2 > m) m = m2;
			}
		}
		for (int j = 0; j < colonnes.length; j++){
			String label = colonnes[j].getLabel();
			m2 = label.length();
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
	
		int nb_colonnes = colonnes.length;
		System.out.print("\t");
		
		for (int i = 0; i < nb_colonnes; i++){
			System.out.print(colonnes[i].getLabel());
			for (int k = 0; k < M - colonnes[i].getLabel().length() + 3; k++) System.out.print(" ");
		}
		
		for (int i = 0; i < n; i++){
			System.out.print(i+"\t");
			for (int j = 0; j < nb_colonnes; j++){
				System.out.print(colonnes[j].get(i));
				for (int k = 0; k < M - colonnes[j].get(i).toString().length() + 3; k++) System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
	
	public void printLastLines(int n){
		
		if ( n > nb_lignes) n = nb_lignes;
		
		n = nb_lignes - n;
		
		int M = maxStringSize();
	
		int nb_colonnes = colonnes.length;
		System.out.print("\t\t");
		
		for (int i = 0; i < nb_colonnes; i++){
			System.out.print(colonnes[i].getLabel());
			for (int k = 0; k < M - colonnes[i].getLabel().length() + 3; k++) System.out.print(" ");
		}
		
		for (int i = n; i < nb_lignes; i++){
			System.out.print(i+"\t");
			for (int j = 0; j < nb_colonnes; j++){
				System.out.print(colonnes[j].get(i));
				for (int k = 0; k < M - colonnes[j].get(i).toString().length() + 3; k++) System.out.print(" ");
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
