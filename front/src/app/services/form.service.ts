import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../model/usuario';
@Injectable({
  providedIn: 'root'
})

export class FormService {

  constructor(private http: HttpClient) { }

  mandarUsuario(usuario: Usuario) {
    const url = 'http://localhost:8080/producer/enviar';
    return this.http.post(url, usuario);
  }
}
