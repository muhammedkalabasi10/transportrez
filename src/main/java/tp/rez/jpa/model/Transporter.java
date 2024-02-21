package tp.rez.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Transporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;
    private byte[] car_licence;
    private String car_details;
    private float unit_price;
    private boolean verification;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commented_id", cascade = CascadeType.ALL)
    private List<Rating> ratingList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transporter_id", cascade = CascadeType.ALL)
    private List<Publication> publicationList;

    //without car details
    public Transporter(String name, String surname, String phone, String email, String address, byte[] car_licence, float unit_price, boolean verification) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.car_licence = car_licence;
        this.unit_price = unit_price;
        this.verification = verification;
    }

    //with car details
    public Transporter(String name, String surname, String phone, String email, String address, byte[] car_licence, String car_details, float unit_price, boolean verification) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.car_licence = car_licence;
        this.car_details = car_details;
        this.unit_price = unit_price;
        this.verification = verification;
    }
}
