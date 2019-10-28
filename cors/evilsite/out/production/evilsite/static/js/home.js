window.onload = function() {
    var controlledFacePalmUrl = 'http://localhost:8080/';
    var openFacePalmUrl = 'http://localhost:8081/';
    var currentFactDiv = document.getElementById('currentFact');

    function postToOpenFacePalm(postContent) {
        postTextTo(openFacePalmUrl, postContent);
    }

    function postToControlledFacePalm(postContent) {
        postTextTo(controlledFacePalmUrl, postContent);
    }

    function postTextTo(url, postContent) {
        fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
              postContent: postContent
            })
        });
    }

    var currentFact = currentFactDiv.textContent;
    postToOpenFacePalm("heyyo! " + currentFact);
    postToControlledFacePalm("heyyo! " + currentFact);
}
