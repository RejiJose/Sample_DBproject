//Note: The components.js file includes code to create a Modal, Gallery, FlipCard and Collapsible

// Data contains the hero name, image file name and description.
  let data = [
  {name:"HULK",img:"hulk.png",description:"The Hulk is a superhero appearing in American comic books published by Marvel Comics"},
  
  {name:"IRONMAN",img:"ironman.png",description:"Iron Man is a superhero appearing in American comic books published by Marvel Comics."},
  
  {name:"BLACK PANTHER",img:"blackpanther.jpg",description:"T'Challa is the king of Wakanda, the secretive and highly advanced African nation, as well as the powerful warrior known as the Black Panther."},
  ]


/*
Problem:
Use the array of Hero information (JSON) called 'data' above, which includes the name, image file name and description, to build a flip card for each hero.

Have the front of the card display the image of the hero and the back of the card display the name as a header with a description below it.

Add the card to the container "flipcard_output"
*/
window.onload = function(){
  let back = "";
  let front = "";
  
  for(let i=0; i<data.length; i++){
    let hero = data[i];
    front = `<img src='images/${hero.img}'>`;

    back = `<h2>${hero.name}</h2>`;
    back+= `<p>${hero.description}</p>`;
    back+= `<hr>`;

    let card = new FlipCard(front, back);
    card.render("flipcard_output");
  } 
}
