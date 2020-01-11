import java.time.LocalDateTime;
import java.util.Date;

public class Taxi {

	private int azonosito;	
	private LocalDateTime indulasiIdo;
	private int utazasIdotartam;
	private Double tavolsag;
	private Double viteldij;
	private Double borravalo;
	private String fizetesiMod;
	
	public Taxi(int azonosito, LocalDateTime indulasiIdo, int utazasIdotartam, Double tavolsag, Double viteldij,
			Double borravalo, String fizetesiMod) {
		super();
		this.azonosito = azonosito;
		this.indulasiIdo = indulasiIdo;
		this.utazasIdotartam = utazasIdotartam;
		this.tavolsag = tavolsag;
		this.viteldij = viteldij;
		this.borravalo = borravalo;
		this.fizetesiMod = fizetesiMod;
	}

	public int getAzonosito() {
		return azonosito;
	}

	public void setAzonosito(int azonosito) {
		this.azonosito = azonosito;
	}

	public Date getIndulasiIdo() {
		return indulasiIdo;
	}

	public void setIndulasiIdo(Date indulasiIdo) {
		this.indulasiIdo = indulasiIdo;
	}

	public int getUtazasIdotartam() {
		return utazasIdotartam;
	}

	public void setUtazasIdotartam(int utazasIdotartam) {
		this.utazasIdotartam = utazasIdotartam;
	}

	public Double getTavolsag() {
		return tavolsag;
	}

	public void setTavolsag(Double tavolsag) {
		this.tavolsag = tavolsag;
	}

	public Double getViteldij() {
		return viteldij;
	}

	public void setViteldij(Double viteldij) {
		this.viteldij = viteldij;
	}

	public Double getBorravalo() {
		return borravalo;
	}

	public void setBorravalo(Double borravalo) {
		this.borravalo = borravalo;
	}

	public String getFizetesiMod() {
		return fizetesiMod;
	}

	public void setFizetesiMod(String fizetesiMod) {
		this.fizetesiMod = fizetesiMod;
	}
	
	
	
	
	
	
}
