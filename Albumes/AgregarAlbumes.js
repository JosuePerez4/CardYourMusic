import React, { useState } from 'react';


const AgregarAlbumes = ({ createAlbum}) => {
    const [newAlbum, setNewAlbum] = useState({id: ' ', nombre: ' ', diaSalida: ' ', mesSalida: ' ', añoSalida: ' ', calificacion: ' '});

    const handleInputChange = (e) => {
        setNewAlbum({ ...newAlbum, [e.target.name]: e.target.value });
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        createAlbum(newAlbum);
        setNewAlbum({id: ' ', nombre: ' ', diaSalida: ' ', mesSalida: ' ', añoSalida: ' ', calificacion: ' '});
      };
    
      return (
        <form onSubmit={handleSubmit}>
           <input
            type="text"
            name="id"
            value={newAlbum.id}
            onChange={handleInputChange}
            placeholder="Id"
          />
          <input
            type="text"
            name="name"
            value={newAlbum.nombre}
            onChange={handleInputChange}
            placeholder="Nombre"
          />
          <input
            type="text"
            name="postingDay"
            value={newAlbum.postingDay}
            onChange={handleInputChange}
            placeholder="Dia Salida"
          />
          <input
            type="text"
            name="postingMonth"
            value={newAlbum.postingMonth}
            onChange={handleInputChange}
            placeholder="Mes Salida"
          />
          <input
            type="text"
            name="postingYear"
            value={newAlbum.postingYear}
            onChange={handleInputChange}
            placeholder="Año Salida"
          />
          <input
            type="text"
            name="rate"
            value={newAlbum.rate}
            onChange={handleInputChange}
            placeholder="calificacion"
          />
          <button type="submit">Agregar</button>
        </form>
      );
    };
    export default AgregarAlbumes;
