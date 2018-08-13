package repositories.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import static constants.Constants.SCHEMA_NAME;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "FEEDBACK", schema = SCHEMA_NAME)
public class Feedback implements Serializable {

    private static final long serialVersionUID = 534429778355458486L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "USER_COMMENT")
    private String user_comment;

    public Feedback() {
    }

    public Feedback(String user_comment) {
        this.user_comment = user_comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
