document.addEventListener('DOMContentLoaded', () => {

const createImage = function(className, name, favouriteFood, srcValue, container) {
      let unorderedList = document.createElement('ul');
      let nameli = document.createElement('li');
      let favouriteFoodli = document.createElement('li');
      let imageli = document.createElement('li');
      let image = document.createElement('img');

      nameli.textContent = `Name: ${name}`;
      favouriteFoodli.textContent = `Favourite food: ${favouriteFood}`;

      image.src = srcValue;
      image.width = "500";
      unorderedList.className = className;

      unorderedList.appendChild(nameli);
      unorderedList.appendChild(favouriteFoodli);
      imageli.appendChild(image);
      unorderedList.appendChild(imageli);
      container.appendChild(unorderedList);
}

  const container = document.querySelector('#cats');

  // createImage("cat","Charlie", "GoCat",'../images/IMG_1717.JPG', container);

  const catArray = [["Boba",
                      "Sock Fluff",
                      "http://66.media.tumblr.com/d1f01bbe0150fda0c40d2151c5eaeac8/tumblr_odlqqskjj61v9cejwo1_400.jpg"],
                    ["Barnaby",
                      "Tuna",
                      "https://68.media.tumblr.com/88d0fcf2b84a7b098dda839130597569/tumblr_okuo4teiql1uhevdso1_1280.jpg"],
                    ["Max",
                      "Whiskas Tempations",
                      "http://66.media.tumblr.com/7c5784ea89369c780e782bf10c60315a/tumblr_npb0hlYwhV1u63jaco1_1280.jpg"],
                    ["Charlie",
                      "GoCat",
                      "../images/IMG_1717.JPG"]];

  // for(let i = 0; i<4; i++) {
  //   createImage("cat", catArray[i][0], catArray[i][1], catArray[i][2], container);
  // }

  catArray.forEach(cat => {createImage("cat", cat[0], cat[1], cat[2], container)});

});
