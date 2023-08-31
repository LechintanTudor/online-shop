import { createAction, props } from '@ngrx/store';
import { ProductCategory } from '../data/product-category';

export const getAllProductCategoriesAction = createAction(
  '[Products] Get All Product Categories',
);

export const getAllProductCategoriesSuccessAction = createAction(
  '[Products] Get All Product Categories Success',
  props<{ productCategories: ProductCategory[] }>(),
);

export const getAllProductCategoriesErrorAction = createAction(
  '[Products] Get All Product Categories Error',
);
