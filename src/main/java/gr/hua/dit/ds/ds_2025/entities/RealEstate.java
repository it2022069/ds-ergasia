package gr.hua.dit.ds.ds_2025.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @NotEmpty(message = "City is required")
    @Size(min = 3, max = 50)
    @Column
    String city;

    @NotEmpty(message = "Address is required")
    @Size(min = 3, max = 50)
    @Column
    String address;

    @Column
    String category;

    @Column
    String description;

    @NotNull(message = "Size is required")
    @Positive(message = "Size must be a positive number")
    @Column
    Integer size;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive number")
    @Column
    Integer price;

    @Column
    Boolean rented=false;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public RealEstate(String city, String address, String category, String description, Integer size, Integer price) {
        this.city = city;
        this.address = address;
        this.category = category;
        this.description = description;
        this.size = size;
        this.price = price;
    }

    public RealEstate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", rented=" + rented +
                '}';
    }
}