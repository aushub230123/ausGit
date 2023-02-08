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



