import { Cliente } from "./cliente";
import { Sesion } from "./sesion";

export interface Reserva {
  id: number;
  cliente: Cliente;
  sesion: Sesion;
  fechaReserva: string;
  estado: string;
  comentarioCliente: string;
}
