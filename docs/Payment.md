

# Payment


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**creditor** | [**PayeeProperty1**](PayeeProperty1.md) |  |  |
|**paymentDirection** | [**PaymentDirectionEnum**](#PaymentDirectionEnum) | Whether the payment is moving money into or out of the account. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**paymentUrl** | **String** | Link to the payment resource. |  |
|**paymentReference** | **String** | Free-text field to help identify and categorise payments. |  [optional] |
|**paymentAmount** | [**PaymentAmountProperty1**](PaymentAmountProperty1.md) |  |  |
|**ultimateDebtor** | [**UltimateDebtorProperty**](UltimateDebtorProperty.md) |  |  [optional] |
|**paymentAdmissionsUrl** | **String** | Link to the endpoint for listing payment admissions. |  [optional] |
|**paymentSubmissionsUrl** | **String** | Link to the endpoint for creating and listing payment submissions. |  [optional] |
|**debtor** | [**DebtorProperty**](DebtorProperty.md) |  |  |



## Enum: PaymentDirectionEnum

| Name | Value |
|---- | -----|
| INBOUND_PAYMENT | &quot;inbound-payment&quot; |
| OUTBOUND_PAYMENT | &quot;outbound-payment&quot; |



