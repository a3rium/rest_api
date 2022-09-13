package repos;

import models.ClientUser010;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepos010 extends JpaRepository<ClientUser010, Integer>{
    List<ClientUser010> findAll();
    ClientUser010 findByClientCompId010(int clientCompId010);

    @Procedure(name = "client_user010.updateClient010")
    void updateClient010(@Param("clientCompName010") String clientCompName010,
                         @Param("clientCity010") String clientCity010,
                         @Param("moneyOwed010") Float moneyOwed010,
                         @Param("clientCompPassword010") String clientCompPassword010,
                         @Param("clientCompId010") int clientCompId010);

}
