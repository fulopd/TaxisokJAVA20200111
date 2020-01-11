import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class TaxisokRepository {

	private List<Taxi> Taxisok;

	public TaxisokRepository() {
		Taxisok = new ArrayList<>();
	}
	
	public void fileBeolvas() {
		
		String elsosor;
		
		try {
			List<String> sorok =  Files.readAllLines(Paths.get("fuvar.csv"));
			elsosor = sorok.get(0);
			
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] adat = sor.split(";");
				
				Taxi t;
					try {
						t = new Taxi(
								Integer.parseInt(adat[0]), 
								LocalDateTime.parse(adat[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
								Integer.parseInt(adat[2]), 
								Double.parseDouble(adat[3].replace(',', '.')), 
								Double.parseDouble(adat[4].replace(',', '.')), 
								Double.parseDouble(adat[5].replace(',', '.')), 
								adat[6]);
						Taxisok.add(t);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	
	public int getUtazasokSzama() {		
		return Taxisok.size();
	}
	
	public void bevetelPluszFuvar() {
		Double bevetel = 0.0;
		int fuvar = 0;
		for (Taxi taxi : Taxisok) {
			
			if (taxi.getAzonosito() == 6185) {
				bevetel += taxi.getViteldij();
				fuvar++;
			}
			
		}
		
		System.out.println("4. feladat: "+ fuvar + " fuvar alatt: " + bevetel);
	}

	public void fizetesiModok() {
		
		TreeMap<String, Integer> tree_map = new TreeMap<String, Integer>(); 
		
		for (Taxi taxi : Taxisok) {
			tree_map.merge(taxi.getFizetesiMod(), 1, Integer::sum);
		}
				
		for(Map.Entry<String,Integer> entry : tree_map.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();

			  System.out.println(key + " => " + value);
			}
	}
			
	public double megtettKilometer() {
		double km = 0.0;
		
		for (Taxi taxi : Taxisok) {
			km += taxi.getTavolsag();
		}
		
		return km * 1.6;
	}

	public void leghosszabb() {
		
		Taxi t = Collections.max(Taxisok, Comparator.comparing(x -> x.getUtazasIdotartam()));
		System.out.println("7. feladat: " + t.getUtazasIdotartam());
	}
}
