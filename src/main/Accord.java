package main;


import java.util.ArrayList;

public class Accord implements Cloneable{
	
	public int soprano;
	public int alto;
	public int basse;
	public int tenor;
	public int duree;
	private Accord pere;
	public int beaute;
	private ArrayList<Accord> jeuxSuivants;
	public int type;
		
	public void setJeuxSuivants(ArrayList<Accord> jeuxSuivants) {
		this.jeuxSuivants = jeuxSuivants;
	}
	
	public void addSuivant(Accord a){
		this.jeuxSuivants.add(a);
	}
	public ArrayList<Accord> getJeuxSuivants() {
		return jeuxSuivants;
	}
	
	public Accord(int s, int a, int t, int b, int d,int c){
		soprano=s;
		alto=a;
		tenor=t;
		basse=b;
		duree=d;
		type=c;
		jeuxSuivants=new ArrayList<Accord>();
	}
	public Accord(){
		jeuxSuivants=new ArrayList<Accord>();
	}

	public boolean equals(Accord ac){
		if(this.soprano==ac.soprano)
			if(this.alto==ac.alto)
				if(this.tenor==ac.tenor)
					if(this.basse==ac.basse)
						if(this.duree==ac.duree)
							return true;
	return false;
	}
	
	public Accord clone(){
		Accord ac = new Accord();
		ac.soprano=this.soprano;
		ac.alto=this.alto;
		ac.tenor=this.tenor;
		ac.basse=this.basse;
		ac.duree=this.duree;
		ac.type=this.type;
		return ac;
		
	}
	
	public Accord getPere() {
		return pere;
	}
	public void setPere(Accord pere) {
		this.pere = pere;
	}
	public int getBeaute() {
		return beaute;
	}
	public void setBeaute(int beaute) {
		this.beaute = beaute;
	}
	
	public int getTonic(){
		int a = this.type;
		if(a==7){
			a=3;
		}
		return a;
	}
	/*public boolean verifAccord(Accord a){
		return verifAccordLocal() && verifAccordEnchainement(a);
	}
	private boolean verifAccordLocal(){
		return Regle.verifNote(this);
	}
	private boolean verifAccordEnchainement(a){
		
	}*/
}