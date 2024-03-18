

# DebtorProperty2


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** | Must be a UK BBAN. |  |
|**accountNumberCode** | [**AccountNumberCodeEnum**](#AccountNumberCodeEnum) |  |  |
|**bankId** | **String** | Must be a UK Sort Code. |  |
|**bankIdCode** | [**BankIdCodeEnum**](#BankIdCodeEnum) |  |  |
|**accountHolder** | **String** | The name of the [account holder](http://docs.griffin.com). |  [optional] |
|**accountUrl** | **String** | Link to the bank account resource. |  [optional] |



## Enum: AccountNumberCodeEnum

| Name | Value |
|---- | -----|
| BBAN | &quot;bban&quot; |



## Enum: BankIdCodeEnum

| Name | Value |
|---- | -----|
| GBDSC | &quot;gbdsc&quot; |



