import { Component, OnInit, EventEmitter, Output } from '@angular/core';

import { Usuario } from 'src/app/model/usuario';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output() signal = new EventEmitter<Usuario>();
  newIdUsuario: string = '';
  newNombreUsuario: string = '';
  newApellidoUsuario: string = '';
  constructor() { }

  ngOnInit() {
  }

  addUsuario() {
    this.signal.emit(new Usuario(this.newIdUsuario, this.newNombreUsuario, this.newApellidoUsuario));
    this.newNombreUsuario = '';
  }
}
