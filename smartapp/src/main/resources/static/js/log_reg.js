function showRegister() {
    document.getElementById('login-box').style.display = 'none';
    document.getElementById('register-box').style.display = 'block';
  }

 function showLogin() {
    document.getElementById('login-box').style.display = 'block';
    document.getElementById('register-box').style.display = 'none';
  }
  
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

// Mathew
function handleRegisterFormSubmission(formId, redirectUrl) {
    document.getElementById(formId).addEventListener('submit', function(e) {
        e.preventDefault();

        const username = document.querySelector(`#${formId} input[id="register-username"]`).value;
        const password = document.querySelector(`#${formId} input[id="register-password"]`).value;
        const address = document.querySelector(`#${formId} input[id="register-address"]`).value;
        const phoneNumber = document.querySelector(`#${formId} input[id="register-phone-number"]`).value;
        const email = document.querySelector(`#${formId} input[id="register-email"]`).value;
        const repeatPassword = document.querySelector(`#${formId} input[id="register-repeat-password"]`).value;

        var capitalLetterRegex = /[A-Z]/;
        var numberRegex = /[0-9]/;
        var phoneRegex = /^[\d\s()+-]+$/;
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        // Validation logic. Password ones can be changed to whatever seems logical
        if (!phoneRegex.test(phoneNumber)) {
            alert("Invalid phone number format.");
            return;
        }

        if (!emailRegex.test(email)) {
            alert("Please enter a valid email address.");
            return;
        }

        if (password !== repeatPassword) {
            alert('Passwords do not match.');
            return;
        }
        if (password.length < 8) {
            alert("Password must be at least 8 characters long.");
            return;
        }
        if (!capitalLetterRegex.test(password) || !numberRegex.test(password)) {
            alert("Password must contain at least one capital letter and one number.");
            return;
        }

        const data = {
            username: username,
            password: password,
            address: address,
            phoneNumber: phoneNumber,
            email: email
        };

        fetch('/admin/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) throw new Error("User already registered");
            return response.json();
        })
        .then(data => {
            if (data.success) {
				alert('Registration Successful. You may now login');
                window.location.href = redirectUrl;
            } else {
                alert('Registration failed. Please try again.');
            }
        })
        .catch(error => {
            console.error('Registration Error:', error);
            alert(error.message);
        });
    });
}

document.addEventListener('DOMContentLoaded', function() {
	handleLoginFormSubmission('login-form', '/index.html');
	handleRegisterFormSubmission('register-form', '/login.html');
});

