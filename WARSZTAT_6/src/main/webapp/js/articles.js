document.addEventListener("DOMContentLoaded", function(){
    var commentsButtons = document.querySelectorAll(".commentsButton");
    var comments = document.querySelectorAll(".comments");

    commentsButtons.forEach(function(element, index){
        element.addEventListener("click", function(){
            comments[index].classList.toggle("hide");
        })
    })
});