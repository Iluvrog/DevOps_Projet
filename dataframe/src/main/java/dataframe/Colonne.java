package dataframe;

public class Colonne<E>{

	private E[] datas;
	private String label;
	
	public Colonne(int n, String name){
		label = name;
		datas = (E[]) new Object[n];
	}
	
	public void add(int index, E elt){
		datas[index] = elt;
	}
	
	public E get(int index){
		return datas[index];
	}
	
	public String getLabel(){
		return label;
	}
}
