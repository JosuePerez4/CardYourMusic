import React, {useState, useEffect} from 'react';
import Tabla from './Tabla';
import Axios from 'axios';
import AgregarAlbumes from './AgregarAlbumes'

const CrudAlbumes = () => {
    const [list, setList] = useState([]);
     //Editar Sitio
    const [lSitio, setLSitio] = useState([]);
    const [loading, setLoading] = useState(false);
    const [show, setShow] = useState(false);

    useEffect (() => {
      mostrar();
    }, [setList] );

    //Mostrar los datos de los sitios
    const mostrar = async () => {
            try {
                const respuesta = await Axios({
                   url: "http://localhost:8080/TurismoWebApp/resources/destino/destinos" 
                });
                setList(respuesta.data);
                
            } catch (error) {
                console.log(error)
            }
    };

    const createSitio = async (newAlbum) => {
      try {
          console.log(newSitio);
        await Axios.post("http://localhost:8080/TurismoWebApp/resources/destino/destinos",newAlbum,{
          headers: {
            'Content-Type': 'application/json',
          },
              
      });
        mostrar();
      } catch (error) {
        console.error(error);
      }

    };
 
    const deleteSitio = async (id)  => { 
      let isDelete = window.confirm(
        `¿Estás seguro de eliminar el registro con el id '${id}'?`
      );
      if (isDelete){
        try {
            await Axios.delete(
              `http://localhost:8080/TurismoWebApp/resources/destino/destinos/${id}`
            );
            console.log("si");
          } catch (error) {
            console.log(error);
          }
        };
      
        mostrar();      
      
    };


    
    const editarAlbum = async (id) => {
      setLoading(true);
      await editarCargar(id);
      setLoading(false);
      setShow(true);    
    };
  
    const editarCargar = async (id) => {    
      try{
          const response = await Axios ({
              url: `http://localhost:8080/TurismoWebApp/resources/destino/destinos/${id}`
          });
          setLSitio(response.data);
          console.log("si");
      } catch(error){
          console.log(error);
      }
  };
  
  const modificarSitio = async (newSitio)  =>  { 
      console.log("Loading...");
        try {
        await Axios.put(
          "http://localhost:8080/TurismoWebApp/resources/destino/destinos",newAlbum,{
              headers: {
                'Content-Type': 'application/json',
              },
                  
          });
       } catch (error) {
        console.log(error);
      }
    
  
    mostrar();
    };
      
    return (
        <div>
            <AgregarSitio createSitio={createSitio} />
            <Tabla data = {list} deleteSitio={deleteSitio} editarSitio={editarSitio} loading={loading} />    
        </div>
    );
};

export default CrudAlbumes;