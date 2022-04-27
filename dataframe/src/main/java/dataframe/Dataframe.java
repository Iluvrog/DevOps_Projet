import java.util.ArrayList;

import java.io.*;

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
			int n = -1;
			nb_lignes = countLinesOld(file) - 1;
			int nbcolonnes = 0;
			while ((line = br.readLine()) != null){
				String[] str = line.split(splitBy);
				if(n == -1){
					String[] label = str;
					nbcolonnes = str.length;
					colonnes = new Colonne[nbcolonnes];
					for(int i = 0; i < nbcolonnes ; i++){
						colonnes[i] = new Colonne(nb_lignes, label[i]);
					}	
					n = 0;
				}else{
					if(str.length != nbcolonnes)
						throw new DimensionError();
					for(int j = 0; j < nbcolonnes ; j++){
						colonnes[j].add(n,type(str[j]));
					}
					n++;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int countLinesOld(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
		byte[] c = new byte[1024];
		int count = 0;
		int readChars = 0;
		boolean empty = true;
		while ((readChars = is.read(c)) != -1) {
		empty = false;
		for (int i = 0; i < readChars; ++i) {
		if (c[i] == '\n') {
		++count;
		}
		}
		}
		return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
	
	public Object type(String arg){
		int entier = 0;
		int i = 0;
		while(i != arg.length()){
			char a = arg.charAt(i);
			if(a == '.'){
				entier++;
			}
			else if (a > 39 || a < 30){ //string
				return arg;
			}
			i++;
		}
		if(entier == 0){
			return Integer.parseInt(arg);
		}else if(entier == 1){
			return Double.parseDouble(arg);
		}else{
			return arg;
		}
  }
  
	private Dataframe(){
		colonnes = new Colonne[0];
		nb_lignes = 0;
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
		
		copie = new Dataframe();
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
		Dataframe d;
		if(args.length == 0)
			d = new Dataframe(new String[]{"n","name"} ,(Object[]) new Integer[]{12,15,14,13,1} ,(Object[]) new String[]{"a","c","agt","er","rtyu"});
		else
			d = new Dataframe(args[0]);
		d.print();
		System.out.println("\n\n");
		try{
			//d.selectLabels("name", "ratio").print();
		} catch(Exception ignored){}
	}
}
