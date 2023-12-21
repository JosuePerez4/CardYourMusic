import React from 'react';
import {Spinner } from 'react-bootstrap';

const FilaCanciones = ({cancion, deleteCanciones, editarCanciones, loading}) => {
    return (        
            <tr>
                <td>{cancion.id}</td>
                <td>{cancion.name}</td>
                <td>{cancion.rate}</td>
                <td>
                <button class="btn btn-primary" onClick={() => deleteCanciones(cancion.id)}> Eliminar</button>
                <button class="btn btn-secondary" onClick={() => editarCanciones(cancion.id)} disabled={loading}>{loading && <Spinner animation="border" size="sm" />} Editar</button>
                </td>
            </tr>
        
    );
};
export default FilaCanciones;