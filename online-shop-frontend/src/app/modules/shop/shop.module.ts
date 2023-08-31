import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSidenavModule } from '@angular/material/sidenav';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { ProductCategorySidebarComponent } from './components/product-category-sidebar/product-category-sidebar.component';
import { ProductsPageComponent } from './pages/products-page/products-page.component';
import { ProductCategoryService } from './services/product-category.service';
import { ShopRoutingModule } from './shop-routing.module';
import { ShopEffects } from './store/shop.effects';
import { SHOP_FEATURE_NAME, shopReducer } from './store/shop.reducer';

@NgModule({
  declarations: [ProductsPageComponent, ProductCategorySidebarComponent],
  providers: [ProductCategoryService],
  imports: [
    // Angular
    CommonModule,

    // Material
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatSidenavModule,

    // Routing
    ShopRoutingModule,

    // NgRx
    StoreModule.forFeature(SHOP_FEATURE_NAME, shopReducer),
    EffectsModule.forFeature([ShopEffects]),
  ],
})
export class ShopModule {}
