

# PaymentsGetSubmissionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**submissionStatus** | [**SubmissionStatusEnum**](#SubmissionStatusEnum) | Specifies the progress of the outbound payment. |  |
|**submissionSchemeInformation** | [**FpsProperty1**](FpsProperty1.md) |  |  |
|**paymentUrl** | **String** | Link to the payment resource. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**submissionUrl** | **String** |  |  |



## Enum: SubmissionStatusEnum

| Name | Value |
|---- | -----|
| FAILED | &quot;failed&quot; |
| PROCESSING | &quot;processing&quot; |
| RETURNED | &quot;returned&quot; |
| DELIVERED | &quot;delivered&quot; |



