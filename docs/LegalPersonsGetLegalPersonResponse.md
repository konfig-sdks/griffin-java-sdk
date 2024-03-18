

# LegalPersonsGetLegalPersonResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**latestDecision** | [**LatestDecisionProperty1**](LatestDecisionProperty1.md) |  |  [optional] |
|**legalPersonType** | [**LegalPersonTypeEnum**](#LegalPersonTypeEnum) | Specifies if the legal person is an &#x60;individual&#x60; or a &#x60;corporation&#x60;. |  |
|**latestRiskRatingUrl** | **String** | A contextual link to the risk rating. |  [optional] |
|**displayName** | **String** | The mutable display name for the Legal-Person |  |
|**applicationStatus** | [**ApplicationStatusEnum**](#ApplicationStatusEnum) | Status of the current [application](http://docs.griffin.com) |  [optional] |
|**legalPersonUrl** | **String** | A contextual link to the [legal person](http://docs.griffin.com). |  |
|**legalPersonDecisionsUrl** | **String** | Link to [decisions](http://docs.griffin.com) for this [legal person](http://docs.griffin.com). |  |
|**statusChangedAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**legalPersonClaimsUrl** | **String** | Link to the [claims](http://docs.griffin.com) for this [legal person](http://docs.griffin.com). |  [optional] |
|**legalPersonBankPayeesUrl** | **String** | Link to the [payees](http://docs.griffin.com) for this [legal person](http://docs.griffin.com). |  [optional] |
|**legalPersonVerificationsUrl** | **String** | Link to all [verifications](http://docs.griffin.com) run against this [legal person](http://docs.griffin.com). |  |
|**legalPersonDocumentsUrl** | **String** | Link to all evidence documents associated with this [legal person](http://docs.griffin.com). |  |



## Enum: LegalPersonTypeEnum

| Name | Value |
|---- | -----|
| INDIVIDUAL | &quot;individual&quot; |
| CORPORATION | &quot;corporation&quot; |



## Enum: ApplicationStatusEnum

| Name | Value |
|---- | -----|
| REFERRED | &quot;referred&quot; |
| ERRORED | &quot;errored&quot; |
| DECLINED | &quot;declined&quot; |
| SUBMITTED | &quot;submitted&quot; |
| ACCEPTED | &quot;accepted&quot; |



