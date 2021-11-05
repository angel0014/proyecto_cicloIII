package mintic.cicloiii.reto3;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="client")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    @Column(length=4)
    private Integer idClient;
    
    @Column(length=45)
    private String email;
    
    @Column(length=45)
    private String password;

    @Column(length=45)
    private String name;

    @Column(length=4)
    private Integer age;

@OneToMany(cascade ={CascadeType.PERSIST}, mappedBy ="client")
@JsonIgnoreProperties("client")
private List<Mensaje> messages;


@OneToMany(cascade ={CascadeType.PERSIST}, mappedBy ="client")
@JsonIgnoreProperties("client")
private List<Reservacion> reservations;


public Integer getIdClient() {
    return idClient;
}


public void setIdClient(Integer idClient) {
    this.idClient = idClient;
}


public String getEmail() {
    return email;
}


public void setEmail(String email) {
    this.email = email;
}


public String getPassword() {
    return password;
}


public void setPassword(String password) {
    this.password = password;
}


public String getName() {
    return name;
}


public void setName(String name) {
    this.name = name;
}


public Integer getAge() {
    return age;
}


public void setAge(Integer age) {
    this.age = age;
}


public List<Mensaje> getMessages() {
    return messages;
}


public void setMessages(List<Mensaje> messages) {
    this.messages = messages;
}


public List<Reservacion> getReservations() {
    return reservations;
}


public void setReservations(List<Reservacion> reservations) {
    this.reservations = reservations;
}





    
}
