import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  getRequest(url: string): Observable<any> {
    return this.http.get(url);
  }

  deleteRequest(id: string): Observable<any> {
    const url = `http://localhost:8080/consumer/borrar/${id}`;
    return this.http.delete(url);
  }

  buscarRequest(apellido: string): Observable<any> {
    const url = `http://localhost:8080/consumer/buscar?apellido=${apellido}`;
    return this.http.get(url);
  }
}
