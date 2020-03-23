package ds.dataservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    String getConfigurationByName(String name);
}
