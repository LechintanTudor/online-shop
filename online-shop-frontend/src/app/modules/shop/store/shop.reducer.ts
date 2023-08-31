import { LoadingStatus } from 'src/app/data/loading-status';
import { createReducer, on } from '@ngrx/store';
import {
  getAllProductCategoriesAction,
  getAllProductCategoriesErrorAction,
  getAllProductCategoriesSuccessAction,
} from './shop.actions';
import { initialShopState } from './shop.state';

export const SHOP_FEATURE_NAME = 'shop';

export const shopReducer = createReducer(
  initialShopState,

  // Product categories
  on(getAllProductCategoriesAction, (state) => ({
    ...state,
    productCategoryStatus: LoadingStatus.Loading,
  })),
  on(getAllProductCategoriesSuccessAction, (state, { productCategories }) => ({
    ...state,
    productCategoryStatus: LoadingStatus.Success,
    productCategories,
  })),
  on(getAllProductCategoriesErrorAction, (state) => ({
    ...state,
    productCategoryStatus: LoadingStatus.Error,
    lastError: 'Failed to load product categories',
  })),
);
