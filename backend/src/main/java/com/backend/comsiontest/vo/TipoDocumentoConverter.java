package com.backend.comsiontest.vo;

import com.backend.comsiontest.entities.TipoDocumento;

public class TipoDocumentoConverter {
    public static TipoDocumentoVo toTipoDocumentoVO(TipoDocumento td) {
        TipoDocumentoVo tdo = new TipoDocumentoVo();
        tdo.setDescripcion(td.getDescripcion());
        tdo.setId(td.getId());
        return tdo;
    }
}
