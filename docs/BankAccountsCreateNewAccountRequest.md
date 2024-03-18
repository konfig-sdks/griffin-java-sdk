

# BankAccountsCreateNewAccountRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ownerUrl** | **String** | Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account. |  [optional] |
|**savingsType** | [**SavingsTypeEnum**](#SavingsTypeEnum) | Specifies the type of savings account. |  [optional] |
|**displayName** | **String** | A human readable label for an entity |  [optional] |
|**bankProductType** | [**BankProductTypeEnum**](#BankProductTypeEnum) |  |  |



## Enum: SavingsTypeEnum

| Name | Value |
|---- | -----|
| EASY_ACCESS | &quot;easy-access&quot; |



## Enum: BankProductTypeEnum

| Name | Value |
|---- | -----|
| SAVINGS_ACCOUNT | &quot;savings-account&quot; |



