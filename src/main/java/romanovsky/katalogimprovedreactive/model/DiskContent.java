package romanovsky.katalogimprovedreactive.model;

import javax.persistence.*;

@Entity
@Table(name = "DiskContents")
public class DiskContent {

    @Column(name = "contentID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entryID")
    private Entry entry;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diskID")
    private Disk disk;

}
