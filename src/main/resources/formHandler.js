document.getElementById('newUserForm').addEventListener('submit', function (ev) {
    ev.preventDefault();

    // Get the values of the name and email input fields
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

    // Create the user object with the values
    const user = { name: name, email: email };

    // Send the POST request using fetch
    fetch('/user', { // Use relative path, since both frontend and backend are on localhost:8080
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(user)
    })
        .then(response => response.text()) // Handle the response
        .then(data => {
            alert('successfully added');
        })
        .then(newUser => {
            // Here, you can update the table or the DOM to show the newly added user
            // Assuming you have a function to update the table
            addUserToTable(newUser);
        })
        .catch(error => {
            console.error('Error: ', error);
        })

    function addUserToTable(user) {
        // Assuming you have a table with an id of 'userTable'
        const table = document.getElementById('userTable');
        const row = table.insertRow();  // Add a new row at the end of the table

        // Insert cells for name and email
        const cellName = row.insertCell(0);
        const cellEmail = row.insertCell(1);

        cellName.textContent = user.name;  // Set the name in the first column
        cellEmail.textContent = user.email;  // Set the email in the second column
    }

});



