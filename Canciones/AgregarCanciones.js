import React, { useState } from 'react';


const AgregarCanciones = ({createCancion}) => {
    const [newCancion, setNewCancion] = useState({id: ' ', name: ' ', rate: ' '});

    const handleInputChange = (e) => {
        setNewCancion({ ...newCancion, [e.target.name]: e.target.value });
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        createCancion(newCancion);
        setNewCancion({id: ' ', name: ' ', rate: ' '});
      };
    
      return (
        <form onSubmit={handleSubmit}>
           <input
            type="text"
            name="id"
            value={newCancion.id}
            onChange={handleInputChange}
            placeholder="Id"
          />
          <input
            type="text"
            name="name"
            value={newCancion.nombre}
            onChange={handleInputChange}
            placeholder="Nombre"
          />
          <input
            type="text"
            name="rate"
            value={newCancion.rate}
            onChange={handleInputChange}
            placeholder="Rate"
          />
          <button type="submit">Agregar</button>
        </form>
      );
    };
    export default AgregarCanciones;
