package com.ap.argentinaprograma.controller;


import com.ap.argentinaprograma.models.Educacion;
import com.ap.argentinaprograma.services.EducacionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliofront-e2bb3.web.app")
@RequestMapping("/educacion")

public class EducacionController {
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    @CrossOrigin(origins = "https://portfoliofront-e2bb3.web.app")
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
        List<Educacion> educacion= educacionService.buscarEducacion();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "https://portfoliofront-e2bb3.web.app")
    @PutMapping("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion=educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "https://portfoliofront-e2bb3.web.app")
    @PostMapping("/add")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionService.agregarEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "https://portfoliofront-e2bb3.web.app")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
