package com.dpenny.mcda5510.entity;

public class Transaction {

	private int ID;
	private String nameOnCard;
	private String cardNumber;
	private float UnitPrice;
	private int Quantity;
	private float TotalPrice;
	private String ExpDate;
	private String CreatedOn;
	private String CreatedBy;
	private String CreditType;

	// Below are getter and setter methods for ID, Name_On_Card, Card_Number, UnitPrice,
	// Quantity, Total_Price, Expiration_Date, Created_On, Created_By, & Credit_Type.

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float UnitPrice) {
		this.UnitPrice = UnitPrice;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	public float getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(float TotalPrice) {
		this.TotalPrice = TotalPrice;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public void setExpDate(String ExpDate) {
		this.ExpDate = ExpDate;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(String CreatedOn) {
		this.CreatedOn = CreatedOn;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = CreatedBy;
	}

	public String getCreditType() {
		return CreditType;
	}

	public void setCreditType(String CreditType) {
		this.CreditType = CreditType;
	}

	// toString method to return the concatenated results
	public String toString() {

		String results = new String();

		results = "[ID: " + ID + ",NameOnCard: " + nameOnCard + ",CardNumber: " + cardNumber + ",UnitPrice: "
				+ UnitPrice + ",Quantity: " + Quantity + ",TotalPrice: " + TotalPrice + ",ExpDate: " + ExpDate
				+ ",CreatedOn: " + CreatedOn + ",CreatedBy: " + CreatedBy + ",CreditType: " + CreditType + "]";
		return results;

	}

}
