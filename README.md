# Project 1 - Salesforce -> MuleSoft -> Mock ERP Customer Sync

This package contains:

- `mulesoft/sf-mule-erp-sync/` - Mule 4 starter app for Project 1
- `mock-erp/` - Spring Boot mock ERP service
- `postman/` - sample request collection and payloads

## What this project demonstrates

- HTTP API exposed by MuleSoft
- API-led style split inside one Mule app (experience, process, system subflows)
- Salesforce Account upsert using `External_Id__c`
- Downstream ERP sync through HTTP
- DataWeave transformations
- Error handling, logging, and Salesforce sync status updates

## Before you run it

### 1) Salesforce setup
Create these fields on **Account** in your Salesforce Developer Org:
- `External_Id__c` (Text, External ID, Unique)
- `ERP_Status__c` (Picklist: Pending, Synced, Failed)
- `Last_ERP_Sync__c` (Date/Time)
- `Integration_Message__c` (Long Text Area)

### 2) Salesforce connected app
Create a Connected App and use OAuth Username Password authentication in Mule.
You need:
- Consumer Key
- Consumer Secret
- Salesforce username
- Salesforce password
- Security token

### 3) Mock ERP
Run the Spring Boot app first on port `8082`.

### 4) Mule config
Copy `mulesoft/sf-mule-erp-sync/src/main/resources/config-local.yaml.template` to `config-local.yaml` and fill in values.

## Import into Anypoint Studio

1. Open Studio.
2. File -> Import -> Anypoint Studio -> Anypoint Studio project from File System.
3. Select `mulesoft/sf-mule-erp-sync/`.
4. If Studio asks for missing modules, add/update:
   - HTTP Connector
   - Salesforce Connector
5. Open `customer-sync.xml`.
6. Verify the Salesforce global config loads correctly.
7. Run the app.

## Run order

1. Start `mock-erp`
2. Start Mule app
3. Send request to `POST http://localhost:8081/api/customers/sync`

Sample payload:
```json
{
  "externalId": "CUST-1001",
  "name": "Acme Corp",
  "billingCity": "Orlando",
  "billingCountry": "USA"
}
```

## Expected flow

1. Mule validates request
2. Mule upserts Account in Salesforce using `External_Id__c`
3. Mule calls mock ERP `POST /erp/customers`
4. Mule updates Salesforce sync fields to `Synced`
5. Mule returns combined response

## Failure test

Stop the mock ERP and send the same request.
Expected result:
- Mule returns `502`
- Salesforce Account is updated with:
  - `ERP_Status__c = Failed`
  - `Integration_Message__c` with error text

## Notes

- The Mule XML is written as a starter template and is intentionally simple.
- Depending on your Studio build, you might need to open the Salesforce connector config once and reselect the auth type in the UI.
- This package is designed for local learning and resume proof, not production deployment.
# salesforce-mulesoft-customer-sync
