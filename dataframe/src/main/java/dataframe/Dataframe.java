package dataframe;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dataframe {
	
	private ArrayList<ArrayList<Object>> collones;
	private ArrayList<String> label;
	private int nb_lignes;

	public Dataframe(String[] labels, Object[]... tabs){
		if(tabs.length != 0){
			nb_lignes = tabs[0].length;
			
			label = new ArrayList<String>();
			for(int i = 0; i < labels.length ; i++){
					label.add(labels[i]);
			}
				
			collones = new ArrayList<ArrayList<Object>>();
			for(int i = 0; i < tabs.length ; i++){
				ArrayList<Object> l = new ArrayList<Object>();
				for(int j = 0; j < tabs[i].length ; j++){
					l.add(tabs[i][j]);
				}
				collones.add(l);
			}
		}
	}
	
	public Dataframe(String file){
		try {
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
		}
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
