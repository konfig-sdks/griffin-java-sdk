

# DecisionsCreateDecisionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**verificationUrl** | **String** | A link to the [verification](http://docs.griffin.com). |  |
|**decisionOutcome** | [**DecisionOutcomeEnum**](#DecisionOutcomeEnum) |  |  |
|**decisionMaker** | [**DecisionMakerEnum**](#DecisionMakerEnum) | Indicates if the decision was automated or made by a human. |  |
|**decisionNotes** | **String** | Free-text field to explain the reasons behind the decision. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**decisionUserUrl** | **String** | Link to the [user](http://docs.griffin.com) that made the decision (if applicable). |  [optional] |
|**decisionUserUsername** | **String** | Username of the [user](http://docs.griffin.com) that made the decision (if applicable). |  [optional] |
|**decisionOpsUser** | [**DecisionOpsUserEnum**](#DecisionOpsUserEnum) | Indicates that an Ops user has created the decision. |  [optional] |



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



