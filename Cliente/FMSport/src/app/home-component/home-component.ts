import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-home-component',
  imports: [RouterLink],
  templateUrl: './home-component.html',
  styleUrl: './home-component.css',
})
export class HomeComponent {

   indice: number = 0;
  totalImagenes: number = 3;
  anio: number = new Date().getFullYear();

  ngOnInit(): void {
    this.iniciarSlider();
  }

  iniciarSlider(): void {
    setInterval(() => {
      this.indice++;

      if (this.indice >= this.totalImagenes) {
        this.indice = 0;
      }

      const pista = document.getElementById('pistaSlider');

      if (pista) {
        pista.style.transform = 'translateX(-' + (this.indice * 100) + '%)';
      }
    }, 3500);
  }
}
