package romanovsky.katalogimprovedreactive.model;

import javax.persistence.*;

//TODO remove this and the updating trigger from the database and count it ad-hoc
@Entity
@Table(name = "DiskCounts")
public class DiskCount {

    @Id
    @PrimaryKeyJoinColumn(name = "containerID", referencedColumnName = "containerID")
    private Integer containerId;

    @Column(name = "diskCount", nullable = false)
    private Integer diskCount;

}