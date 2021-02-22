var handle = document.querySelector('.row__handle');
handle.addEventListener('click', function(event) {
	event.stopPropagation()
})

var rows = document.querySelectorAll('.row')
var form = document.querySelector('.body__form')
rows.forEach(function(x) {
    x.addEventListener('click', function() {
        const childRow = x.childNodes;
        const childForm = form.childNodes;
        for (let i = 0; i < 8; i++) {
            childForm[i].value = childRow[i].textContent
			console.log(childForm[i])
        }
    })
});

