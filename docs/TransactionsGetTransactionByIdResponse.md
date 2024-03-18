

# TransactionsGetTransactionByIdResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountTransactionUrl** | **String** | Link to the transaction resource. |  |
|**postDatetime** | **OffsetDateTime** | When the transaction was posted. |  |
|**balanceChangeDirection** | [**BalanceChangeDirectionEnum**](#BalanceChangeDirectionEnum) | Specifies the direction of a balance change. |  |
|**transactionOriginType** | [**TransactionOriginTypeEnum**](#TransactionOriginTypeEnum) | Specifies the origin of a balance change, for example a payment |  |
|**paymentUrl** | **String** | Link to the payment resource. |  [optional] |
|**reference** | **String** |  |  [optional] |
|**accountUrl** | **String** | Link to the bank account resource. |  |
|**balanceChange** | [**BalanceChangeProperty1**](BalanceChangeProperty1.md) |  |  |
|**accountBalance** | [**AccountBalanceProperty4**](AccountBalanceProperty4.md) |  |  |



## Enum: BalanceChangeDirectionEnum

| Name | Value |
|---- | -----|
| CREDIT | &quot;credit&quot; |
| DEBIT | &quot;debit&quot; |



## Enum: TransactionOriginTypeEnum

| Name | Value |
|---- | -----|
| INTEREST | &quot;interest&quot; |
| DEPOSIT | &quot;deposit&quot; |
| FEE | &quot;fee&quot; |
| TRANSFER | &quot;transfer&quot; |
| PAYMENT | &quot;payment&quot; |
| COMMISSION | &quot;commission&quot; |



