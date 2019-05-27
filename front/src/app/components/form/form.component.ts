import { Component, OnInit, EventEmitter, Output } from '@angular/core';

import { Usuario } from 'src/app/model/usuario';
import { EnviarService } from 'src/app/services/enviar.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output()
  newIdUsuario: string;
  newNombreUsuario: string = '';
  newApellidoUsuario: string = '';
  usuario: Usuario;
  result: any;

  constructor(private service: EnviarService) { }

  ngOnInit() {
  }

  addUsuario() {
    this.newMethod();
    window.location.reload();
    this.newNombreUsuario = '';
  }

  private newMethod() {
    this.usuario = new Usuario(this.newIdUsuario, this.newNombreUsuario, this.newApellidoUsuario);
    this.service.addUsuario(this.usuario).subscribe(
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
