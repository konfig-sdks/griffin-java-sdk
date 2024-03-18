

# RiskRatingEntry1


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**riskRatingUrl** | **String** | A contextual link to the risk rating. |  |
|**riskRating** | [**RiskRatingEnum**](#RiskRatingEnum) |  |  |
|**legalPersonUrl** | **String** | A contextual link to the [legal person](http://docs.griffin.com). |  |
|**notes** | **String** | Rationale for overriding the risk rating. |  [optional] |
|**manuallyCreatedBy** | [**OpsUserProperty**](OpsUserProperty.md) |  |  [optional] |
|**verificationUrl** | **String** | A link to the [verification](http://docs.griffin.com). |  [optional] |
|**previousRiskRating** | [**PreviousRiskRatingEnum**](#PreviousRiskRatingEnum) |  |  [optional] |



## Enum: RiskRatingEnum

| Name | Value |
|---- | -----|
| HIGH_RISK | &quot;high-risk&quot; |
| PROHIBITED_RISK | &quot;prohibited-risk&quot; |
| MEDIUM_RISK | &quot;medium-risk&quot; |
| LOW_RISK | &quot;low-risk&quot; |



## Enum: PreviousRiskRatingEnum

| Name | Value |
|---- | -----|
| HIGH_RISK | &quot;high-risk&quot; |
| PROHIBITED_RISK | &quot;prohibited-risk&quot; |
| MEDIUM_RISK | &quot;medium-risk&quot; |
| LOW_RISK | &quot;low-risk&quot; |



