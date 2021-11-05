package mintic.cicloiii.retos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorReservacion {
    @Autowired
    private ServiciosReservacion servicio;
    @GetMapping("/all")
    public List<Reservacion> getReservacion(){
        return servicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Reservacion> getReservacion(@PathVariable("id") int idReservacion){
        return servicio.getReservacion(idReservacion);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservacion){
        return servicio.save(reservacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservacion){
        return servicio.update(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservacion){
        return servicio.deleteReservacion(idReservacion);
    }

    @GetMapping("/report-status")
    public ReservacionStatus getReservacionesStatusReport(){
        return servicio.getReservacionStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getReservacionReportDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return servicio.getReservacionPeriodo(dateOne,dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContarCliente> getReservacionesReportsCliente(){
        return servicio.getTopClientes();
    }


    
}
