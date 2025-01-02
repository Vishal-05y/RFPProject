// JavaScript File: script.js

// Toggle between User Login and Admin Login Forms
function toggleLogin(type) {
    const userLogin = document.getElementById("user-login");
    const adminLogin = document.getElementById("admin-login");

    if (type === "user") {
        userLogin.style.display = "block";
        adminLogin.style.display = "none";
    } else if (type === "admin") {
        adminLogin.style.display = "block";
        userLogin.style.display = "none";
    }
}

// Validate Signup Form
function validateForm() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const rePassword = document.getElementById("re-password").value;

    // Basic validation for email format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    // Password length validation
    if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return false;
    }

    // Password match validation
    if (password !== rePassword) {
        alert("Passwords do not match. Please try again.");
        return false;
    }

    alert("Signup form submitted successfully!");
    return true; // Allow form submission
}

// Validate Login Form (for both user and admin)
function validateLogin(type) {
    const email = document.getElementById(`${type}-email`).value;
    const password = document.getElementById(`${type}-password`).value;

    // Hardcoded password for demonstration (replace this with actual backend authentication)
    const correctPassword = "password123"; // Replace with a call to your server

    // Basic validation for email format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert(`Please enter a valid email address for ${type}.`);
        return false;
    }

    // Password validation
    if (password === correctPassword) {
        // Redirect to a new page
        window.location.href = "/dashboard.html"; // Change to the desired URL
        return true; // Allow form submission
    } else {
        // Display error message
        alert("Incorrect password. Please try again.");
        return false; // Prevent form submission
 
    }
}
