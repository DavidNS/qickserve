# Qikserve

Simulated checkout system for a local supermarket based on QikServe.pdf requirements. Backend is written in Java. Client simulation is thought cli in `client.sh`.

## Install and run

./start.sh

**Note:** The system requires "wiremock" server running to be able to retrieve correctly data. (located in ./wiremock folder)
**Note:** Installation process requires sudo privileges (Needs to install jq)

## Assumptions 

- User stories only specify about adding items. Deletion of items feature was not added.
- Prices are expressed in pennies and are not rounded. It is not specified how should be treated.
- Only the first promotion of array will be considered. I am not sure about how to apply priority order in promotions and could be mutually exclusive.
- It is supposed that the price of items and promotions do not change during shopping process. It includes more complexity and, as same as in the previous assumption, it also would be not be clear how to apply promotions in order.
- No session/machine/login identification mechanism is provided. The exercise does not mention any related.