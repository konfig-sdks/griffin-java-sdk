

# Verification1


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**verificationUrl** | **String** | A link to the [verification](http://docs.griffin.com). |  |
|**updatedAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  [optional] |
|**legalPersonUrl** | **String** | A contextual link to the [legal person](http://docs.griffin.com). |  |
|**workflowUrl** | **String** | A link to the [workflow](http://docs.griffin.com). |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**verificationChecksUrl** | **String** |  |  |
|**riskRating** | [**RiskRatingEnum**](#RiskRatingEnum) |  |  [optional] |
|**verificationStatus** | [**VerificationStatusEnum**](#VerificationStatusEnum) |  |  |
|**verificationRiskAssessmentsUrl** | **String** |  |  [optional] |



## Enum: RiskRatingEnum

| Name | Value |
|---- | -----|
| HIGH_RISK | &quot;high-risk&quot; |
| PROHIBITED_RISK | &quot;prohibited-risk&quot; |
| MEDIUM_RISK | &quot;medium-risk&quot; |
| LOW_RISK | &quot;low-risk&quot; |



## Enum: VerificationStatusEnum

| Name | Value |
|---- | -----|
| IN_PROGRESS | &quot;in-progress&quot; |
| PENDING | &quot;pending&quot; |
| CHECKS_DECLINED | &quot;checks-declined&quot; |
| CHECKS_COMPLETE | &quot;checks-complete&quot; |
| FAILED | &quot;failed&quot; |



