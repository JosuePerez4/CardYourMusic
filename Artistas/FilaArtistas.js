import React from 'react';
import {Spinner } from 'react-bootstrap';

const FilaArtistas = ({artista, deleteArtista, editarArtista, loading}) => {
    return (        
            <tr>
                <td>{artista.id}</td>
                <td>{artista.name}</td>
                <td>{artista.albums}</td>
                <td>{artista.songs}</td>
                <td>
                <button class="btn btn-primary" onClick={() => deleteArtista(artista.id)}> Eliminar</button>
                <button class="btn btn-secondary" onClick={() => editarArtista(artista.id)} disabled={loading}>{loading && <Spinner animation="border" size="sm" />} Editar</button>
                </td>
            </tr>
        
    );
};
export default FilaArtistas;