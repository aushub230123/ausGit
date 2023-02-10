:beginner: _**Preparing Data**_

- Create an array with products products.ts.
```ts
export const products = [

{
  id : 1,
  productName : 'Angular'
},

{
  id : 1,
  productName : 'Angular'
}

];
```

:lock: **js not typesafe**  
```ts
productName : 53
```

:key: **TypeScript = Types on Script**  

```ts
interface Product {
    id : number;
    productName : string;
}
```
- read the product and loop them
```java
   for(product : Products){
    sout(product)
   }
```

  ```ts
  <div *ngFor="let product of products" >
        {{product.name}}
  <div>
  ```
  --
  
- Structural Directive 
  - angular tells browser to go and add div * product 
  - * prefix is a structural directive

- Read a property from ts and render it on the package
- String iterpolation {{}}

:writing_hand: **_Explore the product-list_**
- product-list.component.ts


```ts
import {productsObject} from 'productsFileIgnoringTSextension';
export class ProductListComponent {
    productVar = productsObject;
}

import {products} from 'products';
export class ProductListComponent {
    products = products;
}
```

:beginner: _**Data Binding**_  


:point_right: {{}} string interpolation (reads data from ts and puts it over the template)  

:point_right: [] property binding  
```html
<a [title]="productItem.name + ' details'">  {{productItem.name}}</a>
```
:point_right: **Event Binding**  
```html
 <button type="button" (click)="share()">
```

:keyboard: **Construct the module**  
```ts

import {BrowserModule} from '@angular/platform-browser'
import {NgModule} from '@angular/core'
import {ProductAlertsComponent} from './products-alert/products-alert.component';
@NgModule({
    imports : [BrowserModule] 
    declarations : [AppComponent, TopBarComponent, ProductListComponent, ProductAlertsComponent],
    bootstrap : [AppComponent]
})
export class AppModule {
}
```

:computer: **Configuring the router**  

1. Import the Router Module
```ts
    import {RouterModule} from '@angular/router';
    imports : [BrowserModule,
    RouterModule] 
```

2. Configure the Routes
```ts
    import {RouterModule} from '@angular/router';
    imports : [BrowserModule,
    RouterModule.forRoot([
        path:'',component: ProductListComponent,
        path:'products/:productId',component:ProductDetailsComponent
    ])] 
```

3. Associate the output of the router to the HTML template
```html
<div class="container">
  <!-- <h1>App root</h1> -->
  <!-- <router-outlet></router-outlet> -->
  <!-- app-product-list gets rendered here....-->
  <router-outlet></router-outlet>
</div>
```

4. Configure the router link for navigation

```html
 <a [title]="productItem.name + ' details'"
 [routerLink]="['./product',product.id]"> {{ productItem.name }}</a>
```

5. Implement Product Details


```ts
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {ProductAlertsComponent} from './products-alert/products-alert.component';
@NgModule({
    imports : [BrowserModule,
    RouterModule.forRoot([
        path:'',component: ProductListComponent
    ])] 
    declarations : [AppComponent, TopBarComponent, ProductListComponent, ProductAlertsComponent],
    bootstrap : [AppComponent]
})
export class AppModule {
}
```
6. Process the information from the router in the product details page.
```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product, products } from '../child/child1/productsFileModule';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product : Product | undefined;
 constructor(private route : ActivatedRoute){
// CALLED FIRST 
console.log("cons");
 }
//  LIFE-CYCLE HOOK
 ngOnInit() {
  //  CALLED NEXT
  console.log("ngOnInit")
  const routeParams = this.route.snapshot.paramMap;
  const productIdFromRoute = Number(routeParams.get('productId'));
  this.product = products.find(product => product.id === productIdFromRoute );
}
}

```

7. Render the fetched product
```html
<h2>Product Details</h2>
<!-- <div *ngIf="product">
  <div>
    <h3>{{product?.name}}</h3>
      <h4>{{product?.price}}</h4>
      <p>{{product?.description}}</p> 
</div> -->
<div *ngIf="product">
  <div>
    <h3>{{product.name}}</h3>
      <h4>{{product.price}}</h4>
      <p>{{product.description}}</p> 
</div>
```
8. Create the service
```sh
ng generate service cart
ng g s cart
```
```ts
@Injectable({
  providedIn: 'root'
})
export class CartService {
  items: Product[] = [];
}
```


export class ProductDetailsComponent implements OnInit {
cartService: CartService;
  constructor(
    private route: ActivatedRoute,
     cartServiceParam: CartService
  ) { 
    this.cartService = cartServiceParam;
  }
}
