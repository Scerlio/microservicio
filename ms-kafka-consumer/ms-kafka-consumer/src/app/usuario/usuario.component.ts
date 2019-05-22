import { UsuarioService } from './../usuario.service';
import { Component, OnInit } from '@angular/core';

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
