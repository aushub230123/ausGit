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
