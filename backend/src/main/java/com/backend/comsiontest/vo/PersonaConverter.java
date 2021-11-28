package com.backend.comsiontest.vo;

import com.backend.comsiontest.entities.Persona;
import com.backend.comsiontest.entities.TipoDocumento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonaConverter {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Persona toPersona(PersonaVo personaVo) throws Exception {
        Persona per = new Persona();
        per.setId(personaVo.getId());
        per.setApellidos(personaVo.getApellidos());
        per.setNombres(personaVo.getNombres());
        //fecha
        Date date = sdf.parse(personaVo.getFechaNacimiento());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        per.setFechaNacimiento(cal.getTime());
        per.setNumeroDocumento(personaVo.getNumeroDocumento());
        return per;
    }

    public static Persona toPersonaEdit(PersonaVo personaVo, Persona per) throws Exception {
        per.setId(personaVo.getId());
        per.setApellidos(personaVo.getApellidos());
        per.setNombres(personaVo.getNombres());
        //fecha
        Date date = sdf.parse(personaVo.getFechaNacimiento());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        per.setFechaNacimiento(cal.getTime());
        per.setNumeroDocumento(personaVo.getNumeroDocumento());
        return per;
    }

    public static PersonaVo toPersonaVo(Persona per) {
        PersonaVo personaVo = new PersonaVo();
        personaVo.setApellidos(per.getApellidos());
        personaVo.setNombres(per.getNombres());
        //fecha
        String strDate = sdf.format(per.getFechaNacimiento());
        personaVo.setFechaNacimiento(strDate);

        personaVo.setId(per.getId());
        personaVo.setNumeroDocumento(per.getNumeroDocumento());
        TipoDocumentoVo tVo = TipoDocumentoConverter.toTipoDocumentoVO(per.getTipoDocumento());
        personaVo.setTipoDocumento(tVo);
        return personaVo;
    }

}
