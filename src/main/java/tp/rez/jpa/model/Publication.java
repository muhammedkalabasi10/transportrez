package tp.rez.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String from_addr;
    private String to_addr;
    private Date created_date;
    private String cargo_type;
    private float total_price;
    private Date transported_date;
    private int user_id;
    private int transporter_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transporter_id")
    private Transporter transporter;

    public Publication(String from_addr, String to_addr, Date created_date, String cargo_type, float total_price, int user_id) {
        this.from_addr = from_addr;
        this.to_addr = to_addr;
        this.created_date = created_date;
        this.cargo_type = cargo_type;
        this.total_price = total_price;
        this.user_id = user_id;
    }
}
