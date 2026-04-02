# Salesforce to ERP Sync with MuleSoft

## Overview
This project demonstrates a MuleSoft integration that receives Salesforce customer data, transforms it, and sends it to a mock ERP API.

## Use Case
When a customer is created or updated in Salesforce, MuleSoft processes the payload, maps the fields, and forwards it to the ERP system.

## Architecture
Salesforce → MuleSoft Process Flow → Mock ERP API

## Tech Stack
- MuleSoft 4
- DataWeave 2.0
- Salesforce Connector
- HTTP Request / Listener
- Maven
- Java 17

## What This Project Covers
- Salesforce connector usage
- Mule flow design
- DataWeave transformation
- Error handling
- Logging
- End-to-end API testing

## Project Structure
- `src/main/mule/` → Mule flows
- `src/main/resources/` → properties
- `sample-data/` → sample request/response payloads
- `screenshots/` → flow and test screenshots
- `docs/` → optional design notes

## Prerequisites
- Anypoint Studio
- Java 17
- Mule runtime compatible with project
- Salesforce Developer Org
- Postman or curl

## Configuration
Create a local `config.properties` file with:
- Salesforce username
- Salesforce password
- Security token
- Login URL

Do not commit real credentials.

## How to Run
1. Import project into Anypoint Studio
2. Update local properties
3. Run as Mule Application
4. Test endpoints using Postman/curl

## Sample Endpoints
### Create Account
`POST /account`

### Get Account
`GET /account/{id}`

## Sample Request
See `sample-data/create-account-request.json`

## Sample Response
See `sample-data/create-account-response.json`

## Screenshots
See `screenshots/`

## Future Improvements
- Add update/delete flows
- Add retry strategy
- Add Bulk API version
- Add secure properties