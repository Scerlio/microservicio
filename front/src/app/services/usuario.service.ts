import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  listarUsuarios() {
    const url = 'http://localhost:8080/consumer/listar';
    return this.http.get(url);
  }
}
