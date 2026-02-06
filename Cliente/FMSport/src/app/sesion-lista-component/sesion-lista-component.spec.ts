import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SesionListaComponent } from './sesion-lista-component';

describe('SesionListaComponent', () => {
  let component: SesionListaComponent;
  let fixture: ComponentFixture<SesionListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SesionListaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SesionListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
