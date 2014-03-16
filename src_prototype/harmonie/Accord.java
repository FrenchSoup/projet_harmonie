package harmonie;

public abstract class Accord {
	
	private int soprano;
	private int alto;
	private int basse;
	private int tenor;
	private int duree;
	public int getDuree() {
		return duree;
	}
	public int getSoprano() {
		return soprano;
	}
	public int getAlto() {
		return alto;
	}
	public int getBasse() {
		return basse;
	}
	public int getTenor() {
		return tenor;
	}
	
	public Accord(int s, int a, int t, int b, int d){
		soprano=s;
		alto=a;
		tenor=t;
		basse=b;
		duree=d;
	}
	
	public boolean verifAccord(Accord a){
		return verifAccordLocal() && verifAccordEnchainement(a);
	}
	private boolean verifAccordLocal(){
		return Regle.verifNote(this);
	}
	private boolean verifAccordEnchainement(Accord a){
		return Regle.enchainementCorrect(this, a);
	}
}
