import { Component } from "@angular/core";
import { RouterOutlet } from "@angular/router";

@Component({
  selector: 'app-client',
  template: `<router-outlet/>`,
  standalone: true,
  imports: [RouterOutlet]
})
export class Client {

}