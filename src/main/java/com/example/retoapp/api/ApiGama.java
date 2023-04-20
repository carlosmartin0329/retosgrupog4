package com.example.retoapp.api;

import com.example.retoapp.modelo.entidad.Gama;
import com.example.retoapp.service.GamaService;
import com.example.retoapp.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Gama")
@CrossOrigin("*")
public class ApiGama {
    @Autowired
    private GamaService service;
    @GetMapping("/all")
    public List<Gama> getGamaAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getGama(@PathVariable long id){
        Optional<Gama> gama = service.getFindById(id);
        if(gama.isPresent()){
            return ResponseEntity.ok(gama.get());
        }
        else{
            // return ResponseEntity.status(404).build();
            /*
            Mensaje mensaje = new Mensaje(404,
                    "No se encontro Registro id="+id);
            return ResponseEntity.status(404).body(mensaje);
            */
            Mensaje mensaje = Mensaje.builder()
                    .httpCode(404)
                    .mensaje("No se encontro Registro id="+id)
                    .build();
            return ResponseEntity.status(404).body(mensaje);
        }
    }
    @PostMapping("/save")
    public ResponseEntity saveGama(@RequestBody Gama gama){
        service.save(gama);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity updateGama(@RequestBody Gama gama){
        service.updateGama(gama);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteGama(@PathVariable long id){
        service.deleteGama(id);
        return ResponseEntity.status(204).build();
    }
}