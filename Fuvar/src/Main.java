
public class Main {

	public static void main(String[] args) {

		TaxisokRepository tr = new TaxisokRepository();
		tr.fileBeolvas();
		
		System.out.println("3. feladat: "+ tr.getUtazasokSzama());
		tr.bevetelPluszFuvar();
		System.out.println("5. Felada:"); tr.fizetesiModok();		
		System.out.println("6. Felada: "+Math.round(tr.megtettKilometer() * 100.0) / 100.0);
		tr.leghosszabb();
	}

}
