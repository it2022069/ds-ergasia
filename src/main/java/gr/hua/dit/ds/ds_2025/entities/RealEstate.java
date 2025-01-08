package gr.hua.dit.ds.ds_2025.entities;

import jakarta.persistence.*;

@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    String address;

    @Column
    String description;

    @Column
    Integer price;

    public RealEstate(String address, String description, Integer price) {
        this.address = address;
        this.description = description;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
