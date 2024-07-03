
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.repository.repositoryAnimal;
import com.Proyecto.SAM.repository.repositoryMascota;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/* @author Andres cuero*/

@Service("mascotaIMP")
public class mascotaServiceIMP implements ImascotaService {
    
    @Autowired
    private repositoryMascota repoMascota;
    
    @Autowired
    private repositoryAnimal repoAnimal;

    @Override
    public void guardar(mascota mascota) {
        repoMascota.save(mascota);
        
    }

    @Override
    public void eliminar(Integer id) {
        repoMascota.deleteById(id);
    }

    @Override
    public List<mascota> buscartodas() {
       return repoMascota.findAll();
    }

    @Override
    public mascota buscarPorId(Integer id) {
      Optional<mascota> optional = repoMascota.findById(id);
      if(optional.isPresent()){
          return optional.get();
      }
      return null;
    }

    @Override
    public List<mascota> buscarPerroOgato(String especie) {
       return repoMascota.findByEspecie(especie);
    }

    @Override
    public Page<mascota> buscarTodas(Pageable page) {
        return repoMascota.findAll(page);
    }

    @Override
    public List<mascota> buscarPorExamble(Example<mascota> example) {
      return  repoMascota.findAll(example);
    }



  @Override
public Page<mascota> buscarTodasOrdenadaPorCalificacionYaprobadas(Pageable page) {
    return repoMascota.findByEstatusOrderByCalificacionDesc(page);
}

    @Override
    public Page<mascota> buscartodas(Pageable page) {
          return repoMascota.findAll(page);
    }

    @Override
    public List<mascota> misPublicaciones(Integer ID_mascota) {
       return repoMascota.findByUsuarioAndEstatus(ID_mascota);
    }

    @Override
    public List<mascota> buscarTodasOrdenadaPorCalificacionYaprobadas() {
        return repoMascota.findByEstatusOrderByCalificacionDesc();
    }

    @Override
     public Integer buscarPorUsuarioParaSaberSiTieneMascota(Integer idUsuario) {
        Optional<mascota> optional = repoMascota.findByUsuario(idUsuario);
        if (optional.isPresent()) {
            return 1; 
        }
        return 0; 
    }

    @Override
    public List<mascota> buscarMascotasEliminada(String estatus) {
      return  repoMascota.findByEstatus(estatus);
        
    }

 

 
    
}
