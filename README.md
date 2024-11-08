Android Calculator App

A simple Android calculator app built in Java, designed to perform basic arithmetic operations. This app is ideal for beginners to learn about Android layouts, button handling, and UI interactions. The app features a traditional calculator layout with a clear function and a switchable text alignment option.
Features

    Basic Arithmetic Operations: Perform addition, subtraction, multiplication, and division.
    Clear Function: A "Clear" button labeled "Tyhjennä" to reset input and output.
    Switchable Text Alignment: Toggle switch to change the text alignment of the display between left and right.
    User-Friendly Layout: TableLayout used to organize calculator buttons in a structured grid, similar to a standard calculator.
    Error Handling: Displays error messages for invalid operations (e.g., division by zero).

Screenshots

Installation

    Clone the repository:

    git clone https://github.com/yourusername/Android-Calculator-App.git

    Open the project in Android Studio.
    Build and run the project on an Android emulator or a physical device.

Usage

    Perform Calculations: Press the number and operator buttons to build an expression. Press = to calculate the result.
    Clear Input: Press the "Tyhjennä" button to reset the calculator display.
    Toggle Alignment: Use the switch labeled "Align Right" to toggle text alignment on the display:
        When on, text aligns to the right.
        When off, text aligns to the left.

Project Structure

    CalculatorActivity.java: Main activity that contains all logic for button handling, calculations, and alignment switching.
    activity_calculator.xml: XML layout file defining the calculator’s UI structure, including the display, buttons, and switch.
    styles.xml: Contains custom styles for buttons and other UI elements to match a calculator design.

Code Highlights

    TableLayout: Used to arrange calculator buttons in rows and columns.
    Switch for Text Alignment: Includes a Switch component that allows users to toggle the alignment of the calculator's display.
    Error Handling: Shows "Error" when the user tries to perform operations like division by zero.

Future Improvements

    Scientific Mode: Add functions like square root, exponentiation, and trigonometric operations.
    History Log: Display a history of calculations for reference.
    Dark Mode Support: Add support for dark mode by updating themes and styles.
    Improved Error Handling: Better messaging for invalid inputs or operations.

Contributing

    Fork the repository.
    Create a new branch:

git checkout -b feature-branch

Make your changes and commit:

git commit -m "Add new feature"

Push to your branch:

    git push origin feature-branch

    Create a pull request.

License

This project is licensed under the MIT License.
