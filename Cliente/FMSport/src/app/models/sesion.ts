import { Profesional } from "./profesional";
import { Servicio } from "./servicio";

export interface Sesion {
  id: number;
  servicio: Servicio;
  profesional: Profesional;
  fecha: string;
  cupoMax: number;
  sala: string;
  estado: string;
  notasInternas: string;
}
