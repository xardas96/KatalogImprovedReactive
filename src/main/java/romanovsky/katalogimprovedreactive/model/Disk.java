package romanovsky.katalogimprovedreactive.model;

import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "Disks")
public class Disk {

    @Column(name = "diskID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "containerID")
    private Container container;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diskType")
    private DiskType diskType;

    @Column(name = "diskInContainerID")
    @NonNull
    private Integer diskInContainerId;

    @Column(name = "diskInContainerGlobalID")
    @NonNull
    private Integer diskInContainerGlobalId;

    @Column(name = "description")
    @NonNull
    private String description;

}