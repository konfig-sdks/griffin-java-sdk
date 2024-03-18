

# PaymentsGetDetailsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**creditor** | [**PayeeProperty4**](PayeeProperty4.md) |  |  |
|**paymentDirection** | [**PaymentDirectionEnum**](#PaymentDirectionEnum) | Whether the payment is moving money into or out of the account. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**paymentUrl** | **String** | Link to the payment resource. |  |
|**paymentReference** | **String** | Free-text field to help identify and categorise payments. |  [optional] |
|**paymentAmount** | [**PaymentAmountProperty4**](PaymentAmountProperty4.md) |  |  |
|**ultimateDebtor** | [**UltimateDebtorProperty3**](UltimateDebtorProperty3.md) |  |  [optional] |
|**paymentAdmissionsUrl** | **String** | Link to the endpoint for listing payment admissions. |  [optional] |
|**paymentSubmissionsUrl** | **String** | Link to the endpoint for creating and listing payment submissions. |  [optional] |
|**debtor** | [**DebtorProperty3**](DebtorProperty3.md) |  |  |



## Enum: PaymentDirectionEnum

| Name | Value |
|---- | -----|
| INBOUND_PAYMENT | &quot;inbound-payment&quot; |
| OUTBOUND_PAYMENT | &quot;outbound-payment&quot; |



