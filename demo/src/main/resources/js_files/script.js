function validateForm() {
    // Get the mobile number input value
    const phoneInput = document.getElementById('phone');
    const phoneError = document.getElementById('phone-error');
    const phonePattern = /^[0-9]{10,15}$/;

    // Check if the phone number matches the pattern
    if (!phonePattern.test(phoneInput.value)) {
        phoneError.textContent = "Please enter a valid mobile number (10 to 15 digits).";
        return false; // Prevent form submission
    }

    // If the phone number is valid
    phoneError.textContent = "";
    alert("Form submitted successfully!");
    return true;
}
