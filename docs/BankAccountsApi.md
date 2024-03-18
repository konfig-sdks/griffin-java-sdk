# BankAccountsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**closeAccount**](BankAccountsApi.md#closeAccount) | **POST** /v0/bank/accounts/{bank-account-id}/actions/close |  |
| [**createNewAccount**](BankAccountsApi.md#createNewAccount) | **POST** /v0/organizations/{organization-id}/bank/accounts | Open bank account |
| [**getAccount**](BankAccountsApi.md#getAccount) | **GET** /v0/bank/accounts/{bank-account-id} | Get bank account |
| [**list**](BankAccountsApi.md#list) | **GET** /v0/organizations/{organization-id}/bank/accounts | List bank accounts |
| [**updateBankAccount**](BankAccountsApi.md#updateBankAccount) | **PATCH** /v0/bank/accounts/{bank-account-id} |  |


<a name="closeAccount"></a>
# **closeAccount**
> BankAccountsCloseAccountResponse closeAccount(bankAccountId).execute();



Close a bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BankAccountsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String bankAccountId = "bankAccountId_example";
    try {
      BankAccountsCloseAccountResponse result = client
              .bankAccounts
              .closeAccount(bankAccountId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountSubmissionsUrl());
      System.out.println(result.getAccountRestricted());
      System.out.println(result.getAccountPaymentsUrl());
      System.out.println(result.getPooledAccountMembershipsUrl());
      System.out.println(result.getAccountAdmissionsUrl());
      System.out.println(result.getBankProductType());
      System.out.println(result.getDisplayName());
      System.out.println(result.getControllerUrl());
      System.out.println(result.getPooledFunds());
      System.out.println(result.getAccountStatus());
      System.out.println(result.getClientMoneyType());
      System.out.println(result.getOwnerUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getCloseAccountUrl());
      System.out.println(result.getAvailableBalance());
      System.out.println(result.getPooledAccountMembershipUpdatesUrl());
      System.out.println(result.getBankAddresses());
      System.out.println(result.getAccountTransactionsUrl());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getBeneficiaryUrl());
      System.out.println(result.getAccountBalance());
      System.out.println(result.getSavingsType());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#closeAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<BankAccountsCloseAccountResponse> response = client
              .bankAccounts
              .closeAccount(bankAccountId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#closeAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **bankAccountId** | **String**|  | |

### Return type

[**BankAccountsCloseAccountResponse**](BankAccountsCloseAccountResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Location - The URL to check the progress of the test <br>  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **422** | An error occurred when trying to close the bank account. See [https://docs.griffin.com/docs/errors/account-close](https://docs.griffin.com/docs/errors/account-close) for details. |  -  |

<a name="createNewAccount"></a>
# **createNewAccount**
> BankAccountsCreateNewAccountResponse createNewAccount(organizationId, bankAccountsCreateNewAccountRequest).execute();

Open bank account

Open a new bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BankAccountsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String bankProductType = "savings-account";
    String organizationId = "organizationId_example";
    String ownerUrl = "ownerUrl_example"; // Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account.
    String savingsType = "easy-access"; // Specifies the type of savings account.
    String displayName = "displayName_example"; // A human readable label for an entity
    try {
      BankAccountsCreateNewAccountResponse result = client
              .bankAccounts
              .createNewAccount(bankProductType, organizationId)
              .ownerUrl(ownerUrl)
              .savingsType(savingsType)
              .displayName(displayName)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountSubmissionsUrl());
      System.out.println(result.getAccountRestricted());
      System.out.println(result.getAccountPaymentsUrl());
      System.out.println(result.getPooledAccountMembershipsUrl());
      System.out.println(result.getAccountAdmissionsUrl());
      System.out.println(result.getBankProductType());
      System.out.println(result.getDisplayName());
      System.out.println(result.getControllerUrl());
      System.out.println(result.getPooledFunds());
      System.out.println(result.getAccountStatus());
      System.out.println(result.getClientMoneyType());
      System.out.println(result.getOwnerUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getCloseAccountUrl());
      System.out.println(result.getAvailableBalance());
      System.out.println(result.getPooledAccountMembershipUpdatesUrl());
      System.out.println(result.getBankAddresses());
      System.out.println(result.getAccountTransactionsUrl());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getBeneficiaryUrl());
      System.out.println(result.getAccountBalance());
      System.out.println(result.getSavingsType());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#createNewAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<BankAccountsCreateNewAccountResponse> response = client
              .bankAccounts
              .createNewAccount(bankProductType, organizationId)
              .ownerUrl(ownerUrl)
              .savingsType(savingsType)
              .displayName(displayName)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#createNewAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **organizationId** | **String**|  | |
| **bankAccountsCreateNewAccountRequest** | [**BankAccountsCreateNewAccountRequest**](BankAccountsCreateNewAccountRequest.md)|  | |

### Return type

[**BankAccountsCreateNewAccountResponse**](BankAccountsCreateNewAccountResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  * Location - The URL to check the progress of the test <br>  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **422** |  |  -  |

<a name="getAccount"></a>
# **getAccount**
> BankAccountsGetAccountResponse getAccount(bankAccountId).execute();

Get bank account

Fetch a bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BankAccountsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String bankAccountId = "bankAccountId_example";
    try {
      BankAccountsGetAccountResponse result = client
              .bankAccounts
              .getAccount(bankAccountId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountSubmissionsUrl());
      System.out.println(result.getAccountRestricted());
      System.out.println(result.getAccountPaymentsUrl());
      System.out.println(result.getPooledAccountMembershipsUrl());
      System.out.println(result.getAccountAdmissionsUrl());
      System.out.println(result.getBankProductType());
      System.out.println(result.getDisplayName());
      System.out.println(result.getControllerUrl());
      System.out.println(result.getPooledFunds());
      System.out.println(result.getAccountStatus());
      System.out.println(result.getClientMoneyType());
      System.out.println(result.getOwnerUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getCloseAccountUrl());
      System.out.println(result.getAvailableBalance());
      System.out.println(result.getPooledAccountMembershipUpdatesUrl());
      System.out.println(result.getBankAddresses());
      System.out.println(result.getAccountTransactionsUrl());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getBeneficiaryUrl());
      System.out.println(result.getAccountBalance());
      System.out.println(result.getSavingsType());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#getAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<BankAccountsGetAccountResponse> response = client
              .bankAccounts
              .getAccount(bankAccountId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#getAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **bankAccountId** | **String**|  | |

### Return type

[**BankAccountsGetAccountResponse**](BankAccountsGetAccountResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Location - The URL to check the progress of the test <br>  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="list"></a>
# **list**
> BankAccountsListResponse list(organizationId).filterBeneficiaryEq(filterBeneficiaryEq).filterOwnerEq(filterOwnerEq).pageSize(pageSize).include(include).filterAccountStatusIn(filterAccountStatusIn).sort(sort).pageAfter(pageAfter).filterAccountRestrictedIn(filterAccountRestrictedIn).filterPooledFundsEq(filterPooledFundsEq).filterBankProductTypeIn(filterBankProductTypeIn).pageBefore(pageBefore).execute();

List bank accounts

Yields a list of all bank accounts under the control of this Organization.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BankAccountsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String organizationId = "organizationId_example";
    String filterBeneficiaryEq = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA"; // Link to the [legal person](http://docs.griffin.com) that represents the [beneficiary](http://docs.griffin.com) of the account.
    String filterOwnerEq = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA"; // Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account.
    Long pageSize = 56L; // 
    List<String> include = Arrays.asList(); // For each bank account returned, include its owner and/or beneficiary in the response under the `included.legal-persons` attribute.
    List<String> filterAccountStatusIn = Arrays.asList(); // 
    String sort = "-created-at"; // 
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    Boolean filterAccountRestrictedIn = true; // Specifies whether the bank account has restrictions applied by Griffin.
    Boolean filterPooledFundsEq = true; // Specifies whether the bank account holds funds belonging to multiple beneficiaries.
    List<String> filterBankProductTypeIn = Arrays.asList(); // 
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    try {
      BankAccountsListResponse result = client
              .bankAccounts
              .list(organizationId)
              .filterBeneficiaryEq(filterBeneficiaryEq)
              .filterOwnerEq(filterOwnerEq)
              .pageSize(pageSize)
              .include(include)
              .filterAccountStatusIn(filterAccountStatusIn)
              .sort(sort)
              .pageAfter(pageAfter)
              .filterAccountRestrictedIn(filterAccountRestrictedIn)
              .filterPooledFundsEq(filterPooledFundsEq)
              .filterBankProductTypeIn(filterBankProductTypeIn)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccounts());
      System.out.println(result.getLinks());
      System.out.println(result.getIncluded());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#list");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<BankAccountsListResponse> response = client
              .bankAccounts
              .list(organizationId)
              .filterBeneficiaryEq(filterBeneficiaryEq)
              .filterOwnerEq(filterOwnerEq)
              .pageSize(pageSize)
              .include(include)
              .filterAccountStatusIn(filterAccountStatusIn)
              .sort(sort)
              .pageAfter(pageAfter)
              .filterAccountRestrictedIn(filterAccountRestrictedIn)
              .filterPooledFundsEq(filterPooledFundsEq)
              .filterBankProductTypeIn(filterBankProductTypeIn)
              .pageBefore(pageBefore)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#list");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **organizationId** | **String**|  | |
| **filterBeneficiaryEq** | **String**| Link to the [legal person](http://docs.griffin.com) that represents the [beneficiary](http://docs.griffin.com) of the account. | [optional] |
| **filterOwnerEq** | **String**| Link to the [legal person](http://docs.griffin.com) that represents the [owner](http://docs.griffin.com) of the account. | [optional] |
| **pageSize** | **Long**|  | [optional] |
| **include** | [**List&lt;String&gt;**](String.md)| For each bank account returned, include its owner and/or beneficiary in the response under the &#x60;included.legal-persons&#x60; attribute. | [optional] [enum: beneficiary, owner] |
| **filterAccountStatusIn** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: closing, open, closed, opening] |
| **sort** | **String**|  | [optional] [enum: -created-at, display-name, created-at, -display-name] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **filterAccountRestrictedIn** | **Boolean**| Specifies whether the bank account has restrictions applied by Griffin. | [optional] |
| **filterPooledFundsEq** | **Boolean**| Specifies whether the bank account holds funds belonging to multiple beneficiaries. | [optional] |
| **filterBankProductTypeIn** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: savings-account, client-money-account, safeguarding-account, operational-account] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |

### Return type

[**BankAccountsListResponse**](BankAccountsListResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="updateBankAccount"></a>
# **updateBankAccount**
> BankAccountsUpdateBankAccountResponse updateBankAccount(bankAccountId, bankAccountsUpdateBankAccountRequest).execute();



Update a bank account

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BankAccountsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String displayName = "displayName_example"; // A human readable label for an entity
    String bankAccountId = "bankAccountId_example";
    try {
      BankAccountsUpdateBankAccountResponse result = client
              .bankAccounts
              .updateBankAccount(displayName, bankAccountId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountSubmissionsUrl());
      System.out.println(result.getAccountRestricted());
      System.out.println(result.getAccountPaymentsUrl());
      System.out.println(result.getPooledAccountMembershipsUrl());
      System.out.println(result.getAccountAdmissionsUrl());
      System.out.println(result.getBankProductType());
      System.out.println(result.getDisplayName());
      System.out.println(result.getControllerUrl());
      System.out.println(result.getPooledFunds());
      System.out.println(result.getAccountStatus());
      System.out.println(result.getClientMoneyType());
      System.out.println(result.getOwnerUrl());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getCloseAccountUrl());
      System.out.println(result.getAvailableBalance());
      System.out.println(result.getPooledAccountMembershipUpdatesUrl());
      System.out.println(result.getBankAddresses());
      System.out.println(result.getAccountTransactionsUrl());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getBeneficiaryUrl());
      System.out.println(result.getAccountBalance());
      System.out.println(result.getSavingsType());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#updateBankAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<BankAccountsUpdateBankAccountResponse> response = client
              .bankAccounts
              .updateBankAccount(displayName, bankAccountId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BankAccountsApi#updateBankAccount");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **bankAccountId** | **String**|  | |
| **bankAccountsUpdateBankAccountRequest** | [**BankAccountsUpdateBankAccountRequest**](BankAccountsUpdateBankAccountRequest.md)|  | |

### Return type

[**BankAccountsUpdateBankAccountResponse**](BankAccountsUpdateBankAccountResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Location - The URL to check the progress of the test <br>  |
| **400** | Responds with bad-request if the body does not conform to the schema. |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

