import { Component, Input } from '@angular/core';
import { ProductCategory } from '../../data/product-category';

@Component({
  selector: 'product-category-sidebar',
  templateUrl: './product-category-sidebar.component.html',
})
export class ProductCategorySidebarComponent {
  @Input()
  productCategories: ProductCategory[] = [];
}
