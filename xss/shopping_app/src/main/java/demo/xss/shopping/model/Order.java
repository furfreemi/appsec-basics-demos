package demo.xss.shopping.model;

public class Order {
    private String name;
    private String address;
    private String creditCardNumber;
    private String amount;

    public Order(String name, String address, String creditCardNumber, String amount) {
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.amount = amount;
    }

    public Order() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
