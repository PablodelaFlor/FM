export interface Usuario {
  id: number;
  nombre: string;
  email: string;
  password: string;
  telefono: string;
  rol: string;
  activo: boolean;
  fechaAlta: Date;
}
