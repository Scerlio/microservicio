import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { UsuarioService } from './../../services/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  usuario$: Object;
  constructor(private data: UsuarioService) { }

  ngOnInit() {
      this.data.listarUsuarios().subscribe(
      data => this.usuario$ = data
    );
  }

}

