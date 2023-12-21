import React, { useState } from 'react';


const AgregarArtistas = ({ createArtista}) => {
    const [newArtista, setNewArtista] = useState({id: ' ', name: ' ', albums: ' ', songs: ' '});

    const handleInputChange = (e) => {
        setNewArtista({ ...newArtista, [e.target.name]: e.target.value });
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        createArtista(newArtista);
        setNewArtista({id: ' ', name: ' ', albums: ' ', songs: ' '});
      };
    
      return (
        <form onSubmit={handleSubmit}>
           <input
            type="text"
            name="id"
            value={newArtista.id}
            onChange={handleInputChange}
            placeholder="Id"
          />
          <input
            type="text"
            name="name"
            value={newArtista.nombre}
            onChange={handleInputChange}
            placeholder="Nombre"
          />
          <input
            type="text"
            name="albums"
            value={newArtista.albums}
            onChange={handleInputChange}
            placeholder="Álbumes"
          />
          <input
            type="text"
            name="songs"
            value={newArtista.songs}
            onChange={handleInputChange}
            placeholder="Canciones"
          />
          <button type="submit">Agregar</button>
        </form>
      );
    };
    export default AgregarArtistas;
