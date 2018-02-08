package romanovsky.katalogimprovedreactive.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import romanovsky.katalogimprovedreactive.model.ContainerCount;
import romanovsky.katalogimprovedreactive.model.ContainerType;
import romanovsky.katalogimprovedreactive.repository.ContainerCountRepository;
import romanovsky.katalogimprovedreactive.repository.ContainerTypeRepository;
import romanovsky.katalogimprovedreactive.service.ContainerCountService;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContainerCountServiceImplTest {

    @Autowired
    private ContainerCountService containerCountService;

    @Autowired
    private ContainerCountRepository containerCountRepository;

    @Autowired
    private ContainerTypeRepository containerTypeRepository;

    @Test
    public void whenThereAreNoContainerCountsAnEmptyMapShouldBeReturned() {
        Map<ContainerType, Integer> containerDiskCount = containerCountService.getContainerDiskCount();

        assertThat(containerDiskCount).isEmpty();
    }

    @Test
    public void whenThereIsOneContainerCountAMapContainingItShouldBeReturned() {
        ContainerType containerType = new ContainerType("test container type");
        containerTypeRepository.save(containerType);

        int testContainerCount = 12;
        containerCountRepository.save(new ContainerCount(containerType.getId(), testContainerCount));

        Map<ContainerType, Integer> containerDiskCount = containerCountService.getContainerDiskCount();
        assertThat(containerDiskCount).containsOnlyKeys(containerType);
        assertThat(containerDiskCount.get(containerType)).isEqualTo(testContainerCount);
    }

    @Test
    public void whenThereAreMultipleContainerCountsAMapContainingThemShouldBeReturned() {
        ContainerType firstContainerType = new ContainerType("first container type");
        ContainerType secondContainerType = new ContainerType("second container type");
        containerTypeRepository.save(firstContainerType);
        containerTypeRepository.save(secondContainerType);

        int firstContainerCount = 12;
        int secondContainerCount = 13;
        containerCountRepository.save(new ContainerCount(firstContainerType.getId(), firstContainerCount));
        containerCountRepository.save(new ContainerCount(secondContainerType.getId(), secondContainerCount));

        Map<ContainerType, Integer> containerDiskCount = containerCountService.getContainerDiskCount();
        assertThat(containerDiskCount).containsOnlyKeys(firstContainerType, secondContainerType);
        assertThat(containerDiskCount.get(firstContainerType)).isEqualTo(firstContainerCount);
        assertThat(containerDiskCount.get(secondContainerType)).isEqualTo(secondContainerCount);
    }

    @Test
    public void whenThereAreNoContainerCountsAZeroSumShouldBeReturned() {
        long containerDiskCountSum = containerCountService.getContainerDiskCountSum();

        assertThat(containerDiskCountSum).isZero();
    }

    @Test
    public void whenThereIsOneContainerCountAProperSumShouldBeReturned() {
        ContainerType containerType = new ContainerType("test container type");
        containerTypeRepository.save(containerType);

        int testContainerCount = 12;
        containerCountRepository.save(new ContainerCount(containerType.getId(), testContainerCount));

        long containerDiskCountSum = containerCountService.getContainerDiskCountSum();
        assertThat(containerDiskCountSum).isEqualTo(testContainerCount);
    }

    @Test
    public void whenThereAreMultipleContainerCountsAProperSumShouldBeReturned() {
        ContainerType firstContainerType = new ContainerType("first container type");
        ContainerType secondContainerType = new ContainerType("second container type");
        containerTypeRepository.save(firstContainerType);
        containerTypeRepository.save(secondContainerType);

        int firstContainerCount = 12;
        int secondContainerCount = 13;
        containerCountRepository.save(new ContainerCount(firstContainerType.getId(), firstContainerCount));
        containerCountRepository.save(new ContainerCount(secondContainerType.getId(), secondContainerCount));

        long containerDiskCountSum = containerCountService.getContainerDiskCountSum();
        assertThat(containerDiskCountSum).isEqualTo(firstContainerCount + secondContainerCount);
    }

    @TestConfiguration
    static class ContainerCountServiceImplTestContextConfiguration {

        @Bean
        public ContainerCountService containerCountService(ContainerCountRepository containerCountRepository,
                                                           ContainerTypeRepository containerTypeRepository) {
            return new ContainerCountServiceImpl(containerCountRepository, containerTypeRepository);
        }
    }


}