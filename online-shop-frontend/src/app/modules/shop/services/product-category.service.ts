import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductCategory } from '../data/product-category';

@Injectable({
  providedIn: 'root',
})
export class ProductCategoryService {
  constructor(private http: HttpClient) {}

  getAllProductCategories(): Observable<ProductCategory[]> {
    return this.http.get<ProductCategory[]>(
      `${environment.apiUrl}/products/categories`,
    );
  }
}
