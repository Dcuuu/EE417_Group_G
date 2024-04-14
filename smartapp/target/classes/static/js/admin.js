function handleLoginFormSubmission(formId, redirectUrl) {
    document.getElementById(formId).addEventListener('submit', function(e) {
        e.preventDefault();

        const username = document.querySelector(`#${formId} input[name="username"]`).value;
        const password = document.querySelector(`#${formId} input[name="password"]`).value;
        
        //alert(username + password);

        const data = {
            username: username,
            password: password
        };

        fetch('/admin/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) throw new Error('Login failed');
            return response.json();
        })
        .then(data => {
            if (data.success) {
				setLoggedInStatus(true);
                window.location.href = redirectUrl;
            } else {
                alert('Invalid login credentials.');
            }
        })
        .catch(error => {
            console.error('Login Error:', error);
            alert(error.message);
        });
    });
}

document.addEventListener('DOMContentLoaded', function() {
	handleLoginFormSubmission('admin-form', '/admin2.html');
});



