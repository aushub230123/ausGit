:writing_hand: **_subscribe construct_**  

```ts
ngOnInit(): void {
    this.actorId = this.route.snapshot.params['actorId'];
    this.actorService.getActorById(this.actorId).subscribe(
      {
        next: (data) => {
          this.actor = data;
          console.log(data);
        },
        error: (error) => console.log(error)
      }
    );
}
```
