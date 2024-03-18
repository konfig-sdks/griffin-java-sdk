

# Payee


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payeeUrl** | **String** | Link to the [payee](http://docs.griffin.com). |  |
|**accountNumber** | **String** | Must be a UK BBAN. |  |
|**accountHolder** | **String** | The name of the [account holder](http://docs.griffin.com). |  |
|**legalPersonUrl** | **String** | A contextual link to the [legal person](http://docs.griffin.com). |  |
|**bankId** | **String** | Must be a UK Sort Code. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**accountUrl** | **String** | Link to the bank account resource. |  [optional] |
|**payeeStatus** | [**PayeeStatusEnum**](#PayeeStatusEnum) | The status of the payee; you can only make payments to active payees. |  |
|**countryCode** | **Object** | ISO 3166-1 alpha-2 two-letter country code. |  |



## Enum: PayeeStatusEnum

| Name | Value |
|---- | -----|
| DEACTIVATED | &quot;deactivated&quot; |
| ACTIVE | &quot;active&quot; |



