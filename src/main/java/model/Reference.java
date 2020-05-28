package model;

public class Reference {

    private String numReference;
    private String type;
    private String size;
    private String price;

    public Reference(String numReference, String color, String size, String price) {
        this.numReference = numReference;
        this.type = color;
        this.size = size;
        this.price = price;
    }

    public String getNumReference() {
        return numReference;
    }

    public void setNumReference(String numReference) {
        this.numReference = numReference;
    }

    public String getColor() {
        return type;
    }

    public void setColor(String color) {
        this.type = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
