var handle = document.querySelector('.row__handle');
handle.addEventListener('click', function(event) {
	event.stopPropagation()
	console.log('clicked')
})

var rows = document.querySelectorAll('.row')
var form = document.querySelector('.body__form')
rows.forEach(function(x) {
    x.addEventListener('click', function() {
        const childRow = x.childNodes;
        const childForm = form.childNodes;
        for (let i = 0; i < childForm.length; i++) {
            console.log(childForm[i].type)
			childForm[i].value = childRow[i].textContent
			console.log(childForm[i])
        }
    })
});

