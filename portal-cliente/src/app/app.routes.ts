import { Routes } from '@angular/router';
import { App } from './app';

export const routes: Routes = [
  {
    path: 'client',
    loadChildren: () => import('./modules/client/client.routes').then(m => m.routes),
  },
];
