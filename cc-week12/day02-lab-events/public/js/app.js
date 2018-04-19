const handleFormSubmit = function (event) {
  event.preventDefault();
  const inputTitle = this.title.value;
  const inputAuthor = this.author.value;
  const inputGenre = this.genre.value;
  // const categorySelect = this.category.value;

  let options = document.getElementsByName('category');
  let categorySelect = 0;
  for(let i = 0; i < options.length; i++) {
    if(options[i].checked) {
      categorySelect = options[i].value;
    }
  }

  const bookDetails = document.querySelector('#book-list')
  // bookDetails.textContent = `Title: ${inputTitle}\n Author: ${inputAuthor}`;
  addBook(inputTitle, inputAuthor, categorySelect, inputGenre, bookDetails);
  console.dir(categorySelect);


}

const addBook = function (title, author, category, subject, container) {
let bookListItem = document.createElement('li');
bookListItem.textContent = `Title: ${title} Author: ${author} Category: ${category} Subject: ${subject}`;
container.appendChild(bookListItem);

document.getElementById("book-form").reset();

}

const validate = function () {
  if (document.form.title === "") {
    alert("Please enter a title");
    document.form.title.focus();
    return false;
  }
  if (document.form.author === "" ) {
     alert("Please enter an author");
     document.form.author.focus();
     return false;
  }
  return true;
}


document.addEventListener('DOMContentLoaded', () => {


  const form = document.querySelector('#book-form');
  form.addEventListener('submit', handleFormSubmit);


});
