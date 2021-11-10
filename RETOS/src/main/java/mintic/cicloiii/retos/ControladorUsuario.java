package mintic.cicloiii.retos;



import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class ControladorUsuario {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        //return principal.getAttributes(); <=NO SE RECOMIENDA! EXPONE DATOS PRIVADOS
        // Map<String, Object> VARIABLE = Collections.singletonMap("name", principal.getAttribute("login"));
     
        return Collections.singletonMap("name", principal.getAttribute("name"));
    
    }


}