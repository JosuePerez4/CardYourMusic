import React from 'react';
import Fila from './Fila';
const TablaCancion = ({data, deleteCancion, editarCancion, loading}) => {
    return (
        <div>
            <table class="table table-dark table-striped">
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                </tr>
                { data.length > 0 ? (
                    data.map((des) => (
                        <Fila cancion = {des} 
                        id = {des.id} 
                        deleteCancion={deleteCancion}  
                        editarCancion={editarCancion} 
                        loading={loading}/>
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

export default TablaCancion;