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
