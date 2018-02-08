package romanovsky.katalogimprovedreactive.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Containers")
@RequiredArgsConstructor
@NoArgsConstructor
public class Container {

    @Column(name = "containerID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeID")
    @NonNull
    private ContainerType type;

    @Column(name = "containerName", nullable = false, unique = true)
    @NonNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "container", fetch = FetchType.EAGER)
    private List<Disk> disks;

    public List<Disk> getDisks() {
        return disks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equal(id, container.id) &&
                Objects.equal(name, container.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
