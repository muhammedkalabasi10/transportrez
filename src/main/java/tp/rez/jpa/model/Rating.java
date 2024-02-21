package tp.rez.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 0, message = "Score must be at least 0")
    @Max(value = 10, message = "Score must be at most 10")
    private short score;

    private String comment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commenter_id")
    private User commenter_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commented_id")
    private Transporter commented_id;

    public Rating(int id, short score, User commenter_id, Transporter commented_id) {
        this.id = id;
        this.score = score;
        this.commenter_id = commenter_id;
        this.commented_id = commented_id;
    }

    public Rating(short score, String comment, User commenter_id, Transporter commented_id) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.commenter_id = commenter_id;
        this.commented_id = commented_id;
    }
}
