package dto;

public class item {
	String ID, Name, Description,IMG;
	float Price;
	int Quantity;
		
	public item(String iD, String name, String description, int quantity, float price, String iMG) {
		super();
		ID = iD;
		Name = name;
		Description = description;
		Quantity = quantity;
		Price = price;
		IMG = iMG;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "item [ID=" + ID + ", Name=" + Name + ", Description=" + Description + ", IMG=" + IMG + ", Price="
				+ Price + ", Quantity=" + Quantity + "]";
	}
	
	

}
