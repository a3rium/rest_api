package repos;

import models.PO_LINES010;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;
public interface POLinesRepo010 extends JpaRepository<PO_LINES010, Integer> {
    List<PO_LINES010> findByPo(@Param("poNo010") int poNo010);

}
