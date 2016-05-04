package cn.edu.qdu.leasing;

public class Bus extends Moto {
	private int seatsCount;

	public Bus(int seatsCount, String numPlate) {
		super(numPlate);
		this.seatsCount = seatsCount;
	}
	
	@Override
	public double totalRental(int leaseDays) {
		if(seatsCount>16){
			setDailyRental(1500);
		}else {
			setDailyRental(800);
		}
		return super.totalRental(leaseDays);
	}

	public int getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}

	
}
