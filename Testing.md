### Step-by-Step Guide to Testing with Thunder Client

#### 1. **Install Thunder Client Extension**

1. **Open VS Code**:
   Launch Visual Studio Code on your machine.

2. **Go to Extensions**:
   Click on the Extensions icon in the sidebar or press `Ctrl+Shift+X`.

3. **Search for Thunder Client**:
   Type "Thunder Client" in the search bar.

4. **Install**:
   Click on the "Install" button next to the Thunder Client extension.

#### 2. **Configure Your Spring Boot Application**

1. **Start Your Application**:
   Ensure your Spring Boot application is running. You can run it from the terminal with `mvn spring-boot:run` or use the play button in your IDE.

2. **Check the Base URL**:
   Note the base URL of your API. Typically, it would be something like `http://localhost:8080`.

#### 3. **Open Thunder Client**

1. **Open Thunder Client**:
   Click on the Thunder Client icon in the sidebar (a lightning bolt).

2. **Create a New Request**:
   Click on the "New Request" button or use the `+` icon to create a new request.

#### 4. **Testing Endpoints**

Here’s how to test each entity’s endpoints using Thunder Client:

1. **Test Cart Endpoints**

   - **GET All Carts**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/carts`
     - **Send**: Click "Send" to retrieve all carts.

   - **GET Cart by ID**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/carts/{id}`
     - Replace `{id}` with an actual cart ID.
     - **Send**: Click "Send" to retrieve a specific cart.

   - **POST Create Cart**:

     - **Method**: POST
     - **URL**: `http://localhost:8080/carts`
     - **Body**: Select "JSON" and enter the JSON object to create a cart. Example:
       ```json
       {
         "customer": { "userId": 1 },
         "cartItems": []
       }
       ```
     - **Send**: Click "Send" to create a new cart.

   - **DELETE Cart by ID**:
     - **Method**: DELETE
     - **URL**: `http://localhost:8080/carts/{id}`
     - Replace `{id}` with an actual cart ID.
     - **Send**: Click "Send" to delete the cart.

2. **Test CartItems Endpoints**

   - **GET All CartItems**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/cartitems`
     - **Send**: Click "Send" to retrieve all cart items.

   - **GET CartItems by ID**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/cartitems/{cartId}/{productId}`
     - Replace `{cartId}` and `{productId}` with actual IDs.
     - **Send**: Click "Send" to retrieve specific cart items.

   - **POST Create CartItems**:

     - **Method**: POST
     - **URL**: `http://localhost:8080/cartitems`
     - **Body**: Select "JSON" and enter the JSON object to create cart items. Example:
       ```json
       {
         "id": { "cartId": 1, "pId": 1 },
         "quantity": 2,
         "price": 100.0
       }
       ```
     - **Send**: Click "Send" to create new cart items.

   - **DELETE CartItems by ID**:
     - **Method**: DELETE
     - **URL**: `http://localhost:8080/cartitems/{cartId}/{productId}`
     - Replace `{cartId}` and `{productId}` with actual IDs.
     - **Send**: Click "Send" to delete cart items.

3. **Test Category Endpoints**

   - **GET All Categories**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/categories`
     - **Send**: Click "Send" to retrieve all categories.

   - **GET Category by ID**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/categories/{id}`
     - Replace `{id}` with an actual category ID.
     - **Send**: Click "Send" to retrieve a specific category.

   - **POST Create Category**:

     - **Method**: POST
     - **URL**: `http://localhost:8080/categories`
     - **Body**: Select "JSON" and enter the JSON object to create a category. Example:
       ```json
       {
         "name": "Electronics",
         "picture": "electronics.jpg",
         "description": "All electronic items"
       }
       ```
     - **Send**: Click "Send" to create a new category.

   - **DELETE Category by ID**:
     - **Method**: DELETE
     - **URL**: `http://localhost:8080/categories/{id}`
     - Replace `{id}` with an actual category ID.
     - **Send**: Click "Send" to delete the category.

4. **Test Customer Endpoints**

   - **GET All Customers**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/customers`
     - **Send**: Click "Send" to retrieve all customers.

   - **GET Customer by ID**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/customers/{id}`
     - Replace `{id}` with an actual customer ID.
     - **Send**: Click "Send" to retrieve a specific customer.

   - **POST Create Customer**:

     - **Method**: POST
     - **URL**: `http://localhost:8080/customers`
     - **Body**: Select "JSON" and enter the JSON object to create a customer. Example:
       ```json
       {
         "name": "John Doe",
         "email": "john.doe@example.com",
         "password": "password123"
       }
       ```
     - **Send**: Click "Send" to create a new customer.

   - **DELETE Customer by ID**:
     - **Method**: DELETE
     - **URL**: `http://localhost:8080/customers/{id}`
     - Replace `{id}` with an actual customer ID.
     - **Send**: Click "Send" to delete the customer.

5. **Test Orders Endpoints**

   - **GET All Orders**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/orders`
     - **Send**: Click "Send" to retrieve all orders.

   - **GET Order by ID**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/orders/{id}`
     - Replace `{id}` with an actual order ID.
     - **Send**: Click "Send" to retrieve a specific order.

   - **POST Create Order**:

     - **Method**: POST
     - **URL**: `http://localhost:8080/orders`
     - **Body**: Select "JSON" and enter the JSON object to create an order. Example:
       ```json
       {
         "customer": { "userId": 1 },
         "cart": { "cartId": 1 },
         "orderAmount": 150.0,
         "orderDate": "2024-08-30T12:00:00"
       }
       ```
     - **Send**: Click "Send" to create a new order.

   - **DELETE Order by ID**:
     - **Method**: DELETE
     - **URL**: `http://localhost:8080/orders/{id}`
     - Replace `{id}` with an actual order ID.
     - **Send**: Click "Send" to delete the order.

6. **Test Payment Endpoints**

   - **GET All Payments**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/payments`
     - **Send**: Click "Send" to retrieve all payments.

   - **GET Payment by ID**:

     - **Method**: GET
     - **URL**: `http://localhost:8080/payments/{id}`
     - Replace `{id}` with an actual payment ID.
     - **Send**: Click "Send" to retrieve a specific payment.

   - **POST Create Payment**:

     - **Method**: POST
     - **URL**: `http://localhost:8080/payments`
     - **Body**: Select "JSON" and enter the JSON object to create a payment. Example:
       ```json
       {
         "orders": { "orderId": 1 },
         "type": "Credit Card",
         "amount": 150.0
       }
       ```
     - **Send**: Click "Send" to create a new payment.

   - **DELETE Payment by ID**:
     - **Method**: DELETE
     - **URL**: `http://localhost:8080/payments/{id}`
     - Replace `{id}` with an actual payment

ID. - **Send**: Click "Send" to delete the payment.

7. **Verify Responses and Errors**

   - **Check Responses**:
     After sending a request, check the response status code and body to ensure the endpoint is working as expected. For example:

     - **200 OK**: Successful GET or POST request.
     - **201 Created**: Resource successfully created.
     - **204 No Content**: Successful DELETE request.
     - **404 Not Found**: Resource not found.
     - **500 Internal Server Error**: Server error.

   - **Handle Errors**:
     If you encounter errors, review your request configuration and check the server logs for more information.

8. **Save and Organize Requests**

   - **Save Requests**:
     Thunder Client allows you to save requests for future use. Click on the "Save" button and provide a name and description for the request.

   - **Organize Requests**:
     Group related requests into folders for better organization and easier access.

By following these steps, you can thoroughly test the various endpoints of your e-commerce application using Thunder Client in VS Code. If you have any specific issues or need further customization, feel free to ask!
