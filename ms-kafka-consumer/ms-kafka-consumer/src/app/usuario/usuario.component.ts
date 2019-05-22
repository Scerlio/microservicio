import { UsuarioService } from './../usuario.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

    usuarios$: Object;
  constructor(private data: UsuarioService) { }

  ngOnInit() {
      this.data.getUsuarios().subscribe(
      data => this.usuarios$ = data
    );
  }

}
