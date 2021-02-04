# API Spec

## Create Product

Request:
- Method: POST
- Endpoint: `/api/products`
- Header:
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "id": "string, unique",
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```
- Response
```json
{
  "status": "integer",
  "message":"string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Product

Request:
- Method: GET
- Endpoint: `/api/products/{product_id}`
- Header:
    - Accept: application/json
- Response
```json
{
  "status": "integer",
  "message": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Update Product

Request:
- Method: PUT
- Endpoint: `/api/products/{product_id}`
- Header:
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```
- Response
```json
{
  "status": "integer",
  "message": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Product

Request:
- Method: GET
- Endpoint: `/api/products`
- Header:
    - Accept: application/json
- Query Param:
    - size: integer
    - page: integer
- Response
```json
{
  "status": "integer",
  "message": "string",
  "data": [
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}
```

## Delete Product

Request:
- Method: DELETE
- Endpoint: `/api/products/{product_id}`
- Header:
    - Accept: application/json
- Response
```json
{
  "status": "integer",
  "message": "string"
}
```