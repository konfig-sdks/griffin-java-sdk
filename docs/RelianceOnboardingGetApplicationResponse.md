

# RelianceOnboardingGetApplicationResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**onboardingApplicationUrl** | **String** | Link to the onboarding application. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**workflowUrl** | **String** | A link to the [workflow](http://docs.griffin.com). |  |
|**legalPersonUrl** | **String** | A contextual link to the [legal person](http://docs.griffin.com). |  [optional] |
|**verificationUrl** | **String** | A link to the [verification](http://docs.griffin.com). |  [optional] |
|**onboardingApplicationStatus** | [**OnboardingApplicationStatusEnum**](#OnboardingApplicationStatusEnum) |  |  |
|**decisionOutcome** | [**DecisionOutcomeEnum**](#DecisionOutcomeEnum) |  |  [optional] |



## Enum: OnboardingApplicationStatusEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;processing&quot; |



## Enum: DecisionOutcomeEnum

| Name | Value |
|---- | -----|
| ACCEPTED | &quot;accepted&quot; |
| DECLINED | &quot;declined&quot; |



