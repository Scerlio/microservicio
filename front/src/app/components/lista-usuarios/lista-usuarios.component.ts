import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  result: any;

  constructor(private service: UsuarioService) { }

  ngOnInit() {
    this.getApiInfo();
  }

  getApiInfo() {
    this.service.getRequest('http://localhost:8080/consumer/listar').subscribe(
      data => this.processResult(data),
      error => this.processError(error),
      () => this.processFinal()
    );
  }

  processResult(data: any) {
    console.log(data);
    this.result = data;
  }

  processError(error: any) {
  }

  processFinal() {}

}
