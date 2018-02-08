package romanovsky.katalogimprovedreactive.model;

import javax.persistence.*;

@Entity
@Table(name = "Entries")
public class Entry {

    @Column(name = "entryID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @Column(name = "coverPath")
    private String coverPath;

}
