package ma.crud.crudangularspringboot.model;

import jakarta.persistence.*;
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", urlImage='" + urlImage + '\'' +
                ", partType='" + partType + '\'' +
                ", quantity=" + quantity +
                ", qeerebyasali=" + qeerebyasali +
                ", description='" + description + '\'' +
                ", urlImagetanya='" + urlImagetanya + '\'' +
                ", promo=" + promo +
                '}';
    }

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "parttype")
    private String partType;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "qeerebyasali")
    private boolean qeerebyasali;

    @Column(name = "description")
    private String description;

    @Column(name = "url_imagetanya")
    private String urlImagetanya;
    @Column(name = "promo")

    private boolean promo;

    // Constructors
    public Product() {
    }



    public Product(String name, double price, String urlImage, String partType, double quantity, boolean qeerebyasali, String description, String urlImagetanya,boolean promo) {
        this.name = name;
        this.price = price;
        this.urlImage = urlImage;
        this.partType = partType;
        this.quantity = quantity;
        this.qeerebyasali = qeerebyasali;
        this.description = description;
        this.urlImagetanya = urlImagetanya;
        this.promo=promo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
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

    public String getUrlImagetanya() {
        return urlImagetanya;
    }

    public void setUrlImagetanya(String urlImagetanya) {
        this.urlImagetanya = urlImagetanya;
    }
}