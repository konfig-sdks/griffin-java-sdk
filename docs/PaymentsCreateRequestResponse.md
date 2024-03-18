

# PaymentsCreateRequestResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**creditor** | [**PayeeProperty2**](PayeeProperty2.md) |  |  |
|**paymentDirection** | [**PaymentDirectionEnum**](#PaymentDirectionEnum) | Whether the payment is moving money into or out of the account. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**paymentUrl** | **String** | Link to the payment resource. |  |
|**paymentReference** | **String** | Free-text field to help identify and categorise payments. |  [optional] |
|**paymentAmount** | [**PaymentAmountProperty2**](PaymentAmountProperty2.md) |  |  |
|**ultimateDebtor** | [**UltimateDebtorProperty1**](UltimateDebtorProperty1.md) |  |  [optional] |
|**paymentAdmissionsUrl** | **String** | Link to the endpoint for listing payment admissions. |  [optional] |
|**paymentSubmissionsUrl** | **String** | Link to the endpoint for creating and listing payment submissions. |  [optional] |
|**debtor** | [**DebtorProperty1**](DebtorProperty1.md) |  |  |



## Enum: PaymentDirectionEnum

| Name | Value |
|---- | -----|
| INBOUND_PAYMENT | &quot;inbound-payment&quot; |
| OUTBOUND_PAYMENT | &quot;outbound-payment&quot; |



