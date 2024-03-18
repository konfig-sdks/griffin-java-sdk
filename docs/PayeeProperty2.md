

# PayeeProperty2


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payeeUrl** | **String** | Link to the [payee](http://docs.griffin.com). |  [optional] |
|**creditorType** | [**CreditorTypeEnum**](#CreditorTypeEnum) |  |  |
|**accountUrl** | **String** | Link to the bank account resource. |  [optional] |
|**accountHolder** | **String** | The name of the [account holder](http://docs.griffin.com). |  [optional] |
|**accountNumber** | **String** | Must be a UK BBAN. |  [optional] |
|**accountNumberCode** | [**AccountNumberCodeEnum**](#AccountNumberCodeEnum) |  |  [optional] |
|**bankId** | **String** | Must be a UK Sort Code. |  [optional] |
|**bankIdCode** | [**BankIdCodeEnum**](#BankIdCodeEnum) |  |  [optional] |



## Enum: CreditorTypeEnum

| Name | Value |
|---- | -----|
| PAYEE | &quot;payee&quot; |



## Enum: AccountNumberCodeEnum

| Name | Value |
|---- | -----|
| BBAN | &quot;bban&quot; |



## Enum: BankIdCodeEnum

| Name | Value |
|---- | -----|
| GBDSC | &quot;gbdsc&quot; |



