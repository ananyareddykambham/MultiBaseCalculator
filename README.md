# Multi-Base Number System Calculator

## Project Overview
The Multi-Base Number System Calculator is a Java-based, menu-driven console application that performs arithmetic operations on numbers represented in different number systems.

The application converts values between number systems, performs calculations, validates user input, and displays results in the selected number system.

## Objectives
- Support multiple number systems.
- Perform basic arithmetic operations.
- Validate user input and handle errors.
- Provide a simple, user-friendly console interface.

## Supported Number Systems
- Decimal (Base 10)
- Binary (Base 2)
- Octal (Base 8)
- Hexadecimal (Base 16)
- Roman Numerals

## Arithmetic Operations
- Addition (`+`)
- Subtraction (`-`)
- Multiplication (`*`)
- Division (`/`)

Division uses integer arithmetic, so any fractional part of the result is discarded.

## Features
- Menu-driven console interface.
- Selection of a number system before performing calculations.
- Input validation for number systems and operators.
- Error handling for invalid inputs and division by zero.
- Option to exit the application.

## Project Structure

```text
MultiBaseCalculator/
├── README.md
└── src/
    ├── main/
    │   └── Main.java
    ├── numbersystems/
    ├── operations/
    └── exceptions/
```

## Technologies Used
- Java
- Visual Studio Code
- Git and GitHub

## How to Run

### Prerequisites
- Java Development Kit (JDK) installed.
- Git (optional, if cloning the repository).

### 1. Clone the Repository

```bash
git clone https://github.com/ananyareddykambham/MultiBaseCalculator.git
cd MultiBaseCalculator
```

If you already have the project on your computer, open its folder in the terminal instead.

### 2. Compile the Source Files

Run this command from the project root directory in Windows PowerShell:

```powershell
javac -d out src\exceptions\*.java src\numbersystems\*.java src\operations\*.java src\main\Main.java
```

### 3. Run the Application

```powershell
java -cp out main.Main
```

## Usage
1. Select a number system from the menu.
2. Enter an arithmetic operator (`+`, `-`, `*`, or `/`).
3. Enter the first and second numbers in the selected system.
4. View the result in that number system.
5. Continue calculating or choose the exit option.

## Testing
The application has been tested with:
- Arithmetic operations across all five supported number systems.
- Valid and invalid number inputs.
- Invalid menu choices and operators.
- Division by zero.
- Zero and negative results.
- Integer division.

## Team Contributions
Team responsibilities are being documented as development progresses.

**My contribution:** Implemented the menu-driven console interface in `src/main/Main.java`, integrated it with the calculator logic, handled user input and exceptions, and tested the main features.

## Project Status
The core number-system classes, arithmetic operations, exception handling, and console interface have been integrated and tested. Further improvements and testing may be added as development continues.
