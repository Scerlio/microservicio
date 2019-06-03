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
import { BusquedaComponent } from './components/busqueda/busqueda.component';

import { UsuarioService } from './services/usuario.service';
import { BuscarService } from './services/buscar.service';


const formState = { name: 'usuarios', url: '/usuarios',  component: ListaUsuariosComponent };
const searchState = { name: 'buscar', url: '/buscar',  component: BusquedaComponent };

const statesArray = [formState, searchState];
@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    ListaUsuariosComponent,
    ListaComponent,
    BusquedaComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    NgbModule,
    UIRouterModule.forRoot({ states: statesArray, useHash: true })
  ],
  providers: [UsuarioService, BuscarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
