package repos;

import models.Parts010;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartRepo010 extends JpaRepository<Parts010, Integer> {
    List<Parts010> findAll();
    Parts010 findByPartNo010(int partNo010);

    @Procedure(name = "Parts010.updatePart010")
    void updatePart010(@Param("partName010") String partName010,
                       @Param("partDescription010") String partDescription010,
                       @Param("currentPrice010") Float partPrice010,
                       @Param("currentQty010") Integer partQty010,
                       @Param("partNo010") int partNo010);
}
