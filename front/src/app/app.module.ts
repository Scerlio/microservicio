import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { UIRouterModule } from '@uirouter/angular';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { FormComponent } from './components/form/form.component';
import { UsuarioService } from './services/usuario.service';
import { FormService } from './services/form.service';


const formState = { name: 'Usuarios', url: '/usuarios',  component: UsuarioComponent };

const statesArray = [formState];
@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    FormComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    NgbModule,
    UIRouterModule.forRoot({ states: statesArray, useHash: true })
  ],
  providers: [UsuarioService, FormService],
  bootstrap: [AppComponent]
})
export class AppModule { }
