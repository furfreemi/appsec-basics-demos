window.onload = function() {

    var postTextArea = document.getElementById('postContent');

    function getPostText() {
        return postTextArea.value;
    }

    function postText() {
        fetch("/", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
              postContent: getPostText()
            })
        }).then(function() { location.reload() });
    }

    document.getElementById('postButton').onclick = postText;
}
