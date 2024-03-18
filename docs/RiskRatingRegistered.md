

# RiskRatingRegistered


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**legalPersonHistoryEventType** | [**LegalPersonHistoryEventTypeEnum**](#LegalPersonHistoryEventTypeEnum) |  |  |
|**timestamp** | **OffsetDateTime** | Date time of this event. |  |
|**riskRating** | [**RiskRatingEnum**](#RiskRatingEnum) |  |  [optional] |
|**notes** | **String** | Rationale for overriding the risk rating. |  [optional] |
|**manuallyCreatedBy** | [**OpsUserProperty**](OpsUserProperty.md) |  |  [optional] |
|**previousRiskRating** | [**PreviousRiskRatingEnum**](#PreviousRiskRatingEnum) |  |  [optional] |
|**decisionOutcome** | [**DecisionOutcomeEnum**](#DecisionOutcomeEnum) |  |  [optional] |
|**decisionNotes** | **String** | Free-text field to explain the reasons behind the decision. |  [optional] |
|**verificationUrl** | **String** | A link to the [verification](http://docs.griffin.com). |  [optional] |
|**decisionMaker** | [**DecisionMakerEnum**](#DecisionMakerEnum) | Indicates if the decision was automated or made by a human. |  [optional] |
|**decisionUserUrl** | **String** | Link to the [user](http://docs.griffin.com) that made the decision (if applicable). |  [optional] |
|**decisionOpsUser** | [**DecisionOpsUserEnum**](#DecisionOpsUserEnum) | Indicates that an Ops user has created the decision. |  [optional] |
|**decisionUserUsername** | **String** | Username of the [user](http://docs.griffin.com) that made the decision (if applicable). |  [optional] |



## Enum: LegalPersonHistoryEventTypeEnum

| Name | Value |
|---- | -----|
| RISK_RATING_REGISTERED | &quot;risk-rating-registered&quot; |



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



## Enum: DecisionOutcomeEnum

| Name | Value |
|---- | -----|
| ACCEPTED | &quot;accepted&quot; |
| DECLINED | &quot;declined&quot; |



## Enum: DecisionMakerEnum

| Name | Value |
|---- | -----|
| SYSTEM | &quot;system&quot; |
| OPS_USER | &quot;ops-user&quot; |
| USER | &quot;user&quot; |



## Enum: DecisionOpsUserEnum

| Name | Value |
|---- | -----|
| GRIFFIN_OPS_USER | &quot;griffin-ops-user&quot; |



