import React from 'react';
import Fila from './Fila';
const Tabla = ({data, deleteAlbum, editarAlbum, loading}) => {
    return (
        <div>
            <table class="table table-dark table-striped">
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
                { data.length > 0 ? (
                    data.map((des) => (
                        <Fila album = {des} 
                        id = {des.id} 
                        deleteAlbum={deleteAlbum}  
                        editarAlbum={editarAlbum} 
                        loading={loading}  />
                    )
                    )
                )
                 : (
                <tr>No se encuentran datos</tr>
                ) 
                }
                
            </table>
            
        </div>
    );
};

export default Tabla;