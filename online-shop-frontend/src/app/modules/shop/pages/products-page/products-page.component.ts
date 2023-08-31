import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { getAllProductCategoriesAction } from '../../store/shop.actions';
import { selectAllProductCategories } from '../../store/shop.selectors';

@Component({
  selector: 'app-products-page',
  templateUrl: './products-page.component.html',
})
export class ProductsPageComponent implements OnInit {
  productCategories = this.store.select(selectAllProductCategories);

  constructor(private store: Store) {}

  ngOnInit(): void {
    this.store.dispatch(getAllProductCategoriesAction());
  }
}
