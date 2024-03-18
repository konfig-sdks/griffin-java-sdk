# PooledAccountMembershipApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listLegalPersons**](PooledAccountMembershipApi.md#listLegalPersons) | **GET** /v0/bank/accounts/{bank-account-id}/membership | List legal person in a pooled account membership |
| [**manageLegalPersons**](PooledAccountMembershipApi.md#manageLegalPersons) | **POST** /v0/bank/accounts/{bank-account-id}/membership-updates | Manage pooled account members |


<a name="listLegalPersons"></a>
# **listLegalPersons**
> PooledAccountMembershipListLegalPersonsResponse listLegalPersons(bankAccountId).include(include).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();

List legal person in a pooled account membership

List legal persons in a pooled account membership

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PooledAccountMembershipApi;
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
    List<String> include = Arrays.asList(); // For each member returned, include its legal person details, latest verification (if one exists), and/or latest risk rating (if one exists) in the response under the `included` attribute.
    Long pageSize = 56L; // 
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    try {
      PooledAccountMembershipListLegalPersonsResponse result = client
              .pooledAccountMembership
              .listLegalPersons(bankAccountId)
              .include(include)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getPoolMembers());
      System.out.println(result.getLinks());
      System.out.println(result.getMeta());
      System.out.println(result.getIncluded());
    } catch (ApiException e) {
      System.err.println("Exception when calling PooledAccountMembershipApi#listLegalPersons");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PooledAccountMembershipListLegalPersonsResponse> response = client
              .pooledAccountMembership
              .listLegalPersons(bankAccountId)
              .include(include)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PooledAccountMembershipApi#listLegalPersons");
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
| **include** | [**List&lt;String&gt;**](String.md)| For each member returned, include its legal person details, latest verification (if one exists), and/or latest risk rating (if one exists) in the response under the &#x60;included&#x60; attribute. | [optional] [enum: latest-risk-rating, legal-person, latest-verification] |
| **pageSize** | **Long**|  | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |

### Return type

[**PooledAccountMembershipListLegalPersonsResponse**](PooledAccountMembershipListLegalPersonsResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **403** |  |  -  |
| **404** |  |  -  |

<a name="manageLegalPersons"></a>
# **manageLegalPersons**
> PooledAccountMembershipManageLegalPersonsResponse manageLegalPersons(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest).execute();

Manage pooled account members

Add and update the legal persons in a pooled account membership. Limited to 2000 legal persons per operation.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PooledAccountMembershipApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    List<String> additions = Arrays.asList();
    List<String> deletions = Arrays.asList();
    String bankAccountId = "bankAccountId_example";
    try {
      PooledAccountMembershipManageLegalPersonsResponse result = client
              .pooledAccountMembership
              .manageLegalPersons(additions, deletions, bankAccountId)
              .execute();
      System.out.println(result);
      System.out.println(result.getPooledAccountMembershipsUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling PooledAccountMembershipApi#manageLegalPersons");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PooledAccountMembershipManageLegalPersonsResponse> response = client
              .pooledAccountMembership
              .manageLegalPersons(additions, deletions, bankAccountId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PooledAccountMembershipApi#manageLegalPersons");
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
| **pooledAccountMembershipManageLegalPersonsRequest** | [**PooledAccountMembershipManageLegalPersonsRequest**](PooledAccountMembershipManageLegalPersonsRequest.md)|  | |

### Return type

[**PooledAccountMembershipManageLegalPersonsResponse**](PooledAccountMembershipManageLegalPersonsResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | Responds with bad-request if the body does not conform to the schema. |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **403** |  |  -  |
| **404** |  |  -  |
| **422** |  |  -  |

