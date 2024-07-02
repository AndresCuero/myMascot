
import com.Proyecto.SAM.cotroller.InicioCotroller;
import com.Proyecto.SAM.model.calificacion;
import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.repository.repositoryMascota;
import com.Proyecto.SAM.service.IcalificacionService;
import com.Proyecto.SAM.service.ImascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calificar")
public class Calificacion {

    @Autowired
    private ImascotaService mascotaService;

    @Autowired
    private repositoryMascota repoMascota;

    @Autowired
    private IcalificacionService calificacionService;
    
    private Integer id = InicioCotroller.idUsuario;

   @GetMapping("/save/{id}")
public String calificarMascota(@PathVariable("id") Integer ID_mascota, Model model) {

    // Buscar la mascota por su ID
    mascota mascota = mascotaService.buscarPorId(ID_mascota);

    // Verificar si la mascota tiene una calificación asociada
    if (mascota.getCalificacion() == null) {
        // Si no tiene calificación, crear una nueva
        calificacion calificacion = new calificacion();
        calificacion.setMegusta(true); 
        calificacion.setID_usuario(id); // Asignar el ID de usuario actual
        calificacionService.guardar(calificacion); // Guardar la calificación en la base de datos

        // Actualizar la mascota con la nueva calificación
        mascota.setPuntuacion(mascota.getPuntuacion() + 1);
        mascota.setCalificacion(calificacion);
    } else {
        // Si la mascota ya tiene calificación, obtener la calificación actual
        calificacion calificacion = calificacionService.buscarPorId(mascota.getCalificacion().getID_calificacion());

        // Verificar si el usuario actual ya ha calificado esta mascota
        if (calificacion.getID_usuario() == id) {
            // Si el usuario ya calificó, cambiar la calificación a no me gusta
            mascota.setPuntuacion(mascota.getPuntuacion() - 1);
            calificacion.setMegusta(false);
        } else {
            // Si el usuario no ha calificado, actualizar la calificación y asignar el usuario actual
            mascota.setPuntuacion(mascota.getPuntuacion() + 1);
            calificacion.setID_usuario(id);
            calificacion.setMegusta(true);
        }

        // Guardar la calificación actualizada en la base de datos
        calificacionService.guardar(calificacion);
        mascota.setCalificacion(calificacion);
    }

    // Guardar la mascota actualizada en la base de datos
    mascotaService.guardar(mascota);

    // Redirigir al inicio después de actualizar la mascota y las calificaciones
    return "redirect:/";
}

      @ModelAttribute
    public void setGenericos(Model model, usuario usuario) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);
    }
}
