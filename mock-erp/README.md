# Mock ERP

## Run

```bash
mvn spring-boot:run
```

Base URL: `http://localhost:8082`

Endpoints:
- `POST /erp/customers`
- `GET /erp/customers/{externalId}`

Sample request:
```json
{
  "externalId": "CUST-1001",
  "customerName": "Acme Corp",
  "billingCity": "Orlando",
  "billingCountry": "USA",
  "salesforceId": "001xxxxxxxxxxxxAAA",
  "status": "ACTIVE"
}
```
