
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
