package mintic.cicloiii.retos;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;


@Repository

public class RepositorioReservacion {
    
    @Autowired
    private InterfaceReservacion crud4;

    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }

    public Optional<Reservacion> getReservacion(int id){
        return crud4.findById(id);
    }

    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }

    public void delete (Reservacion reservacion){
        crud4.delete(reservacion);
    }

    public List<Reservacion> getReservacionByStatus(String status){
        return crud4.findAllByStatus(status);
    }

    public List<Reservacion> getReservacionPeriodo(Date dateOne, Date dateTwo){
        return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<ContarCliente> getTopCliente(){
        List<ContarCliente> clienteList=new ArrayList<>();
        List<Object[]> report=crud4.countTotalReservacionByCliente();
        for(int i=0;i<report.size();i++){
            clienteList.add(new ContarCliente((Long) report.get(i)[1] ,(Cliente)report.get(i)[0]));
            }
        return clienteList;

}
}   


