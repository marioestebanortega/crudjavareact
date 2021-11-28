package com.backend.comsiontest.resource;

import com.backend.comsiontest.entities.Persona;
import com.backend.comsiontest.service.BackEndService;
import com.backend.comsiontest.vo.PersonaVo;
import com.backend.comsiontest.vo.TipoDocumentoVo;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Service of BackEnd
 *
 * @author mario
 */
@RestController
@RequestMapping("/api/")
public class BackEndResource {

    @Autowired
    private BackEndService BackEndService;


    @GetMapping(value = "/obtenerPersonas")
    public ResponseEntity<List<PersonaVo>> obtenerPersonas() {
        try {
            List<PersonaVo> ou = BackEndService.obtenerPersonas();
            return new ResponseEntity<>(ou, HttpStatus.OK);
        } catch (Exception e) {
            List<PersonaVo> ou = new ArrayList<>();
            LogManager.getLogger(this.getClass().getName()).error("BackEnd process fail:" + e.getMessage());
            return new ResponseEntity<>(ou, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/obtenerTiposDocumento")
    public ResponseEntity<List<TipoDocumentoVo>> obtenerTiposDocumento() {
        try {
            List<TipoDocumentoVo> ou = BackEndService.obtenerTiposDocumento();
            return new ResponseEntity<>(ou, HttpStatus.OK);
        } catch (Exception e) {
            List<TipoDocumentoVo> ou = new ArrayList<>();
            LogManager.getLogger(this.getClass().getName()).error("BackEnd process fail:" + e.getMessage());
            return new ResponseEntity<>(ou, HttpStatus.BAD_REQUEST);
        }

    }


    @PostMapping(value = "/guardarPersona")
    public ResponseEntity<PersonaVo> guardarPersona(@RequestBody PersonaVo personaVo) {
        personaVo.setProcessOk(false);
        try {
            BackEndService.guardar(personaVo);
            return new ResponseEntity<>(personaVo, HttpStatus.OK);
        } catch (Exception e) {
            personaVo.setMessage("BackEnd process fail:" + e.getMessage());
            personaVo.setProcessOk(false);
            LogManager.getLogger(this.getClass().getName()).error("BackEnd process fail:" + e.getMessage());
            return new ResponseEntity<>(personaVo, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/borrarPersona")
    public ResponseEntity<PersonaVo> borrarPersona(@RequestBody PersonaVo personaVo) {
        personaVo.setProcessOk(false);
        try {
            BackEndService.remover(personaVo);
            return new ResponseEntity<>(personaVo, HttpStatus.OK);
        } catch (Exception e) {
            personaVo.setMessage("BackEnd process fail:" + e.getMessage());
            personaVo.setProcessOk(false);
            LogManager.getLogger(this.getClass().getName()).error("BackEnd process fail:" + e.getMessage());
            return new ResponseEntity<>(personaVo, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/editarPersona")
    public ResponseEntity<PersonaVo> editarPersona(@RequestBody PersonaVo personaVo) {
        personaVo.setProcessOk(false);
        try {
            BackEndService.editar(personaVo);
            return new ResponseEntity<>(personaVo, HttpStatus.OK);
        } catch (Exception e) {
            personaVo.setMessage("BackEnd process fail:" + e.getMessage());
            personaVo.setProcessOk(false);
            LogManager.getLogger(this.getClass().getName()).error("BackEnd process fail:" + e.getMessage());
            return new ResponseEntity<>(personaVo, HttpStatus.BAD_REQUEST);
        }
    }

}
