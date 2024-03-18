<div align="left">

[![Visit Griffin](./header.png)](https://griffin.com)

# [Griffin](https://griffin.com)

## Introduction

The Griffin API is based on [REST](https://en.wikipedia.org/wiki/Representational_state_transfer).
It has resource-oriented URLs, accepts [JSON](https://www.json.org/json-en.html)-encoded request bodies, returns [JSON](https://www.json.org/json-en.html)-encoded responses, and uses standard HTTP response verbs and response codes.

Our API deviates from strict RESTful principles if it makes sense to do so, such as when we enforce tighter access controls around certain operations.
For example, when closing a bank account: rather than send a PATCH request to the [bank account](http://docs.griffin.com) resource to update it's status to `"closed"`, we provide a dedicated account closure resource.

Anyone can [create an account](https://app.griffin.com/register) with Griffin and try out out API in [sandbox mode](http://docs.griffin.com).

New to Griffin? Check out our [getting started guide](http://docs.griffin.com).

## Navigation

Our API is designed to be navigated programmatically. When you request any resource, you will find the URLs for related resources in the response body.

The API is structured as a tree with your [organization](http://docs.griffin.com) at the top. Everything that you own will be a sub-resource of your organization.

To bootstrap the navigation process, request the [index](http://docs.griffin.com) endpoint: the response will contain your `organization-url`.

For a walkthrough, see our [getting started guide](http://docs.griffin.com).

## Pagination

Our list APIs support pagination (e.g. [list bank accounts](http://docs.griffin.com) and [list payments](http://docs.griffin.com)).
By default, a list API returns up to 25 results. If there are more results available, the response payload will include links to the previous/next pages.

### Change page size

You can request a different number of results (between 1 and 200, inclusive) by using the `page[size]` query parameter:

```
GET /v0/organizations/:id/bank/accounts?page[size]=100
```

### Navigating between pages

List responses will include a `links` object with `prev` and `next` attributes, as shown below.
Perform a GET request to the value of the attribute to fetch the previous/next page of results.

```
{
  "accounts": [
    // ...
  ],
  "links": {
    "prev": "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts?page[before]=djE6WxSPxfYUTnCU9XtWzj9gGA",
    "next": "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts?page[after]=djE6aw79PXZySUOL16LD8HRJ3A"
  }
}

```
If there is no previous or next page available, the value of the attribute will be  null.

Any other query parameters included in the initial request will also be included in the response payload's links.
If you want to change parameters (see [filtering and sorting](http://docs.griffin.com)), request the first page and follow the links from there.

## Filtering and sorting

### Sort results

By default, resources will be listed in descending order, usually based on the `created-at` attribute.
You can change the sorting behaviour of a list of results by using the `sort` query parameter.

For example, to list bank accounts in ascending order (oldest first):

```
GET /v0/organizations/:id/bank/accounts?sort=created-at
```

To _explicitly_ sort in descending order (newest first), prefix the sort attribute with `-`:

```
GET /v0/organizations/:id/bank/accounts?sort=-created-at
```

### Filter results

Some list APIs allow you to filter the results.
Filters are expressed as nested data structures encoded into query parameters.
For example, you can list bank accounts that are in either the `opening` or `open` state with:

```
GET /v0/organizations/:id/bank/accounts?filter[account-status][in][]=opening&filter[account-status][in][]=open
```

Similarly, you can list legal persons with a specific `application-status`:

```
GET /v0/organizations/:id/legal-persons?filter[application-status][eq]=accepted
```

### Include resources

Some list APIs allow you to include associated resources in the response, reducing the number of requests needed to fetch related data.
For instance, when listing bank accounts, you can include each bank account's beneficiary legal person by using the `include` query parameter:

```
GET /v0/organizations/:id/bank/accounts?include=beneficiary
```

The response returns the usual list of bank accounts, but it will also have an `included` object with a `legal-persons` attribute:

```
{
  "accounts": [
    // ...
  ],
  "links": {
    // ...
  }
  "included": {
    "legal-persons": [
      // ...
    ]
  }
}
```

Check the documentation for each list API to see all options for sorting and filtering

## Versioning

The Griffin API is versioned via a prefix in the URL.
The current version is v0.
An example endpoint is: https://api.griffin.com/v0/index.

We will not break your integration with a particular version for as long as we support that version.
If we release a new version, you will have 12 months to upgrade to it.

</div>

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

If you are adding this library to an Android Application or Library:

3. Android 8.0+ (API Level 26+)

## Installation<a id="installation"></a>
<div align="center">
  <a href="https://konfigthis.com/sdk-sign-up?company=Griffin&language=Java">
    <img src="https://raw.githubusercontent.com/konfig-dev/brand-assets/HEAD/cta-images/java-cta.png" width="70%">
  </a>
</div>

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.konfigthis</groupId>
  <artifactId>griffin-java-sdk</artifactId>
  <version></version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your `build.gradle`:

```groovy
// build.gradle
repositories {
  mavenCentral()
}

dependencies {
   implementation "com.konfigthis:griffin-java-sdk:"
}
```

### Android users

Make sure your `build.gradle` file as a `minSdk` version of at least 26:
```groovy
// build.gradle
android {
    defaultConfig {
        minSdk 26
    }
}
```

Also make sure your library or application has internet permissions in your `AndroidManifest.xml`:

```xml
<!--AndroidManifest.xml-->
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET"/>
</manifest>
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/griffin-java-sdk-.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ApiKeysApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    Object apiKeyName = null; // The name of the API Key. Cannot contain whitespace.
    String organizationId = "organizationId_example";
    try {
      ApiKeysCreateKeyResponse result = client
              .apiKeys
              .createKey(apiKeyName, organizationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getApiKeyUrl());
      System.out.println(result.getApiKeyName());
      System.out.println(result.getApiKeyLiveQuestionMark());
      System.out.println(result.getOrganizationUrl());
      System.out.println(result.getUserUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getApiKeySecret());
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiKeysApi#createKey");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ApiKeysCreateKeyResponse> response = client
              .apiKeys
              .createKey(apiKeyName, organizationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiKeysApi#createKey");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.griffin.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApiKeysApi* | [**createKey**](docs/ApiKeysApi.md#createKey) | **POST** /v0/organizations/{organization-id}/api-keys | Create API Key
*ApiKeysApi* | [**getKeyDetails**](docs/ApiKeysApi.md#getKeyDetails) | **GET** /v0/api-keys/{api-key-id} | Get API key
*ApiKeysApi* | [**listActiveKeys**](docs/ApiKeysApi.md#listActiveKeys) | **GET** /v0/organizations/{organization-id}/api-keys | List API keys
*ApiKeysApi* | [**listActiveKeys_0**](docs/ApiKeysApi.md#listActiveKeys_0) | **GET** /v0/users/{user-id}/api-keys | List API keys
*ApiKeysApi* | [**removeApiKey**](docs/ApiKeysApi.md#removeApiKey) | **DELETE** /v0/api-keys/{api-key-id} | Delete API key
*BankAccountsApi* | [**closeAccount**](docs/BankAccountsApi.md#closeAccount) | **POST** /v0/bank/accounts/{bank-account-id}/actions/close | 
*BankAccountsApi* | [**createNewAccount**](docs/BankAccountsApi.md#createNewAccount) | **POST** /v0/organizations/{organization-id}/bank/accounts | Open bank account
*BankAccountsApi* | [**getAccount**](docs/BankAccountsApi.md#getAccount) | **GET** /v0/bank/accounts/{bank-account-id} | Get bank account
*BankAccountsApi* | [**list**](docs/BankAccountsApi.md#list) | **GET** /v0/organizations/{organization-id}/bank/accounts | List bank accounts
*BankAccountsApi* | [**updateBankAccount**](docs/BankAccountsApi.md#updateBankAccount) | **PATCH** /v0/bank/accounts/{bank-account-id} | 
*ClaimsApi* | [**createNewClaim**](docs/ClaimsApi.md#createNewClaim) | **POST** /v0/legal-persons/{legal-person-id}/claims | Create claim
*ClaimsApi* | [**getAllClaims**](docs/ClaimsApi.md#getAllClaims) | **GET** /v0/legal-persons/{legal-person-id}/claims | List claims
*CompaniesHouseApi* | [**getCompanyDetails**](docs/CompaniesHouseApi.md#getCompanyDetails) | **GET** /v0/companies-house/companies/{company-number} | Lookup company
*ConnectivityApi* | [**checkConnection**](docs/ConnectivityApi.md#checkConnection) | **GET** /v0/ping | Ping
*DecisionsApi* | [**createDecision**](docs/DecisionsApi.md#createDecision) | **POST** /v0/legal-persons/{legal-person-id}/decisions | Create decision
*DecisionsApi* | [**listForLegalPerson**](docs/DecisionsApi.md#listForLegalPerson) | **GET** /v0/legal-persons/{legal-person-id}/decisions | List decisions
*EventsApi* | [**getAllOrganizationEvents**](docs/EventsApi.md#getAllOrganizationEvents) | **GET** /v0/organizations/{organization-id}/events | 
*EventsApi* | [**getEvent**](docs/EventsApi.md#getEvent) | **GET** /v0/events/{event-id} | 
*InvitationsApi* | [**sendEmail**](docs/InvitationsApi.md#sendEmail) | **POST** /v0/organizations/{organization-id}/invitations | Create invitation
*LegalPersonHistoryApi* | [**listEvents**](docs/LegalPersonHistoryApi.md#listEvents) | **GET** /v0/legal-persons/{legal-person-id}/history | 
*LegalPersonsApi* | [**createNewLegalPerson**](docs/LegalPersonsApi.md#createNewLegalPerson) | **POST** /v0/organizations/{organization-id}/legal-persons | Create legal person
*LegalPersonsApi* | [**getLegalPerson**](docs/LegalPersonsApi.md#getLegalPerson) | **GET** /v0/legal-persons/{legal-person-id} | Get legal person
*LegalPersonsApi* | [**listLegalPersons**](docs/LegalPersonsApi.md#listLegalPersons) | **GET** /v0/organizations/{organization-id}/legal-persons | List legal persons
*LegalPersonsApi* | [**updateLegalPerson**](docs/LegalPersonsApi.md#updateLegalPerson) | **PUT** /v0/legal-persons/{legal-person-id} | Update legal person
*MembershipsApi* | [**getMembershipInfo**](docs/MembershipsApi.md#getMembershipInfo) | **GET** /v0/memberships/{membership-id} | Get membership
*MembershipsApi* | [**listOrganizationMemberships**](docs/MembershipsApi.md#listOrganizationMemberships) | **GET** /v0/organizations/{organization-id}/memberships | List organization memberships
*MembershipsApi* | [**listUserMemberships**](docs/MembershipsApi.md#listUserMemberships) | **GET** /v0/users/{user-id}/memberships | List user memberships
*MembershipsApi* | [**removeMember**](docs/MembershipsApi.md#removeMember) | **DELETE** /v0/memberships/{membership-id} | Delete membership
*NavigationApi* | [**globalPathsFetch**](docs/NavigationApi.md#globalPathsFetch) | **GET** /v0/index | Index
*OrganizationsApi* | [**getDetails**](docs/OrganizationsApi.md#getDetails) | **GET** /v0/organizations/{organization-id} | Get organization
*PayeesApi* | [**getDetails**](docs/PayeesApi.md#getDetails) | **GET** /v0/payees/{payee-id} | Get payee
*PayeesApi* | [**listLegalPersonPayees**](docs/PayeesApi.md#listLegalPersonPayees) | **GET** /v0/legal-persons/{legal-person-id}/bank/payees | List legal person payees
*PayeesApi* | [**registerNewPayee**](docs/PayeesApi.md#registerNewPayee) | **POST** /v0/legal-persons/{legal-person-id}/bank/payees | Create payee
*PayeesApi* | [**updatePayee**](docs/PayeesApi.md#updatePayee) | **PATCH** /v0/payees/{payee-id} | Update payee
*PaymentsApi* | [**createRequest**](docs/PaymentsApi.md#createRequest) | **POST** /v0/bank/accounts/{bank-account-id}/payments | Create payment
*PaymentsApi* | [**getAdmission**](docs/PaymentsApi.md#getAdmission) | **GET** /v0/admissions/{admission-id} | Get payment admission
*PaymentsApi* | [**getBankAccountPayments**](docs/PaymentsApi.md#getBankAccountPayments) | **GET** /v0/bank/accounts/{bank-account-id}/payments | List bank account payments
*PaymentsApi* | [**getDetails**](docs/PaymentsApi.md#getDetails) | **GET** /v0/payments/{payment-id} | Get payment
*PaymentsApi* | [**getSubmission**](docs/PaymentsApi.md#getSubmission) | **GET** /v0/submissions/{submission-id} | Get payment submission
*PaymentsApi* | [**listAdmissions**](docs/PaymentsApi.md#listAdmissions) | **GET** /v0/payments/{payment-id}/admissions | List payment admissions
*PaymentsApi* | [**listBankAccountAdmissions**](docs/PaymentsApi.md#listBankAccountAdmissions) | **GET** /v0/bank/accounts/{bank-account-id}/admissions | List bank account admissions
*PaymentsApi* | [**listSubmissions**](docs/PaymentsApi.md#listSubmissions) | **GET** /v0/bank/accounts/{bank-account-id}/submissions | List bank account submissions
*PaymentsApi* | [**listSubmissions_0**](docs/PaymentsApi.md#listSubmissions_0) | **GET** /v0/payments/{payment-id}/submissions | List payment submissions
*PaymentsApi* | [**submitPaymentSubmission**](docs/PaymentsApi.md#submitPaymentSubmission) | **POST** /v0/payments/{payment-id}/submissions | Submit payment
*PooledAccountMembershipApi* | [**listLegalPersons**](docs/PooledAccountMembershipApi.md#listLegalPersons) | **GET** /v0/bank/accounts/{bank-account-id}/membership | List legal person in a pooled account membership
*PooledAccountMembershipApi* | [**manageLegalPersons**](docs/PooledAccountMembershipApi.md#manageLegalPersons) | **POST** /v0/bank/accounts/{bank-account-id}/membership-updates | Manage pooled account members
*RelianceOnboardingApi* | [**createApplication**](docs/RelianceOnboardingApi.md#createApplication) | **POST** /v0/organizations/{organization-id}/onboarding/applications | Create an onboarding application
*RelianceOnboardingApi* | [**getApplication**](docs/RelianceOnboardingApi.md#getApplication) | **GET** /v0/onboarding/applications/{onboarding-application-id} | Get onboarding application
*RolesApi* | [**assignMembershipRoles**](docs/RolesApi.md#assignMembershipRoles) | **PUT** /v0/memberships/{membership-id}/roles | Update role
*RolesApi* | [**getMembershipRoles**](docs/RolesApi.md#getMembershipRoles) | **GET** /v0/memberships/{membership-id}/roles | List membership roles
*RolesApi* | [**getRole**](docs/RolesApi.md#getRole) | **GET** /v0/roles/{role-id} | Get role
*RolesApi* | [**listAllRoles**](docs/RolesApi.md#listAllRoles) | **GET** /v0/roles | List roles
*TransactionsApi* | [**getTransactionById**](docs/TransactionsApi.md#getTransactionById) | **GET** /v0/bank/transactions/{transaction-id} | Get transaction
*TransactionsApi* | [**listBalanceChanges**](docs/TransactionsApi.md#listBalanceChanges) | **GET** /v0/bank/accounts/{bank-account-id}/transactions | List transactions
*UsersApi* | [**getUserResource**](docs/UsersApi.md#getUserResource) | **GET** /v0/users/{user-id} | Get user
*VerificationsApi* | [**getVerification**](docs/VerificationsApi.md#getVerification) | **GET** /v0/verifications/{verification-id} | Get verification
*VerificationsApi* | [**initiateVerification**](docs/VerificationsApi.md#initiateVerification) | **POST** /v0/legal-persons/{legal-person-id}/verifications | Perform verification of a legal person
*VerificationsApi* | [**listForLegalPerson**](docs/VerificationsApi.md#listForLegalPerson) | **GET** /v0/legal-persons/{legal-person-id}/verifications | List verifications for a legal person
*WebhooksApi* | [**activateAction**](docs/WebhooksApi.md#activateAction) | **POST** /v0/webhooks/{webhook-id}/actions/activate | 
*WebhooksApi* | [**createWebhook**](docs/WebhooksApi.md#createWebhook) | **POST** /v0/organizations/{organization-id}/webhooks | 
*WebhooksApi* | [**deactivateAction**](docs/WebhooksApi.md#deactivateAction) | **POST** /v0/webhooks/{webhook-id}/actions/deactivate | 
*WebhooksApi* | [**deleteWebhook**](docs/WebhooksApi.md#deleteWebhook) | **DELETE** /v0/webhooks/{webhook-id} | 
*WebhooksApi* | [**getAll**](docs/WebhooksApi.md#getAll) | **GET** /v0/organizations/{organization-id}/webhooks | 
*WebhooksApi* | [**getLatestTestStatus**](docs/WebhooksApi.md#getLatestTestStatus) | **GET** /v0/webhooks/{webhook-id}/actions/test | 
*WebhooksApi* | [**getWebhook**](docs/WebhooksApi.md#getWebhook) | **GET** /v0/webhooks/{webhook-id} | 
*WebhooksApi* | [**sendTestEvent**](docs/WebhooksApi.md#sendTestEvent) | **POST** /v0/webhooks/{webhook-id}/actions/test | 
*WebhooksApi* | [**updateWebhook**](docs/WebhooksApi.md#updateWebhook) | **PATCH** /v0/webhooks/{webhook-id} | 
*WorkflowsApi* | [**getWorkflow**](docs/WorkflowsApi.md#getWorkflow) | **GET** /v0/workflows/{workflow-id} | Get workflow
*WorkflowsApi* | [**listOrganizationWorkflows**](docs/WorkflowsApi.md#listOrganizationWorkflows) | **GET** /v0/organizations/{organization-id}/workflows | List organization workflows


## Documentation for Models

 - [AccountBalanceProperty](docs/AccountBalanceProperty.md)
 - [AccountBalanceProperty1](docs/AccountBalanceProperty1.md)
 - [AccountBalanceProperty2](docs/AccountBalanceProperty2.md)
 - [AccountBalanceProperty3](docs/AccountBalanceProperty3.md)
 - [AccountBalanceProperty4](docs/AccountBalanceProperty4.md)
 - [AccountBalanceProperty5](docs/AccountBalanceProperty5.md)
 - [AccountBalanceProperty6](docs/AccountBalanceProperty6.md)
 - [AccountTransaction](docs/AccountTransaction.md)
 - [Admission](docs/Admission.md)
 - [Admission1](docs/Admission1.md)
 - [AnnualTurnoverProperty](docs/AnnualTurnoverProperty.md)
 - [AnnualTurnoverProperty1](docs/AnnualTurnoverProperty1.md)
 - [AnnualTurnoverProperty2](docs/AnnualTurnoverProperty2.md)
 - [AnnualTurnoverProperty3](docs/AnnualTurnoverProperty3.md)
 - [AnnualTurnoverProperty4](docs/AnnualTurnoverProperty4.md)
 - [AnnualTurnoverProperty5](docs/AnnualTurnoverProperty5.md)
 - [ApiKey](docs/ApiKey.md)
 - [ApiKey1](docs/ApiKey1.md)
 - [ApiKeysCreateKeyRequest](docs/ApiKeysCreateKeyRequest.md)
 - [ApiKeysCreateKeyResponse](docs/ApiKeysCreateKeyResponse.md)
 - [ApiKeysGetKeyDetailsResponse](docs/ApiKeysGetKeyDetailsResponse.md)
 - [ApiKeysListActiveKeys200Response](docs/ApiKeysListActiveKeys200Response.md)
 - [ApiKeysListActiveKeysResponse](docs/ApiKeysListActiveKeysResponse.md)
 - [AvailableBalanceProperty](docs/AvailableBalanceProperty.md)
 - [AvailableBalanceProperty1](docs/AvailableBalanceProperty1.md)
 - [AvailableBalanceProperty2](docs/AvailableBalanceProperty2.md)
 - [AvailableBalanceProperty3](docs/AvailableBalanceProperty3.md)
 - [AvailableBalanceProperty4](docs/AvailableBalanceProperty4.md)
 - [BalanceChangeProperty](docs/BalanceChangeProperty.md)
 - [BalanceChangeProperty1](docs/BalanceChangeProperty1.md)
 - [BankAccount](docs/BankAccount.md)
 - [BankAccountsCloseAccountResponse](docs/BankAccountsCloseAccountResponse.md)
 - [BankAccountsCreateNewAccountRequest](docs/BankAccountsCreateNewAccountRequest.md)
 - [BankAccountsCreateNewAccountResponse](docs/BankAccountsCreateNewAccountResponse.md)
 - [BankAccountsGetAccountResponse](docs/BankAccountsGetAccountResponse.md)
 - [BankAccountsListResponse](docs/BankAccountsListResponse.md)
 - [BankAccountsUpdateBankAccountRequest](docs/BankAccountsUpdateBankAccountRequest.md)
 - [BankAccountsUpdateBankAccountResponse](docs/BankAccountsUpdateBankAccountResponse.md)
 - [BankAddress](docs/BankAddress.md)
 - [BankAddress1](docs/BankAddress1.md)
 - [BankAddress2](docs/BankAddress2.md)
 - [BankAddress3](docs/BankAddress3.md)
 - [BankAddress4](docs/BankAddress4.md)
 - [BothBuildingNameAndBuildingNumberProperty](docs/BothBuildingNameAndBuildingNumberProperty.md)
 - [ClaimsCreateNewClaimRequest](docs/ClaimsCreateNewClaimRequest.md)
 - [ClaimsCreateNewClaimResponse](docs/ClaimsCreateNewClaimResponse.md)
 - [ClaimsGetAllClaimsResponse](docs/ClaimsGetAllClaimsResponse.md)
 - [CompaniesHouseGetCompanyDetailsResponse](docs/CompaniesHouseGetCompanyDetailsResponse.md)
 - [CompanyAddressProperty](docs/CompanyAddressProperty.md)
 - [DebtorProperty](docs/DebtorProperty.md)
 - [DebtorProperty1](docs/DebtorProperty1.md)
 - [DebtorProperty2](docs/DebtorProperty2.md)
 - [DebtorProperty3](docs/DebtorProperty3.md)
 - [Decision](docs/Decision.md)
 - [DecisionsCreateDecisionRequest](docs/DecisionsCreateDecisionRequest.md)
 - [DecisionsCreateDecisionResponse](docs/DecisionsCreateDecisionResponse.md)
 - [DecisionsListForLegalPersonResponse](docs/DecisionsListForLegalPersonResponse.md)
 - [Director](docs/Director.md)
 - [DirectorProperty](docs/DirectorProperty.md)
 - [EstimatedTotalProperty](docs/EstimatedTotalProperty.md)
 - [Event](docs/Event.md)
 - [EventsGetAllOrganizationEventsResponse](docs/EventsGetAllOrganizationEventsResponse.md)
 - [EventsGetEventResponse](docs/EventsGetEventResponse.md)
 - [FpsProperty](docs/FpsProperty.md)
 - [FpsProperty1](docs/FpsProperty1.md)
 - [IncomeProperty](docs/IncomeProperty.md)
 - [IncomeProperty1](docs/IncomeProperty1.md)
 - [IncomeProperty2](docs/IncomeProperty2.md)
 - [IncomeProperty3](docs/IncomeProperty3.md)
 - [IncomeProperty4](docs/IncomeProperty4.md)
 - [IncomeProperty5](docs/IncomeProperty5.md)
 - [InitialDepositProperty](docs/InitialDepositProperty.md)
 - [InitialDepositProperty1](docs/InitialDepositProperty1.md)
 - [InitialDepositProperty2](docs/InitialDepositProperty2.md)
 - [InitialDepositProperty3](docs/InitialDepositProperty3.md)
 - [InitialDepositProperty4](docs/InitialDepositProperty4.md)
 - [InitialDepositProperty5](docs/InitialDepositProperty5.md)
 - [InvitationsSendEmailRequest](docs/InvitationsSendEmailRequest.md)
 - [LatestDecisionProperty](docs/LatestDecisionProperty.md)
 - [LatestDecisionProperty1](docs/LatestDecisionProperty1.md)
 - [LatestDecisionProperty2](docs/LatestDecisionProperty2.md)
 - [LatestDecisionProperty3](docs/LatestDecisionProperty3.md)
 - [LatestDecisionProperty4](docs/LatestDecisionProperty4.md)
 - [LatestDecisionProperty5](docs/LatestDecisionProperty5.md)
 - [LegalPerson](docs/LegalPerson.md)
 - [LegalPerson1](docs/LegalPerson1.md)
 - [LegalPerson2](docs/LegalPerson2.md)
 - [LegalPersonHistoryListEventsResponse](docs/LegalPersonHistoryListEventsResponse.md)
 - [LegalPersonsCreateNewLegalPersonRequest](docs/LegalPersonsCreateNewLegalPersonRequest.md)
 - [LegalPersonsCreateNewLegalPersonResponse](docs/LegalPersonsCreateNewLegalPersonResponse.md)
 - [LegalPersonsGetLegalPersonResponse](docs/LegalPersonsGetLegalPersonResponse.md)
 - [LegalPersonsListLegalPersonsResponse](docs/LegalPersonsListLegalPersonsResponse.md)
 - [LegalPersonsUpdateLegalPersonRequest](docs/LegalPersonsUpdateLegalPersonRequest.md)
 - [LegalPersonsUpdateLegalPersonResponse](docs/LegalPersonsUpdateLegalPersonResponse.md)
 - [LinksProperty](docs/LinksProperty.md)
 - [Membership](docs/Membership.md)
 - [Membership1](docs/Membership1.md)
 - [MembershipsGetMembershipInfoResponse](docs/MembershipsGetMembershipInfoResponse.md)
 - [MembershipsListOrganizationMembershipsResponse](docs/MembershipsListOrganizationMembershipsResponse.md)
 - [MembershipsListUserMembershipsResponse](docs/MembershipsListUserMembershipsResponse.md)
 - [MetaProperty](docs/MetaProperty.md)
 - [MobileNumber](docs/MobileNumber.md)
 - [MobileNumber1](docs/MobileNumber1.md)
 - [MobileNumber2](docs/MobileNumber2.md)
 - [MobileNumber3](docs/MobileNumber3.md)
 - [NavigationGlobalPathsFetchResponse](docs/NavigationGlobalPathsFetchResponse.md)
 - [OpsUserProperty](docs/OpsUserProperty.md)
 - [OrganizationProperty](docs/OrganizationProperty.md)
 - [OrganizationProperty1](docs/OrganizationProperty1.md)
 - [OrganizationProperty2](docs/OrganizationProperty2.md)
 - [OrganizationsGetDetailsResponse](docs/OrganizationsGetDetailsResponse.md)
 - [PageProperty](docs/PageProperty.md)
 - [Payee](docs/Payee.md)
 - [PayeeProperty](docs/PayeeProperty.md)
 - [PayeeProperty1](docs/PayeeProperty1.md)
 - [PayeeProperty2](docs/PayeeProperty2.md)
 - [PayeeProperty3](docs/PayeeProperty3.md)
 - [PayeeProperty4](docs/PayeeProperty4.md)
 - [PayeesGetDetailsResponse](docs/PayeesGetDetailsResponse.md)
 - [PayeesListLegalPersonPayeesResponse](docs/PayeesListLegalPersonPayeesResponse.md)
 - [PayeesRegisterNewPayeeRequest](docs/PayeesRegisterNewPayeeRequest.md)
 - [PayeesRegisterNewPayeeResponse](docs/PayeesRegisterNewPayeeResponse.md)
 - [PayeesUpdatePayeeRequest](docs/PayeesUpdatePayeeRequest.md)
 - [PayeesUpdatePayeeResponse](docs/PayeesUpdatePayeeResponse.md)
 - [Payment](docs/Payment.md)
 - [Payment1](docs/Payment1.md)
 - [PaymentAmountProperty](docs/PaymentAmountProperty.md)
 - [PaymentAmountProperty1](docs/PaymentAmountProperty1.md)
 - [PaymentAmountProperty2](docs/PaymentAmountProperty2.md)
 - [PaymentAmountProperty3](docs/PaymentAmountProperty3.md)
 - [PaymentAmountProperty4](docs/PaymentAmountProperty4.md)
 - [PaymentsCreateRequestRequest](docs/PaymentsCreateRequestRequest.md)
 - [PaymentsCreateRequestResponse](docs/PaymentsCreateRequestResponse.md)
 - [PaymentsGetAdmissionResponse](docs/PaymentsGetAdmissionResponse.md)
 - [PaymentsGetBankAccountPaymentsResponse](docs/PaymentsGetBankAccountPaymentsResponse.md)
 - [PaymentsGetDetailsResponse](docs/PaymentsGetDetailsResponse.md)
 - [PaymentsGetSubmissionResponse](docs/PaymentsGetSubmissionResponse.md)
 - [PaymentsListAdmissionsResponse](docs/PaymentsListAdmissionsResponse.md)
 - [PaymentsListBankAccountAdmissionsResponse](docs/PaymentsListBankAccountAdmissionsResponse.md)
 - [PaymentsListSubmissions200Response](docs/PaymentsListSubmissions200Response.md)
 - [PaymentsListSubmissionsResponse](docs/PaymentsListSubmissionsResponse.md)
 - [PaymentsSubmitPaymentSubmissionRequest](docs/PaymentsSubmitPaymentSubmissionRequest.md)
 - [PaymentsSubmitPaymentSubmissionResponse](docs/PaymentsSubmitPaymentSubmissionResponse.md)
 - [PersonWithSignificantControl](docs/PersonWithSignificantControl.md)
 - [PoolMember](docs/PoolMember.md)
 - [PooledAccountMembershipListLegalPersonsResponse](docs/PooledAccountMembershipListLegalPersonsResponse.md)
 - [PooledAccountMembershipManageLegalPersonsRequest](docs/PooledAccountMembershipManageLegalPersonsRequest.md)
 - [PooledAccountMembershipManageLegalPersonsResponse](docs/PooledAccountMembershipManageLegalPersonsResponse.md)
 - [Property](docs/Property.md)
 - [Property1](docs/Property1.md)
 - [Property2](docs/Property2.md)
 - [Property3](docs/Property3.md)
 - [PscProperty](docs/PscProperty.md)
 - [RelatedProfile](docs/RelatedProfile.md)
 - [RelianceOnboardingCreateApplicationRequest](docs/RelianceOnboardingCreateApplicationRequest.md)
 - [RelianceOnboardingCreateApplicationResponse](docs/RelianceOnboardingCreateApplicationResponse.md)
 - [RelianceOnboardingGetApplicationResponse](docs/RelianceOnboardingGetApplicationResponse.md)
 - [RiskRatingEntry](docs/RiskRatingEntry.md)
 - [RiskRatingEntry1](docs/RiskRatingEntry1.md)
 - [RiskRatingRegistered](docs/RiskRatingRegistered.md)
 - [Role](docs/Role.md)
 - [Role1](docs/Role1.md)
 - [Role2](docs/Role2.md)
 - [Role3](docs/Role3.md)
 - [Role4](docs/Role4.md)
 - [Role5](docs/Role5.md)
 - [Role6](docs/Role6.md)
 - [Role7](docs/Role7.md)
 - [Role8](docs/Role8.md)
 - [Role9](docs/Role9.md)
 - [RolesAssignMembershipRolesRequest](docs/RolesAssignMembershipRolesRequest.md)
 - [RolesAssignMembershipRolesResponse](docs/RolesAssignMembershipRolesResponse.md)
 - [RolesGetMembershipRolesResponse](docs/RolesGetMembershipRolesResponse.md)
 - [RolesGetRoleResponse](docs/RolesGetRoleResponse.md)
 - [RolesListAllRolesResponse](docs/RolesListAllRolesResponse.md)
 - [SubjectAssociationProperty](docs/SubjectAssociationProperty.md)
 - [SubjectProfileProperty](docs/SubjectProfileProperty.md)
 - [Submission](docs/Submission.md)
 - [Submission1](docs/Submission1.md)
 - [TransactionsGetTransactionByIdResponse](docs/TransactionsGetTransactionByIdResponse.md)
 - [TransactionsListBalanceChangesResponse](docs/TransactionsListBalanceChangesResponse.md)
 - [UltimateDebtorProperty](docs/UltimateDebtorProperty.md)
 - [UltimateDebtorProperty1](docs/UltimateDebtorProperty1.md)
 - [UltimateDebtorProperty2](docs/UltimateDebtorProperty2.md)
 - [UltimateDebtorProperty3](docs/UltimateDebtorProperty3.md)
 - [UserProperty](docs/UserProperty.md)
 - [UserProperty1](docs/UserProperty1.md)
 - [UserProperty2](docs/UserProperty2.md)
 - [UsersGetUserResourceResponse](docs/UsersGetUserResourceResponse.md)
 - [Verification](docs/Verification.md)
 - [Verification1](docs/Verification1.md)
 - [Verification2](docs/Verification2.md)
 - [VerificationsGetVerificationResponse](docs/VerificationsGetVerificationResponse.md)
 - [VerificationsInitiateVerificationRequest](docs/VerificationsInitiateVerificationRequest.md)
 - [VerificationsInitiateVerificationResponse](docs/VerificationsInitiateVerificationResponse.md)
 - [VerificationsListForLegalPersonResponse](docs/VerificationsListForLegalPersonResponse.md)
 - [Webhook](docs/Webhook.md)
 - [WebhooksActivateActionResponse](docs/WebhooksActivateActionResponse.md)
 - [WebhooksCreateWebhookRequest](docs/WebhooksCreateWebhookRequest.md)
 - [WebhooksCreateWebhookResponse](docs/WebhooksCreateWebhookResponse.md)
 - [WebhooksDeactivateActionResponse](docs/WebhooksDeactivateActionResponse.md)
 - [WebhooksGetAllResponse](docs/WebhooksGetAllResponse.md)
 - [WebhooksGetLatestTestStatusResponse](docs/WebhooksGetLatestTestStatusResponse.md)
 - [WebhooksGetWebhookResponse](docs/WebhooksGetWebhookResponse.md)
 - [WebhooksSendTestEventResponse](docs/WebhooksSendTestEventResponse.md)
 - [WebhooksUpdateWebhookRequest](docs/WebhooksUpdateWebhookRequest.md)
 - [WebhooksUpdateWebhookResponse](docs/WebhooksUpdateWebhookResponse.md)
 - [Workflow](docs/Workflow.md)
 - [WorkflowsGetWorkflowResponse](docs/WorkflowsGetWorkflowResponse.md)
 - [WorkflowsListOrganizationWorkflowsResponse](docs/WorkflowsListOrganizationWorkflowsResponse.md)


## Author
This Java package is automatically generated by [Konfig](https://konfigthis.com)
