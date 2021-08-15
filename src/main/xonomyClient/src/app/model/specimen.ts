import { Species } from "./species";

export class Specimen {
    id: string = "";
    name: string = "";
    sex: string = "";
    location: string = "";
    notes: String = "";
    species: Species = new Species();
}
