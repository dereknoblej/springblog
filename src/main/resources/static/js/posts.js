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

            arrayPosts.push({id:post.id, name:post.title, body:post.body, author:post.author.username},)


        });
        // $('#posts').html(html);

        return postsArray;
    });

     console.log(arrayPosts);






function filterPosts(arrayPosts){

    console.log(arrayPosts)



    arrayPosts.forEach(function(post) {
        post.title.forEach(function (name) {
            console.log(name.toString())
        })
    });

}

filterPosts(arrayPosts);


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





