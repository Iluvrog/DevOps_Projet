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
	
	public Colonne clone(){
		Colonne copie = new Colonne(datas.length, label);
		for (int i = 0; i < datas.length; i++) {
			copie.add(i, get(i));
		}
		return copie;
	}
}
