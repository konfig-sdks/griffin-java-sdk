

# BankAccountsUpdateBankAccountResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountSubmissionsUrl** | **String** | Link to the [payment submissions](http://docs.griffin.com) debiting from this account. |  |
|**accountRestricted** | **Boolean** | Specifies whether the bank account has restrictions applied by Griffin. |  |
|**accountPaymentsUrl** | **String** | Link to the [payments](http://docs.griffin.com) associated with this account. |  |
|**pooledAccountMembershipsUrl** | **String** | Link to the list of [pool members](http://docs.griffin.com) associated with this account. |  [optional] |
|**accountAdmissionsUrl** | **String** | Link to the [payment admissions](http://docs.griffin.com) crediting to this account. |  |
|**bankProductType** | [**BankProductTypeEnum**](#BankProductTypeEnum) | Specifies the type of bank account. (For more detail on bank account types, see our guide for [creating a bank account](http://docs.griffin.com).) |  |
|**displayName** | **String** | The mutable display name for the bank account |  |
|**controllerUrl** | **String** | Link to the [legal person](http://docs.griffin.com) that represents the [controller](http://docs.griffin.com) of the account. |  |
|**pooledFunds** | **Boolean** | Specifies whether the bank account holds funds belonging to multiple beneficiaries. |  |
|**accountStatus** | [**AccountStatusEnum**](#AccountStatusEnum) | Shows the status of the account. An account can be moved between statuses during its lifecycle. The status value affects the operations that you can perform. An account must be &#x60;\&quot;open\&quot;&#x60; to be fully operational. |  |
|**clientMoneyType** | [**ClientMoneyTypeEnum**](#ClientMoneyTypeEnum) | Specifies the type of client money account. |  [optional] |
|**ownerUrl** | **String** | Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**closeAccountUrl** | **String** | Link to the endpoint that enables account closure for this account. |  |
|**availableBalance** | [**AvailableBalanceProperty1**](AvailableBalanceProperty1.md) |  |  |
|**pooledAccountMembershipUpdatesUrl** | **String** | Link to manage [pooled account membership](http://docs.griffin.com). |  [optional] |
|**bankAddresses** | [**List&lt;BankAddress1&gt;**](BankAddress1.md) | Shows a collection of public addresses which uniquely identify the account. Any one of these can be used to pay into the account. |  [optional] |
|**accountTransactionsUrl** | **String** | Link to the [transactions](http://docs.griffin.com) associated with this account. |  |
|**accountUrl** | **String** | Link to the bank account resource. |  |
|**beneficiaryUrl** | **String** | Link to the [legal person](http://docs.griffin.com) that represents the [beneficiary](http://docs.griffin.com) of the account. |  [optional] |
|**accountBalance** | [**AccountBalanceProperty1**](AccountBalanceProperty1.md) |  |  |
|**savingsType** | [**SavingsTypeEnum**](#SavingsTypeEnum) | Specifies the type of savings account. |  [optional] |



## Enum: BankProductTypeEnum

| Name | Value |
|---- | -----|
| SAVINGS_ACCOUNT | &quot;savings-account&quot; |
| CLIENT_MONEY_ACCOUNT | &quot;client-money-account&quot; |
| SAFEGUARDING_ACCOUNT | &quot;safeguarding-account&quot; |
| OPERATIONAL_ACCOUNT | &quot;operational-account&quot; |



## Enum: AccountStatusEnum

| Name | Value |
|---- | -----|
| CLOSING | &quot;closing&quot; |
| OPEN | &quot;open&quot; |
| CLOSED | &quot;closed&quot; |
| OPENING | &quot;opening&quot; |



## Enum: ClientMoneyTypeEnum

| Name | Value |
|---- | -----|
| DESIGNATED_CLIENT_FUND | &quot;designated-client-fund&quot; |
| DESIGNATED_CLIENT_MONEY | &quot;designated-client-money&quot; |
| GENERAL_CLIENT_MONEY | &quot;general-client-money&quot; |



## Enum: SavingsTypeEnum

| Name | Value |
|---- | -----|
| EASY_ACCESS | &quot;easy-access&quot; |



