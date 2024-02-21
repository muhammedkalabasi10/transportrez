package tp.rez.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private boolean verification;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commenter_id", cascade = CascadeType.ALL)
    private List<Rating> ratingList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Publication> publicationList;
    public User(String name, String surname, String phone, String address, String email, boolean verification) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.verification = verification;
    }
}
