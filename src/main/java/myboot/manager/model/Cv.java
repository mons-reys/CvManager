package myboot.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cv", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Activity> activities;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tutorial_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;
    
}