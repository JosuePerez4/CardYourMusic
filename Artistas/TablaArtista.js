import React from 'react';
import Fila from './Fila';
const TablaArtista = ({data, deleteArtista, editarArtista, loading}) => {
    return (
        <div>
            <table class="table table-dark table-striped">
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                </tr>
                { data.length > 0 ? (
                    data.map((des) => (
                        <Fila artista = {des} 
                        id = {des.id} 
                        deleteArtista={deleteArtista}  
                        editarArtista={editarArtista} 
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

export default TablaArtista;