package romanovsky.katalogimprovedreactive.model;

import javax.persistence.*;

@Entity
@Table(name = "DiskTypes")
public class DiskType {

    @Column(name = "typeID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "typeName", nullable = false, unique = true)
    private String name;

}
