import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'user',
    loadChildren: () =>
      import('./modules/login/login.module').then((m) => m.LoginModule),
  },
  {
    path: 'products',
    loadChildren: () =>
      import('./modules/shop/shop.module').then((m) => m.ShopModule),
  },
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'products',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
