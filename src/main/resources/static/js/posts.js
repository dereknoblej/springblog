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
function filterPosts(){

    arrayPosts.forEach(function(posts, i) {

        console.log(posts)
        console.log(i);

    });

}

filterPosts();


})(jQuery);





