package dev.ceos.springbootbeginner.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Delivery
{
    @Id @GeneratedValue
    private Long id;
    @Column @Lob
    private String address;
    @Column
    private String orderer;
    @Column
    private String menu;
    @CreatedDate @Column
    private Date createdAt;
    @CreatedDate @Column
    private Date updatedAt;

    Delivery() { }

    public Delivery(String address, String orderer, String menu)
    {
        this.address = address;
        this.orderer = orderer;
        this.menu = menu;
    }
    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", orderer=" + orderer + '\'' +
                ", menu=" + menu + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void updateAddress(String address) {
        this.address = address;
    }
    public void updateId(Long id) {
        this.id = id;
    }
}
