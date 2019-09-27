"use strict";

(function($) {
    var request = $.ajax({'url': '/posts.json'});
    request.done(function (posts) {
        var html = '';
        var postsArray = [];
        posts.forEach(function(post) {
            html += '<div class = "posts">';
            html += '<h1>' + post.title + '</h1>';
            html += '<p>' + post.body + '</p>';
            html += '<p>Published by ' + post.author.username + '</p>';
            html += '</div>';

            postsArray.push({id:post.id, name:post.title, body:post.body, author:post.author.username},)


        });
        $('#posts').html(html);
    });
})(jQuery);

function filterPosts() {
    
}

