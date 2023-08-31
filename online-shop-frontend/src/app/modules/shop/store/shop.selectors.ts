import { createFeatureSelector, createSelector } from '@ngrx/store';
import { SHOP_FEATURE_NAME } from './shop.reducer';
import { ShopState } from './shop.state';

export const selectShopState =
  createFeatureSelector<ShopState>(SHOP_FEATURE_NAME);

export const selectAllProductCategories = createSelector(
  selectShopState,
  (state) => state.productCategories,
);
