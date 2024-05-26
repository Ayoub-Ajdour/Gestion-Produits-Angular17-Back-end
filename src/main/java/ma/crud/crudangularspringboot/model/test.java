package ma.crud.crudangularspringboot.model;

import jakarta.persistence.Column;

public class test {
    private String name;

    @Override
    public String toString() {
        return "test{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url_image='" + url_image + '\'' +
                ", parttype='" + parttype + '\'' +
                ", quantity=" + quantity +
                ", qeerebyasali=" + qeerebyasali +
                ", description='" + description + '\'' +
                ", url_imagetanya='" + url_imagetanya + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getParttype() {
        return parttype;
    }

    public void setParttype(String parttype) {
        this.parttype = parttype;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isQeerebyasali() {
        return qeerebyasali;
    }

    public void setQeerebyasali(boolean qeerebyasali) {
        this.qeerebyasali = qeerebyasali;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_imagetanya() {
        return url_imagetanya;
    }

    public void setUrl_imagetanya(String url_imagetanya) {
        this.url_imagetanya = url_imagetanya;
    }

    public test(String name, double price, String url_image, String parttype, double quantity, boolean qeerebyasali, String description, String url_imagetanya) {
        this.name = name;
        this.price = price;
        this.url_image = url_image;
        this.parttype = parttype;
        this.quantity = quantity;
        this.qeerebyasali = qeerebyasali;
        this.description = description;
        this.url_imagetanya = url_imagetanya;
    }

    private double price;

    private String url_image;

    private String parttype; // Change _parttype to parttype

    private double quantity; // Change _quantity to quantity

    private boolean qeerebyasali; // Change _qeerebyasali to qeerebyasali


    private String description; // Change _description to description

    private String url_imagetanya;
}
