
public class Main {

	public static void main(String[] args) {

		TaxisokRepository tr = new TaxisokRepository();
		tr.fileBeolvas();
		
		System.out.println("3. feladat: "+ tr.getUtazasokSzama());
		tr.bevetelPluszFuvar();
		tr.fizetesiModok();

	}

}
