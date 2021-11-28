import React, { useState, useEffect } from "react";
import './App.css';

const host = "http://localhost:8095/api/";

const obtenerPersonasAPI = async () => {

  const response = await fetch(host + 'obtenerPersonas', {
    method: "get",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  return [response, response.status];

}


const obtenerTiposDocumentoAPI = async () => {

  const response = await fetch(host + 'obtenerTiposDocumento', {
    method: "get",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  return [response, response.status];

}




function App() {
  const [personas, setPersonas] = useState([]);
  const [tiposDocumento, setTiposDocumento] = useState([]);
  const [formRegister, setFormRegister] = useState({
    "persona": {
      "tipoDocumento": {}
    }
  });

  const actionPerson = () => {
    obtenerPersonasAPI()
      .then(([response, status]) => {
        return response.json();
      })
      .then((responseOrder) => {
        setPersonas(responseOrder)
      });

  }


  const guardarPersonasAPI = async () => {
    let serviceOut = 'guardarPersona'
    if (formRegister.persona.id) {
      serviceOut = 'editarPersona'
    }
    const response = await fetch(host + serviceOut, {
      method: "post",
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formRegister.persona)
    });

    actionPerson();
    return [response, response.status];

  }

  const borrarPersonasAPI = async (id) => {

    const response = await fetch(host + 'borrarPersona', {
      method: "post",
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ "id": id })
    });


    actionPerson();
    return [response, response.status];

  }

  const onSubmitForm = e => {
    e.preventDefault();
  }

  useEffect(() => {
    obtenerTiposDocumentoAPI()
      .then(([response, status]) => {
        return response.json();
      })
      .then((responseOrder) => {
        setTiposDocumento(responseOrder)
      });
  }, []);

  useEffect(() => {
    actionPerson();
  }, []);

  const onChangeInput = e => {
    if (e.target.id === "tipoDocumento") {
      setFormRegister({
        ...formRegister, "persona":
        {
          ...formRegister.persona,
          "tipoDocumento": {
            ...formRegister.persona.tipoDocumento,
            "id": e.target.value
          }
        }
      }
      );
    }
    else {
      setFormRegister({ ...formRegister, "persona": { ...formRegister.persona, [e.target.id]: e.target.value } });

    }


    // }
  }
  const guardarPersona = e => {
    guardarPersonasAPI();
    setFormRegister({
      "persona": {
        "tipoDocumento": {}
      }
    })
    document.getElementById('datosBasicos').reset();
  }

  const borrarRegistro = p => {
    borrarPersonasAPI(p.id);
  }

  const editarPersona = p => {
    document.getElementById("nombres").value = p.nombres;
    document.getElementById("apellidos").value = p.apellidos;
    document.getElementById("numeroDocumento").value = p.numeroDocumento;
    document.getElementById("tipoDocumento").value = p.tipoDocumento.id;
    document.getElementById("fechaNacimiento").value = p.fechaNacimiento;
    setFormRegister({ persona: p });
  }



  return (
    <form className="App" onSubmit={onSubmitForm}>
      <header className="header">
        <h1>Personas</h1>
      </header>
      <section>
        <form id="datosBasicos" className="datosBasicos">
          <div className="fila">
            <label for="nombres">Nombres:</label>
            <input onChange={onChangeInput} type="text" id="nombres" name="nombres" />
            <label for="apellidos">Apellidos:</label>
            <input id="apellidos" onChange={onChangeInput} type="text" id="apellidos" name="lname" />
          </div>
          <div className="fila">
            <label for="tipoDocumento">Típo documento</label>
            <select id='tipoDocumento' onChange={onChangeInput}
              className="selectItem"
              required
            >
              <option value="">
                --Seleccione un elemento--
              </option>
              {
                tiposDocumento.map((data, i) =>
                  <option id={"siTd" + i} value={data.id} key={i}>{data.descripcion}</option>)
              }

            </select>
            <label for="numeroDocumento">Número documento</label>
            <input onChange={onChangeInput} type="number" id="numeroDocumento" name="numeroDocumento" />
          </div>
          <div className="fila">
            <label for="fechaNacimiento">Fecha nacimiento</label>
            <input data-date-format="DD MMMM YYYY" onChange={onChangeInput} type="date" id="fechaNacimiento" name="fechaNacimiento" />
            <button onClick={guardarPersona} className="buttonC">Guardar</button>
          </div>

        </form>
      </section>
      {
        personas.length !== 0 && <section className="personasDetalle">
          <table className="personas">
            <thead>
              <tr>
                <th><h2>Id</h2></th>
                <th><h2>Nombres</h2></th>
                <th><h2>Apellidos</h2></th>
                <th><h2>Tipo documento</h2></th>
                <th><h2>Número documento</h2></th>
                <th><h2>Fecha nacimiento</h2></th>
                <th><h2>Editar</h2></th>
                <th><h2>Eliminar</h2></th>
              </tr>
            </thead>
            <tbody>

              {
                personas.map((data, i) =>
                  <tr id={"row" + i}>
                    <td><h3 id={"id" + i}>{data.id}</h3></td>
                    <td><h3 id={"nombres" + i}>{data.nombres}</h3></td>
                    <td><h3 id={"apellidos" + i}>{data.apellidos}</h3></td>
                    <td><h3 id={"tipoDocumento" + i}>{data.tipoDocumento.descripcion}</h3></td>
                    <td><h3 id={"numeroDocumento" + i}>{data.numeroDocumento}</h3></td>
                    <td><h3 id={"fechaNacimiento" + i}>{data.fechaNacimiento}</h3></td>
                    <td><button className="buttonC" onClick={(e) => editarPersona(data)}>Editar</button></td>
                    <td><button  className="buttonC" onClick={(e) => borrarRegistro(data)} >Borrar</button></td>
                  </tr>
                )}


            </tbody>
          </table>
        </section>
      }

    </form>)
}

export default App;
