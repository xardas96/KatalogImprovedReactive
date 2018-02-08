package romanovsky.katalogimprovedreactive.service;

import romanovsky.katalogimprovedreactive.model.ContainerType;

import java.util.Map;

public interface ContainerCountService {

    Map<ContainerType, Integer> getContainerDiskCount();

    default long getContainerDiskCountSum() {
        return getContainerDiskCount().values().stream().mapToLong(i -> i).sum();
    }

}
