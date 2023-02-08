:one: _US1_  

```ts
<h2>Products</h2>
<div *ngFor="let productItem of productsVar">
  {{productItem.name}}
</div>

// Render customer data as below: 
// Refer customer table in Sakila
// MIGRATE THE ENTIRE TABLE TO BE DISPLAYED AS A TABLE IN ANGULAR.
CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL
1,MARY,SMITH,MARY.SMITH@sakilacustomer.org
2,PATRICIA,JOHNSON,PATRICIA.JOHNSON@sakilacustomer.org

```
:bell: Steps
1. Fetch all the data in a json format using RESTController
2. Convert the fetched JSON data to an array of objects "customersData"
3. Place customersData in a file customersData.```ts
4. Modify the template below on product-list.component.ts
```html
<h2>Products</h2>
<div *ngFor="let productItem of productsVar">
  {{productItem.name}}
</div>

<h2>Customer Data
<div>
<!-- A stylish table using css -->
<!-- *ngFor to iterate through customers data -->
</div>
```

:one: _US2_  
:bell: Steps : Extend _US1_
1. Create OfferComponent
2. Render OfferComponent in the CustomerDataComponent with a Offer Button for address_id between 10 and 20.
3. Button should be "Avail Offer" or "No Offer"