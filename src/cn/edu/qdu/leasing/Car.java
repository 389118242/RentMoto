package cn.edu.qdu.leasing;

public class Car extends Moto {
	private String type;

	public Car(String type, String numPlate) {
		super(numPlate);
		this.type = type;
	}

	@Override
	public double totalRental(int leaseDays) {
		if ("±¼³Û".equals(type)) {
			setDailyRental(600);
		} else if ("±¦Âí".equals(type)) {
			setDailyRental(500);
		} else {
			setDailyRental(300);
		}
		return super.totalRental(leaseDays);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
