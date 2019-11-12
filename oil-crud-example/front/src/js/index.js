var bookList = [];
var List = Vue.extend({
  template: '#book-list',
  data: function () {
    $.ajaxSettings.async = false;
    $.getJSON("http://localhost:10080/book/get_all",function(result){
      bookList = result;
    });
    return {bookList: bookList, searchKey: ''};
  },
  computed : {
    filteredBookList: function () {
      var self = this;
      console.log();
      return self.bookList.filter(function (book) {
        return book.name.indexOf(self.searchKey) !== -1
      })
    }
  }
});
var AddBook = Vue.extend({
  template: '#add-book',
  data: function () {
    return {book: {name: '', bookDetail:{descr: ''}, press:{id: 1}}
    }
  },
  methods: {
    createBook: function() {
      var book = this.book;
      $.ajax({
        type : "POST",
        url : "http://localhost:10080/book/add",
        data : JSON.stringify(book),
        contentType : "application/json",
        //dataType : "json",
        complete:function(result) {
          console.info(result);
          router.push('/');
        }
      });

    }
  }
});

var BookDelete = Vue.extend({
  template: '#book-delete',
  data: function () {
    return {book: findBook(this.$route.params.book_id)};
  },
  methods: {
    deleteBook: function () {
      $.getJSON("http://localhost:10080/book/delete?id="+this.book.id,function(result){
        console.info(result.responseText);
      });
      router.push('/');
    }
  }
});
function findBook (bookId) {
  return bookList[findBookKey(bookId)];
};

function findBookKey (bookId) {
  for (var key = 0; key < bookList.length; key++) {
    if (bookList[key].id == bookId) {
      return key;
    }
  }
};

var BookEdit = Vue.extend({
  template: '#book-edit',
  data: function () {
    return {book: findBook(this.$route.params.book_id)};
  },
  methods: {
    updateBook: function() {
      var book = this.book;
      $.ajax({
        type : "POST",
        url : "http://localhost:10080/book/edit",
        data : JSON.stringify(book),
        contentType : "application/json",
        //dataType : "json",
        complete:function(result) {
          console.info(result);
          router.push('/');
        }
      });

    }
  }
});
var BookView = Vue.extend({
  template: '#book-view',
  data: function () {
    return {book: findBook(this.$route.params.book_id)};
  }
});
var router = new VueRouter({
  routes: [{path: '/', component: List},
    {path: '/book/:book_id', component: BookView, name: 'book-view'},
    {path: '/add-book', component: AddBook},
    {path: '/book/:book_id/edit', component: BookEdit, name: 'book-edit'},
    {path:   '/book/:book_id/delete', component: BookDelete, name: 'book-delete'}
]});

new Vue({
  el: '#app',
  router: router,
  template: '<router-view></router-view>'
});
