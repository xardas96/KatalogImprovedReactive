package romanovsky.katalogimprovedreactive.service.impl;

import com.google.common.collect.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romanovsky.katalogimprovedreactive.model.ContainerCount;
import romanovsky.katalogimprovedreactive.model.ContainerType;
import romanovsky.katalogimprovedreactive.repository.ContainerCountRepository;
import romanovsky.katalogimprovedreactive.repository.ContainerTypeRepository;
import romanovsky.katalogimprovedreactive.service.ContainerCountService;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContainerCountServiceImpl implements ContainerCountService {

    private final ContainerCountRepository containerCountRepository;

    private final ContainerTypeRepository containerTypeRepository;

    @Autowired
    ContainerCountServiceImpl(ContainerCountRepository containerCountRepository,
                              ContainerTypeRepository containerTypeRepository) {
        this.containerCountRepository = containerCountRepository;
        this.containerTypeRepository = containerTypeRepository;
    }

    @Override
    public Map<ContainerType, Integer> getContainerDiskCount() {
        return Streams.stream(containerCountRepository.findAll())
                .collect(Collectors.toMap(
                        containerCount -> containerTypeRepository.findOne(containerCount.getContainerTypeId()),
                        ContainerCount::getDiskCount)
                );
    }
}
