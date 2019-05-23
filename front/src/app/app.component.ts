import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';
  myvar = true;
  statesStrings = ['usuarios'];
  samples: string[] = ['Lista de héroes'];
  currentSample: number = 0;

  showSample(index: number) {
    this.currentSample = index;
  }
}
