package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import models.AgentPasswords010;

import java.util.List;

public interface AgentRepo010 extends JpaRepository<AgentPasswords010, Integer>{
    List<AgentPasswords010> findAll();
}
