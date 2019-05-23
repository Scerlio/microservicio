import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  newNombreUsuario: string = '';
  newApellidoUsuario: string = '';
  constructor() { }

  ngOnInit() {
  }

  addHero() {
    this.signal.emit(this.newNombreUsuario, this.newApellidoUsuario);
    this.newNombreUsuario = '';
  }
}
