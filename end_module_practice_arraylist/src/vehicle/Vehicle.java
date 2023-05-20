package vehicle;

import java.io.Serializable;
import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle>,Serializable {
//	chasisNo(string) : Unique ID, color(enum) , netPrice(double) ,
//	 * manufactureDate(LocalDate),company,isAvailable
//	 */
	private String chasisNo;
	Color color;
	private  double netPrice;
	LocalDate MfgDate;
	private String company;
	private boolean isAvailable;
	
	public Vehicle(String chasisNo, Color color, double netPrice, LocalDate mfgDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.color = color;
		this.netPrice = netPrice;
		MfgDate = mfgDate;
		this.company = company;
		this.isAvailable = true;
	}
	
	public Vehicle(String chasisNo) {
		super();
		this.chasisNo = chasisNo;
	}

	public String getChasisNo() {
		return chasisNo;
		}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	public LocalDate getMfgDate() {
		return MfgDate;
	}
	public void setMfgDate(LocalDate mfgDate) {
		MfgDate = mfgDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", color=" + color + ", netPrice=" + netPrice + ", MfgDate=" + MfgDate
				+ ", company=" + company + ", isAvailable=" + isAvailable + "]";
	} 
	
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in equals method");
		if(o instanceof Vehicle)
		return this.chasisNo.equals(((Vehicle) o).chasisNo);
		return false;
	}

	@Override
	public int compareTo(Vehicle v) {
		System.out.println("in vehicle compare-to");
		return this.chasisNo.compareTo(v.chasisNo);
	}
	

}
