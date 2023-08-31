import { LoadingStatus } from 'src/app/data/loading-status';
import { ProductCategory } from '../data/product-category';

export interface ShopState {
  productCategoryStatus: LoadingStatus;
  productCategories: ProductCategory[];
  lastError: string;
}

export const initialShopState: ShopState = {
  productCategoryStatus: LoadingStatus.Initial,
  productCategories: [],
  lastError: '',
};
