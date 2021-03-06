!-- This is used to create Orders for existing customers

Narrative:
In order to migrate inflight Daily Mail Display Orders
As a Sales Representative
I want to load all missing/separately record orders into CCI via glue 

Scenario: Place an order using existing customer account

Meta:
@author Srinivasa Kuncha
@tags feature: DM Display Orders

Given Sales rep is on the Salesforce home page
When Sales rep login to glue as Mail user by supplying [username] and [password]
When Sales rep search for customer account and place order using csv [file]
Then Sales rep should see customer account with associated orders in glue

Examples:
|username												|password				|file											|
|srinivasa.kuncha@mailnewspapers.co.uk.prodmirror		|amma1234				|src\main\resources\datamigration.csv			|