import React from 'react';
import {Spinner } from 'react-bootstrap';

const Fila = ({album, deleteAlbum, editarAlbum, loading}) => {
    return (        
            <tr>
                <td>{album.id}</td>
                <td>{album.name}</td>
                <td>{album.postingDay}</td>
                <td>{album.postingMonth}</td>
                <td>{album.postingYear}</td>
                <td>
                <button class="btn btn-primary" onClick={() => deleteAlbum(album.id)}> Eliminar</button>
                <button class="btn btn-secondary" onClick={() => editarAlbum(album.id)} disabled={loading}>{loading && <Spinner animation="border" size="sm" />} Editar</button>
                </td>
            </tr>
        
    );
};
export default Fila;