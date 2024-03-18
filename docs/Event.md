

# Event


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**eventUrl** | **String** | Link to the [event](http://docs.griffin.com). |  |
|**eventType** | [**EventTypeEnum**](#EventTypeEnum) | The type of webhook event. Usually has the form {resource}-{operation}, e.g. payment-updated |  |
|**eventPayload** | **Object** |  |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  [optional] |



## Enum: EventTypeEnum

| Name | Value |
|---- | -----|
| DECISION_CREATED | &quot;decision-created&quot; |
| PAYMENT_CREATED | &quot;payment-created&quot; |
| TRANSACTION_CREATED | &quot;transaction-created&quot; |
| VERIFICATION_UPDATED | &quot;verification-updated&quot; |
| ADMISSION_UPDATED | &quot;admission-updated&quot; |
| VERIFICATION_CREATED | &quot;verification-created&quot; |
| ACCOUNT_STATUS_UPDATED | &quot;account-status-updated&quot; |
| SUBMISSION_CREATED | &quot;submission-created&quot; |
| TEST_EVENT | &quot;test-event&quot; |
| ADMISSION_CREATED | &quot;admission-created&quot; |
| ACCOUNT_STATUS_CREATED | &quot;account-status-created&quot; |
| SUBMISSION_UPDATED | &quot;submission-updated&quot; |



