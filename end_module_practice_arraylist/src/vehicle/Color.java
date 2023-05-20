package vehicle;

public enum Color {
	WHITE(5000),RED(6000),GREY(4500),BLACK(7000);
	
	private double price;
	
	private Color(double price)
	{
	this.price=price;	
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
