import { Species } from "./species";
import { Image } from "./image";

export class Specimen {
    id: string = "";
    name: string = "";
    sex: string = "";
    location: string = "";
    notes: String = "";
    timestamp: Date = new Date();
    species: Species = new Species();
    image: Image = new Image();
}
