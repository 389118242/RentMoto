package cn.edu.qdu.leasing;

public class Moto {
	private String numPlate;
	private double dailyRental;
	
	public Moto(String numPlate){
		this.numPlate=numPlate;
	}
	
	public double totalRental(int leaseDays){
		return leaseDays*dailyRental;
	}

	public String getNumPlate() {
		return numPlate;
	}

	public void setNumPlate(String numPlate) {
		this.numPlate = numPlate;
	}

	public double getDailyRental() {
		return dailyRental;
	}

	public void setDailyRental(double dailyRental) {
		this.dailyRental = dailyRental;
	}
	
}
