-- Step 1: Create the database
CREATE DATABASE FitnessTracker;

-- Step 2: Use the database
USE FitnessTracker;

-- Step 3: Create Users table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Step 4: Create Activities table
CREATE TABLE Activities (
    activity_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    date DATE NOT NULL,
    workout_duration INT NOT NULL, -- in minutes
    calories_burned INT NOT NULL,
    steps INT NOT NULL,
    water_intake INT NOT NULL, -- in ml
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Step 5: Create Admins table (optional, for system administrators)
CREATE TABLE Admins (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);
-- Insert data into Users table
INSERT INTO Users (name, email, password)
VALUES
('Alice Johnson', 'alice@example.com', 'alice123'),
('Bob Smith', 'bob@example.com', 'bob123'),
('Charlie Brown', 'charlie@example.com', 'charlie123');

-- Insert data into Activities table
INSERT INTO Activities (user_id, date, workout_duration, calories_burned, steps, water_intake)
VALUES
(1, '2025-01-01', 45, 300, 5000, 2000),
(1, '2025-01-02', 60, 400, 7000, 2500),
(2, '2025-01-01', 30, 200, 4000, 1800),
(3, '2025-01-01', 50, 350, 6000, 2200);

-- Insert data into Admins table (optional)
INSERT INTO Admins (name, email, password)
VALUES
('Admin One', 'admin1@example.com', 'admin123'),
('Admin Two', 'admin2@example.com', 'admin234');
