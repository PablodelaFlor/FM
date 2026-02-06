import { Usuario } from "./usuario";

export interface Cliente {
  id: number;
  nombre: string;
  lesiones:string;
  observaciones:string;
  fechaNacimiento:Date;
  email: string;
  usuario: Usuario;
}
