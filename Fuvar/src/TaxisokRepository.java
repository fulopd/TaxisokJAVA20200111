import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


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
	
}
