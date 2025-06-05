drop database if exists storematedb;
-- Create the database (if it doesn't exist)
CREATE DATABASE IF NOT EXISTS storematedb;

-- Use the database
USE storematedb;

-- Drop tables if they exist (in correct dependency order)
DROP TABLE IF EXISTS FollowUps;
DROP TABLE IF EXISTS Leads;
DROP TABLE IF EXISTS OrderItems;
DROP TABLE IF EXISTS CustomerOrders;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Suppliers;
DROP TABLE IF EXISTS Barcode;

-- Create the Suppliers table
CREATE TABLE Suppliers (
    SupplierID INT AUTO_INCREMENT PRIMARY KEY,
    SupplierName VARCHAR(255) NOT NULL,
    SupplierContact VARCHAR(255),
    SupplierAddress VARCHAR(255),
    SupplierEmail VARCHAR(255)
);

-- Create the Categories table
CREATE TABLE Categories (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(255) NOT NULL UNIQUE
);

-- Create the Products table
CREATE TABLE Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    ProductDescription TEXT,
    CategoryID INT NOT NULL,
    SupplierID INT NOT NULL,
    ProductPrice DECIMAL(10, 2) NOT NULL,
    ProductStock INT NOT NULL,
    LastStockAt DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) ON DELETE RESTRICT,
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID) ON DELETE RESTRICT
);

-- Create the Barcode table
CREATE TABLE Barcodes (
	BarcodeID INT AUTO_INCREMENT PRIMARY KEY,
    Barcode BIGINT NOT NULL,
    ProductID INT NOT NULL,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)  ON DELETE CASCADE
);

-- Create the Customers table
CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerFirstName VARCHAR(255) NOT NULL,
    CustomerLastName VARCHAR(255) NOT NULL,
    CustomerContact VARCHAR(255),
    CustomerEmail VARCHAR(255) UNIQUE,
    CustomerAddress VARCHAR(255),
    CustomerDOB DATE
);

-- Create the CustomerOrders table
CREATE TABLE CustomerOrders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    OrderTotal DECIMAL(10, 2) NOT NULL,
    OrderStatus VARCHAR(50) DEFAULT 'Pending',
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE
);

-- Create the OrderItems table
CREATE TABLE OrderItems (
    OrderItemID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT NOT NULL,
    ProductID INT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES CustomerOrders(OrderID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) ON DELETE RESTRICT
);

-- Create the Leads table
CREATE TABLE Leads (
    LeadID INT AUTO_INCREMENT PRIMARY KEY,
    LeadName VARCHAR(255),
    Contact VARCHAR(255),
    LeadFrom VARCHAR(100),
    Email VARCHAR(255),
    Status VARCHAR(50),
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Create the FollowUps table
CREATE TABLE FollowUps (
    FollowUpID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    FollowUpDate DATETIME NOT NULL,
    Purpose TEXT,
    Status VARCHAR(50),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE
);

-- 1. Insert Suppliers
INSERT INTO Suppliers (SupplierName, SupplierContact, SupplierAddress, SupplierEmail ) VALUES
('Acme Corp', '555-123-4567', '123 Main St, Anytown, USA', 'info@acmecorp.com' ),
('Beta Co', '555-987-6543', '456 Oak Ave, Somecity, USA', 'sales@betaco.com'),
('Gamma Ltd', '555-246-8012', '789 Pine Ln, Othertown, USA', 'support@gammaltd.com');

-- 2. Insert Categories
INSERT INTO Categories (CategoryName) VALUES
('Electronics'),
('Clothing'),
('Jewelry');

-- 3. Insert Products
INSERT INTO Products (ProductName, ProductDescription, CategoryID, SupplierID, ProductPrice, ProductStock , LastStockAt) VALUES
('Laptop X1000', 'High-performance laptop with 16GB RAM, 512GB SSD', 1, 1, 1200.00, 50 , '1990-05-15'),
('T-Shirt Basic', 'Comfortable cotton t-shirt in various colors', 2, 2, 15.99, 100, '1990-05-17'),
('Diamond Ring', 'Elegant 1-carat diamond ring in platinum setting', 3, 3, 2500.00, 10, '1990-06-14'),
('Smartphone Z5', 'Latest smartphone with 5G, 128GB storage', 1, 1, 900.00, 30, '1990-03-15'),
('Jeans Classic Fit', 'Classic fit jeans made from durable denim', 2, 2, 49.99, 75, '1990-05-15'),
('Gold Necklace', '18K gold necklace with a delicate design', 3, 3, 1800.00, 15, '1990-05-15');

INSERT INTO Barcodes (Barcode , ProductID) VALUES
(1234567890, 1),
(2345678901, 2),
(3456789012, 3),
(4567890123, 4),
(5678901234, 5);

-- 4. Insert Customers
INSERT INTO Customers (CustomerFirstName, CustomerLastName, CustomerContact, CustomerEmail, CustomerAddress, CustomerDOB) VALUES
('John', 'Doe', '555-111-2222', 'john.doe@example.com', '100 Main St, Anytown, USA', '1990-05-15'),
('Jane', 'Smith', '555-333-4444', 'jane.smith@example.com', '200 Oak Ave, Somecity, USA', '1985-10-20'),
('Robert', 'Jones', '555-555-6666', 'robert.jones@example.com', '300 Pine Ln, Othertown, USA', '1992-03-10');

-- 5. Insert Customer Orders
INSERT INTO CustomerOrders (CustomerID, OrderTotal, OrderStatus) VALUES
(1, 1200.00, 'Completed'),  -- John Doe
(2, 65.98, 'Shipped'),      -- Jane Smith
(3, 2500.00, 'Pending');    -- Robert Jones

-- 6. Insert Order Items
INSERT INTO OrderItems (OrderID, ProductID, Quantity, Price) VALUES
(1, 1, 1, 1200.00), -- John Doe bought 1 Laptop X1000
(2, 2, 2, 15.99), -- Jane Smith bought 2 T-Shirts
(2, 5, 1, 49.99), -- Jane Smith bought 1 Jeans Classic Fit
(3, 3, 1, 2500.00); -- Robert Jones bought 1 Diamond Ring


-- 9. Insert Leads
INSERT INTO Leads (LeadName, Contact, LeadFrom, Email, Status) VALUES
('Emily Clark', '555-777-8888', 'Website', 'emily.clark@leadmail.com', 'New'),
('Michael Brown', '555-888-9999', 'Referral', 'michael.brown@leadmail.com', 'Contacted'),
('Sara Lee', '555-222-3333', 'Instagram Ad', 'sara.lee@leadmail.com', 'Converted');

-- 11. Insert Follow-Ups
INSERT INTO FollowUps (CustomerID, FollowUpDate, Purpose, Status) VALUES
(1, '2025-06-01 10:00:00', 'Check satisfaction after recent purchase', 'Pending'),
(2, '2025-06-02 15:00:00', 'Offer discount on clothing', 'Done'),
(3, '2025-06-03 12:00:00', 'Finalize EMI plan', 'Pending');


select * from OrderItems;

DELETE FROM Customers WHERE CustomerLastName ='R';

use storematedb;