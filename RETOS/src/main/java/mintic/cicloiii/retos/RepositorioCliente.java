package mintic.cicloiii.retos;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud1;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        return crud1.findById(id);

    }
    public Cliente save(Cliente client){
        return crud1.save(client);
    }
    public void delete (Cliente client){
        crud1.delete(client);

    }

    
}
