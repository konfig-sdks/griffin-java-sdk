

# WebhooksSendTestEventResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**webhookRequestStatus** | [**WebhookRequestStatusEnum**](#WebhookRequestStatusEnum) |  |  |
|**updatedAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**webhookHttpStatus** | **Long** |  |  [optional] |
|**webhookErrorCode** | [**WebhookErrorCodeEnum**](#WebhookErrorCodeEnum) |  |  [optional] |



## Enum: WebhookRequestStatusEnum

| Name | Value |
|---- | -----|
| DEFAULT | &quot;default&quot; |



## Enum: WebhookErrorCodeEnum

| Name | Value |
|---- | -----|
| TIMEOUT | &quot;webhook-timeout&quot; |
| UNKNOWN_HOST | &quot;webhook-unknown-host&quot; |
| UNKNOWN_ERROR | &quot;webhook-unknown-error&quot; |
| INVALID_RESPONSE | &quot;webhook-invalid-response&quot; |



