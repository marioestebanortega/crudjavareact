package com.backend.comsiontest.vo;

import java.util.Date;

public class PersonaVo {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nombres;


    private String apellidos;
    private String numeroDocumento;
    private String fechaNacimiento;
    private boolean processOk;
    private String message;
    private TipoDocumentoVo tipoDocumento;

    public TipoDocumentoVo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoVo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getMessage() {
        return message;
    }


    public boolean isProcessOk() {
        return processOk;
    }

    public void setProcessOk(boolean processOk) {
        this.processOk = processOk;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
