package repos;


import models.POs010;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PORepo010 extends JpaRepository<POs010, Integer> {
    POs010 findByPoNo010AndClientCompId010(@Param("poNo010") int poNo010, @Param("clientCompId010") int clientCompID010);
    List<POs010> findByClientCompId010(@Param("clientCompId010") int clientCompID010);
    POs010 findByPoNo010(int poNo010);
    List<POs010> findAll();


    @Procedure(name = "POs010.createPo010")
    void createPo010(@Param("clientCompId010") int clientCompId010, @Param("partNo010") int partNo010, @Param("poNo010") Integer poNo010);

    @Procedure(name = "POs010.createPoTest010", procedureName = "POST_NEW_ORDER_TEST")
    void createPoTest010(String newOrderInput);

    @Procedure(name = "POs010.updatePoStatus010")
    void updatePoStatus010(@Param("status010") String status010, @Param("poNo010")int poNo010);

    @Procedure(name = "POs010.cancelPo010")
    void cancelPo010(@Param("poNo010") int poNo010);

}
