
function updateIngredient(){
  let elements = document.getElementById("ingredientsForm").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
  let x=obj.id;
  req.open("PUT", ('http://localhost:9000/updateIngredient?id='+x));
  req.onload = () => {
    if (req.status === 200 && req.readyState == 4) {
      console.log("Server Responded with: " + req.responseText);
    } else {
      console.log("Oops...");
    }
  };
  req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  req.send(JSON.stringify({  id: obj.id, name: obj.name, quantity: obj.quantity, recipe:{ id: Number(obj.recipeId)} }));
}