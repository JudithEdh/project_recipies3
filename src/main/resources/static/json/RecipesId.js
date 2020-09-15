function displayId(){
  const req = new XMLHttpRequest();
  req.onreadystatechange = () => {

    if (req.status === 200 && req.readyState === 4) {
      if (req.getResponseHeader("Content-Type") === "application/json") {
        console.log("oh look its some JSON: " + req.responseText);

        let stuff = JSON.parse(req.response);
        stuff.forEach(el => {
          let elem = document.createElement('div');
          let header = document.createElement('h3');
          header.textContent = "Recipe name: " + el.name;
          elem.appendChild(header);

          let id=document.createElement('p');
          id.textContent = "Id: " + el.id;
          elem.appendChild(id);
          el.ingredients.forEach(ingredient => {
            console.log(ingredient) // print all ingredients for each recipe
            let name = document.createElement('p');
            let ingredientId= document.createElement('p');
            name.textContent = "Ingredient: " + ingredient.name;
            ingredientId.textContent = "Id: " + ingredient.id;
            elem.appendChild(name);
            elem.appendChild(ingredientId);
          })
          document.body.appendChild(elem);
        });
      } else {
        console.log(
            "Looks like its not JSON but lets see what it is... " + req.responseText
        );
      }
    } else {
      console.log("Oh no... handle error");
    }
  };
  req.open("GET", "http://localhost:9000/getAllRecipes");
  req.send();
}
