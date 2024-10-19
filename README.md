# WebAutomationFramework

## Overview
This repository contains a web automation testing framework built using Java and Selenium WebDriver. It is designed to support testing of web applications with scalability and parallel execution capabilities.

## Features
- Supports multiple browsers (Chrome, Firefox).
- Implements the Page Object Model (POM) design pattern for maintainability.
- Extensible and scalable structure for adding new test cases and web elements.

## Prerequisites
- **Java 11+**
- **Maven** for managing dependencies
- **Selenium WebDriver**: Ensure drivers are set up for Chrome and Firefox
- **TestNG** for test management

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/YzeedShahin/WebAutomationFramwork.git
2. Install dependencies:
   ```bash
   mvn clean install
3. Browser drivers:
   Make sure you have chrome and fireFox drivers downloaded on your machine, The `DriverManager` will handle the paths
