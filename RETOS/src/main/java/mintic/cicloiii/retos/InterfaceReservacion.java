package mintic.cicloiii.reto3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{
    @Query("SELECT c.client, COUNT(c.client) FROM Reservacion AS c group by c.client order by COUNT(c.client)DESC")
    
    public List<Object[]> countTotalReservacionByCliente();
    
    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore (Date dateOne,Date dateTwo);

    public List<Reservacion> findAllByStatus(String status);
    
    
}
