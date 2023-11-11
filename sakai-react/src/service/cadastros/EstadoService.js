import axios from "axios";


export class EstadoService {

    url = process.env.REACT_APP_URL_API;



    estados() {
        return axios.get('http://localhost:8080/api/');
    }

    inserir(objeto) {
        return axios.post('http://localhost:8080/api/');
    }

    alterar(objeto) {
        return axios.put('http://localhost:8080/api/');
    }

    excluir(id) {
        return axios.delete('http://localhost:8080/api/');
    }

    
}