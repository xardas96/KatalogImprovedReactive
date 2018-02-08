package romanovsky.katalogimprovedreactive.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Saves")
public class Save {

    @Column(name = "saveID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "zipPath", nullable = false)
    private String zipPath;

    @Column(name = "gameYear")
    private Date gameYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeID")
    private Entry game;

}
