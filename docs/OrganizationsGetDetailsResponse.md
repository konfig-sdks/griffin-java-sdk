

# OrganizationsGetDetailsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ownLegalPersonUrl** | **String** | Link to the [legal person](http://docs.griffin.com) that represents the [organization](http://docs.griffin.com); this can be an individual or a company. |  |
|**organizationMode** | [**OrganizationModeEnum**](#OrganizationModeEnum) | The organization can either be a sandbox organization or a live one; Check out our guide for [sandbox mode vs live mode](http://docs.griffin.com). |  |
|**organizationMembershipsUrl** | **String** | Link to the [memberships](http://docs.griffin.com) for this [organization](http://docs.griffin.com). |  |
|**organizationInvitationsUrl** | **String** | Link to the resource that enables you to [invite](http://docs.griffin.com) new [users](http://docs.griffin.com) to this [organization](http://docs.griffin.com). |  |
|**organizationOnboardingApplicationsUrl** | **String** | Link to the [Reliance onboarding](http://docs.griffin.com). |  [optional] |
|**displayName** | **String** | The mutable display name for the Organisation |  |
|**organizationApiKeysUrl** | **String** |  |  |
|**organizationLiveAccessUrl** | **String** | Link to the resource that enables you to request live access. |  |
|**organizationWebhooksUrl** | **String** | Link to the endpoint which enables webhook creation. |  |
|**organizationWorkflowsUrl** | **String** | Link to the onboarding [workflows](http://docs.griffin.com) configured for this [organization](http://docs.griffin.com). |  |
|**organizationBankAccountsUrl** | **String** | Link to the [bank accounts](http://docs.griffin.com) managed by this [organization](http://docs.griffin.com). |  |
|**availableRoles** | [**List&lt;Role4&gt;**](Role4.md) | The subset of [roles](http://docs.griffin.com) available to [members](http://docs.griffin.com) of this [organization](http://docs.griffin.com). |  |
|**organizationUrl** | **String** | Link to the [organization](http://docs.griffin.com). |  |
|**organizationIndividualsUrl** | **String** |  |  |
|**organizationCorporationsUrl** | **String** |  |  |
|**organizationLegalPersonsUrl** | **String** | Link to the [legal persons](http://docs.griffin.com) grouped under this [organization](http://docs.griffin.com). |  |
|**organizationEventsUrl** | **String** | Link to the endpoint which lists an organization&#39;s events. |  |



## Enum: OrganizationModeEnum

| Name | Value |
|---- | -----|
| TEST_MODE | &quot;test-mode&quot; |
| LIVE_MODE | &quot;live-mode&quot; |



