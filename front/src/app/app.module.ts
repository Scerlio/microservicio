import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { UIRouterModule } from '@uirouter/angular';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ListaUsuariosComponent } from './components/lista-usuarios/lista-usuarios.component';
import { ListaComponent } from './components/lista/lista.component';
import { FormComponent } from './components/form/form.component';

import { UsuarioService } from './services/usuario.service';

const formState = { name: 'Usuarios', url: '/usuarios',  component: ListaUsuariosComponent };

const statesArray = [formState];
@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    ListaUsuariosComponent,
    ListaComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    NgbModule,
    UIRouterModule.forRoot({ states: statesArray, useHash: true })
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
