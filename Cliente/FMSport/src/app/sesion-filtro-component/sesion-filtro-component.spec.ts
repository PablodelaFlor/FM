import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SesionFiltroComponent } from './sesion-filtro-component';

describe('SesionFiltroComponent', () => {
  let component: SesionFiltroComponent;
  let fixture: ComponentFixture<SesionFiltroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SesionFiltroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SesionFiltroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
