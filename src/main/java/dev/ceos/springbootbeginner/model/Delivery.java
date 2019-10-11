package dev.ceos.springbootbeginner.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Delivery
{

    private @Id @GeneratedValue Long id;
    private @Column @Lob String address;
    private @Column String orderer;
    private @Column String menu;

    private @CreatedDate @Column Date createdAt;
    private @CreatedDate @Column Date updatedAt;

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
}
