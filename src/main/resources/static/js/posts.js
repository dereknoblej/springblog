"use strict";

(function($) {

    var arrayPosts = [];

    var postsArray = $.ajax({'url': '/posts.json'});

     postsArray.done(function (posts) {
        var html = '';

        posts.forEach(function(post) {
            // html += '<div class = "posts">';
            // html += '<h1>' + post.title + '</h1>';
            // html += '<p>' + post.body + '</p>';
            // html += '<p>Published by ' + post.author.username + '</p>';
            // html += '</div>';

            arrayPosts.push({id: post.id, name: post.title, body: post.body, author: post.author.username})


        });

         var nameSearch = document.getElementById("search");

         function filterPosts(arrayPosts){


             var filteredPosts = [];


             for(var i = 0; i <= arrayPosts.length; i++){

                 if(arrayPosts[i].name.toUpperCase().indexOf(nameSearch.toUpperCase()) > -1){

                     filteredPosts.push(arrayPosts[i])
                 }

             }

             for(var n = 0; n <= filteredPosts.length; n++){

                console.log(filteredPosts[n].name)
             }


         }

         filterPosts(arrayPosts);


         nameSearch.addEventListener("input",filterPosts);





        // $('#posts').html(html);

        return postsArray;
    });



})(jQuery);

//
// const mainArr = () => {
//     fetch("http://localhost:8080/p
//
//
// const newArr = (data) => {
//     data.map((arr1) => {
//         console.log(arr1)
//     })
// }
//
// console.log(newArr(mainArr()))
//
//

// const baseurl = "http://localhost:8080/posts.json"
//
// fetch(baseurl).then((response) => console.log(response.json()));
//
// console.log("Hello World")