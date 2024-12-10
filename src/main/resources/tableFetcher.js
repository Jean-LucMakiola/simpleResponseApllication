document.addEventListener('DOMContentLoaded',(ev)=>{
    ev.preventDefault()



    fetch('users', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => response.text()) // Handle the response
        .then(data => {
            let dataString = JSON.parse(data);
            appendJson(dataString)
        })
        .catch(error => {
            console.error('Error: ', error);
        });
})

function appendJson(data){
    let table = document.getElementById('table');
    data.forEach(function (object){
        let tr = document.createElement('tr');
        tr.innerHTML = '<td>' + object.id + '</td>' +
            '<td>'+ object.name +'</td>'+
            '<td>'+object.email+'</td>';
        table.appendChild(tr);
    })
}

