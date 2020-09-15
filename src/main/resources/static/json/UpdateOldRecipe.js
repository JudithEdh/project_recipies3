
function updateRecipe(){
  let elements = document.getElementById("recipesForm").elements;
  let obj ={};
  for(let i = 0 ; i < elements.length - 1 ; i++){
    let item = elements.item(i);
    obj[item.name] = item.value;
  }

  const req = new XMLHttpRequest();
  let x=obj.id;
  req.open("PUT", ('http://localhost:9000/updateRecipe?id='+x));
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