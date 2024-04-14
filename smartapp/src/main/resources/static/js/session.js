
// Function to update the menu bar based on login status
function updateMenuBar() {

    if (isUserLoggedIn()) {
        // If user is logged in, change "Login" link to "Sign Out"
        var loginLink = document.querySelector('.main-nav .nav-list li a[href="login.html"]');
        loginLink.textContent = "Sign Out";
        loginLink.onclick = setLoggedOutStatus; // Assign the handleLogout function to the click event
    } else {
        // If user is not logged in, revert "Sign Out" link to "Login"
        loginLink.textContent = "Login";
        loginLink.href = "login.html"; // Link to the login page
        loginLink.onclick = null; // Remove any previous click event handler
    }
}

// Store login status in localStorage
function setLoggedInStatus() {
    localStorage.setItem("isLoggedIn", "true");
    updateMenuBar();
}

// Function to handle logout
function setLoggedOutStatus() {
    localStorage.setItem('isLoggedIn', "false");
    updateMenuBar(); // Call a function to update the menu bar, for example
}

function isUserLoggedIn() {
    // Check the sign-in status from local storage
    return localStorage.getItem("isLoggedIn") === "true";
}

document.addEventListener("DOMContentLoaded", function() {
	// Log the login status upon page load for debugging
    console.log("Is user logged in?", isUserLoggedIn());
    updateMenuBar(); // Update navigation bar on page load
});
