import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  result: any;
  apellidoUsuario: string = '';

  constructor(private service: UsuarioService) { }

  ngOnInit() {
  }

  buscarUsuario() {
    this.service.buscarRequest(this.apellidoUsuario).subscribe(
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

  removeUsuario(index: string) {
    window.location.reload();
    this.service.deleteRequest(index).subscribe();
  }

  
}
