import { Routes } from '@angular/router';
import { Client } from './client';

export const routes: Routes = [
  {
    path: '',
    component: Client,
    children: [
      {
        path: 'login',
        loadComponent: () => import('./login/login').then((m) => m.Login),
      },
    ],
  },
];
