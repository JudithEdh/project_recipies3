function displayRecipes(){
  const req = new XMLHttpRequest();
  req.onreadystatechange = () => {
    // Example handle logic
    if (req.status === 200 && req.readyState === 4) {
      if (req.getResponseHeader("Content-Type") === "application/json") {
        console.log("oh look its some JSON: " + req.responseText);
        // adding an element to the body example
        // let elem = document.createElement('div');
        // elem.textContent = "hello world";
        // document.body.appendChild(elem);

        let stuff = JSON.parse(req.response);
        stuff.forEach(el => {
          // console.log(el); // prints whole element
          //console.log(el.name); // allows access to specific value

          // adding title to the body of the page
          let elem = document.createElement('div');
          let header = document.createElement('h3');
          header.textContent = "Recipe name: " + el.name;
          elem.appendChild(header);

          let procedure=document.createElement('p');
          procedure.textContent = "Procedure: " + el.procedure;
          elem.appendChild(procedure);

          el.ingredients.forEach(ingredient => {
            console.log(ingredient) // print all ingredients for each recipe
            let name = document.createElement('p');
            let quantity= document.createElement('p');
            name.textContent = "Ingredient: " + ingredient.name;
            quantity.textContent = "Quantity: " + ingredient.quantity;
            elem.appendChild(name);
            elem.appendChild(quantity);
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
  req.open("GET", "http://35.230.142.245:9000/getAllRecipes");
  req.send();
}
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
  req.open("GET", "http://35.230.142.245:9000/getAllRecipes");
  req.send();
}
function submitIngredient(){
  let elements = document.getElementById("ingredientsForm").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
  req.open("POST", "http://35.230.142.245:9000/createIngredient");
  req.onload = () => {
    if (req.status === 200 && req.readyState == 4) {
      console.log("Server Responded with: " + req.responseText);
    } else {
      console.log("Oops...");
    }
  };
  req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  req.send(JSON.stringify({ name: obj.name, quantity: obj.quantity, recipe:{ id: Number(obj.recipeId)} }));
}
function submitRecipe(){
  let elements = document.getElementById("recipesForm").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
  req.open("POST", "http://35.230.142.245:9000/createRecipe");
  req.onload = () => {
    if (req.status === 200 && req.readyState == 4) {
      console.log("Server Responded with: " + req.responseText);
    } else {
      console.log("Oops...");
    }
  };
  req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  req.send(JSON.stringify({ recipe: obj.recipe, name: obj.name, procedure: obj.procedure }));
}
function deleteRecipe(){
  let elements = document.getElementById("deleteRecipe").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
let x=obj.id;
 req.open("DELETE", ('http://35.230.142.245:9000/deleteRecipeById?id='+x));
 req.send();

}

function deleteIngredient(){
  let elements = document.getElementById("deleteIngredient").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
  let x=obj.id;
  req.open("DELETE", ('http://35.230.142.245:9000/deleteIngredientsById?id='+x));
  req.send();

}
function updateRecipe(){
  let elements = document.getElementById("recipesForm").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
  let x=obj.id;
  req.open("PUT", ('http://35.230.142.245:9000/updateRecipe?id='+x));
  req.onload = () => {
    if (req.status === 200 && req.readyState == 4) {
      console.log("Server Responded with: " + req.responseText);
    } else {
      console.log("Oops...");
    }
  };
  req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  req.send(JSON.stringify({ recipe: obj.recipe, name: obj.name, procedure: obj.procedure }));
}