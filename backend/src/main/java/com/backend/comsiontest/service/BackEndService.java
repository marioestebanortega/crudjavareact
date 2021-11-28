package com.backend.comsiontest.service;

import com.backend.comsiontest.entities.Persona;
import com.backend.comsiontest.entities.TipoDocumento;
import com.backend.comsiontest.repository.PersonaRepository;
import com.backend.comsiontest.repository.TipoDocumentoRepository;
import com.backend.comsiontest.vo.PersonaConverter;
import com.backend.comsiontest.vo.PersonaVo;
import com.backend.comsiontest.vo.TipoDocumentoConverter;
import com.backend.comsiontest.vo.TipoDocumentoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BackEndService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Transactional
    public Integer getNumberOrder() {
        /*return logisticRepository.getNumberOrder();*/
        return 0;
    }

    /*@Transactional
    public void saveOrder(String generateOrder, Integer numberOrder) throws Exception {
        try {
        Order or=new Order();
        or.setAddress(generateOrder.getCheckOut().getDirection());
        or.setDateOrder(generateOrder.getCheckOut().getDate());
        or.setProductTotal(generateOrder.getSum());
        or.setOrderId(numberOrder);
        or.setClientId(generateOrder.getCheckOut().getClientId());
        or.setDateGeneration(new Date());
        logisticRepository.save(or);
        }
        catch(Exception e){
            e.printStackTrace();
            String message="Error save order:"+ e.getMessage();
            LogManager.getLogger(this.getClass().getName()).error(message);
            throw new Exception(message);
        }
    }

     */
    public List<String> getOrders() {
        return null;
    }

    @Transactional
    public void guardar(PersonaVo personaVo) throws Exception {
        Persona per = PersonaConverter.toPersona(personaVo);
        TipoDocumento td = tipoDocumentoRepository.findById(personaVo.getTipoDocumento().getId()).get();
        per.setTipoDocumento(td);
        personaRepository.save(per);
        personaVo.setProcessOk(true);
        personaVo.setMessage("Se ha guardado correctamente");
    }

    @Transactional
    public void editar(PersonaVo personaVo) throws Exception {
        Persona per = personaRepository.findById(personaVo.getId()).get();
        PersonaConverter.toPersonaEdit(personaVo, per);
        TipoDocumento td = tipoDocumentoRepository.findById(personaVo.getTipoDocumento().getId()).get();
        per.setTipoDocumento(td);
        personaRepository.save(per);
        personaVo.setProcessOk(true);
        personaVo.setMessage("Se ha editado correctamente");
    }

    @Transactional
    public void remover(PersonaVo personaVo) throws Exception {
        Persona per = personaRepository.findById(personaVo.getId()).get();
        personaRepository.delete(per);
        personaVo.setProcessOk(true);
        personaVo.setMessage("Se ha eliminado correctamente");
    }

    public List<PersonaVo> obtenerPersonas() {
        List<Persona> pers = personaRepository.findAll();
        return pers.stream().map(p -> PersonaConverter.toPersonaVo(p)).collect(Collectors.toList());
    }

    public List<TipoDocumentoVo> obtenerTiposDocumento() {
        List<TipoDocumento> pers = tipoDocumentoRepository.findAll();
        return pers.stream().map(td -> TipoDocumentoConverter.toTipoDocumentoVO(td)).collect(Collectors.toList());
    }
}

