import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';
  myvar = true;
  statesStrings = ['usuarios', 'buscar'];
  samples: string[] = ['Lista de usuarios', 'Buscar usuarios'];
  currentSample = 0;

  showSample(index: number) {
    this.currentSample = index;
  }
}
