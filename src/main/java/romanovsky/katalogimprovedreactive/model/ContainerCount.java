package romanovsky.katalogimprovedreactive.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

//TODO remove this and the updating trigger from the database and count it ad-hoc
@Entity
@Table(name = "ContainerCounts")
public class ContainerCount {

    @Id
    @PrimaryKeyJoinColumn(name = "containerTypeID", referencedColumnName = "containerTypeID")
    private Integer containerTypeId;

    @Column(name = "diskCount", nullable = false)
    private Integer diskCount;

    public Integer getContainerTypeId() {
        return containerTypeId;
    }

    public Integer getDiskCount() {
        return diskCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerCount that = (ContainerCount) o;
        return Objects.equal(containerTypeId, that.containerTypeId) &&
                Objects.equal(diskCount, that.diskCount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(containerTypeId, diskCount);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("containerTypeId", containerTypeId)
                .add("diskCount", diskCount)
                .toString();
    }
}
