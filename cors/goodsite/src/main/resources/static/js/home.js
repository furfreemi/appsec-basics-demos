window.onload = function() {

    var controlledFacePalmUrl = 'http://localhost:8080/';
    var openFacePalmUrl = 'http://localhost:8081/';

    var postTextArea = document.getElementById('postContent');

    function getPostText() {
        return postTextArea.value;
    }

    function postToOpenFacePalm() {
        postTextTo(openFacePalmUrl);
    }

    function postToControlledFacePalm() {
        postTextTo(controlledFacePalmUrl);
    }

    function postTextTo(url) {
        fetch(url, {
            method: "POST",
            body: JSON.stringify({
              postContent: getPostText()
            }),
            headers: {'Content-Type': 'application/json'}
        });
    }

    document.getElementById('submitContentOpen').onclick = postToOpenFacePalm;
    document.getElementById('submitContentControlled').onclick = postToControlledFacePalm;
}
