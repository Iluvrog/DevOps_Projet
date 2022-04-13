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
			if(labels.length != tabs.length)
				throw new DimensionError("numbers of colums don't match with the size of labels");
			colonnes = new Colonne[labels.length];
			for(int i = 0; i < tabs.length ; i++){
				if(tabs[i].length != nb_lignes)
					throw new DimensionError();
				Colonne c = new Colonne(nb_lignes, labels[i]);
				for(int j = 0; j < tabs[i].length ; j++){
					c.add(j,tabs[i][j]);
				}
				colonnes[i] = c;
			}
		}
	}
	
	public Dataframe(String file) throws DimensionError{
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String splitBy = ",";
			String[] labels = null;
			int nb_collones = 0;
			int n = -1;
			while ((line = br.readLine()) != null){
				String[] str = line.split(splitBy);
				if(n == -1){
					nb_collones = str.length;
					colonnes = new Colonne[nb_collones];
					labels = str;
				}else{
					if(n == 0)
						nb_lignes = str.length;
					else if(str.length != nb_lignes)
						throw new DimensionError();
					Colonne c = new Colonne(nb_lignes, labels[n]);
					for(int j = 0; j < nb_lignes ; j++){
						c.add(j,str[j]);
					}
					colonnes[n] = c;
				}
				n++;
			}
			nb_lignes = n;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
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
		System.out.println();
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
		System.out.println();
		for (int i = n; i < nb_lignes; i++){
			System.out.print(i+"\t");
			for (int j = 0; j < nb_colonnes; j++){
				System.out.print(colonnes[j].get(i));
				for (int k = 0; k < M - colonnes[j].get(i).toString().length() + 3; k++) System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
	
	private boolean isinLabels(String[] labels, String test){
		for (String l : labels)
			if (l.equals(test)) return true;
			
		return false;
	}
	
	public Dataframe selectLabels(String... labels) throws DimensionError{
		Dataframe copie = null;
		
		copie = new Dataframe(new String[]{"nothing"} ,(Object[]) new Integer[]{0});
		copie.nb_lignes = nb_lignes;
	
		copie.colonnes = new Colonne[labels.length];
		int index = 0;
			
		for (int i = 0; i < colonnes.length; i++){
			if (isinLabels(labels, colonnes[i].getLabel())){
				copie.colonnes[index] = colonnes[i].clone();
				index++;
			}
		}

		return copie;
	}
	
	public Dataframe selectLignes(int... indexs) throws IndexError{
		return null;
	}
	
	public static void main(String[] args) throws DimensionError{
		Dataframe d = new Dataframe(new String[]{"n","name"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"a","c","agt","er","rtyu"});
		d.print();
		System.out.println("\n\n");
		try{
			d.selectLabels("name").print();
		} catch(Exception ignored){}
	}
}
