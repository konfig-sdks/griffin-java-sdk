

# Admission1


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**admissionStatus** | [**AdmissionStatusEnum**](#AdmissionStatusEnum) | Specifies the progress of the inbound payment. |  |
|**admissionSchemeInformation** | [**FpsProperty**](FpsProperty.md) |  |  |
|**paymentUrl** | **String** | Link to the payment resource. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**admissionUrl** | **String** |  |  |



## Enum: AdmissionStatusEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;processing&quot; |
| RETURNED | &quot;returned&quot; |
| DELIVERED | &quot;delivered&quot; |



