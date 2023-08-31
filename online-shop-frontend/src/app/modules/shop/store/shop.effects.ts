import { catchError, exhaustMap, map, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { ProductCategoryService } from '../services/product-category.service';
import {
  getAllProductCategoriesAction,
  getAllProductCategoriesErrorAction,
  getAllProductCategoriesSuccessAction,
} from './shop.actions';

@Injectable()
export class ShopEffects {
  constructor(
    private actions$: Actions,
    private productCategoryService: ProductCategoryService,
  ) {}

  getAllProductCategories$ = createEffect(() =>
    this.actions$.pipe(
      ofType(getAllProductCategoriesAction),
      exhaustMap(() =>
        this.productCategoryService.getAllProductCategories().pipe(
          map((productCategories) =>
            getAllProductCategoriesSuccessAction({ productCategories }),
          ),
          catchError(() => of(getAllProductCategoriesErrorAction())),
        ),
      ),
    ),
  );
}
