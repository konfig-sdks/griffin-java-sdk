# TransactionsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getTransactionById**](TransactionsApi.md#getTransactionById) | **GET** /v0/bank/transactions/{transaction-id} | Get transaction |
| [**listBalanceChanges**](TransactionsApi.md#listBalanceChanges) | **GET** /v0/bank/accounts/{bank-account-id}/transactions | List transactions |


<a name="getTransactionById"></a>
# **getTransactionById**
> TransactionsGetTransactionByIdResponse getTransactionById(transactionId).execute();

Get transaction

Yields a bank account transaction

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TransactionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String transactionId = "transactionId_example";
    try {
      TransactionsGetTransactionByIdResponse result = client
              .transactions
              .getTransactionById(transactionId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountTransactionUrl());
      System.out.println(result.getPostDatetime());
      System.out.println(result.getBalanceChangeDirection());
      System.out.println(result.getTransactionOriginType());
      System.out.println(result.getPaymentUrl());
      System.out.println(result.getReference());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getBalanceChange());
      System.out.println(result.getAccountBalance());
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionsApi#getTransactionById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<TransactionsGetTransactionByIdResponse> response = client
              .transactions
              .getTransactionById(transactionId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionsApi#getTransactionById");
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
| **transactionId** | **String**|  | |

### Return type

[**TransactionsGetTransactionByIdResponse**](TransactionsGetTransactionByIdResponse.md)

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

<a name="listBalanceChanges"></a>
# **listBalanceChanges**
> TransactionsListBalanceChangesResponse listBalanceChanges(bankAccountId).sort(sort).pageSize(pageSize).pageBefore(pageBefore).pageAfter(pageAfter).include(include).filterPostDatetimeLte(filterPostDatetimeLte).filterPostDatetimeLt(filterPostDatetimeLt).filterPostDatetimeGte(filterPostDatetimeGte).filterPostDatetimeGt(filterPostDatetimeGt).execute();

List transactions

Lists balance changes on a bank account.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TransactionsApi;
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
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    String include = "payment"; // For each transaction returned, include its payment (if one exists) in the response under the `included` attribute.
    OffsetDateTime filterPostDatetimeLte = OffsetDateTime.now(); // Return only resources with a created-at less than or equal to the given timestamp.
    OffsetDateTime filterPostDatetimeLt = OffsetDateTime.now(); // Return only resources with a created-at less than the given timestamp.
    OffsetDateTime filterPostDatetimeGte = OffsetDateTime.now(); // Return only resources with a created-at greater than or equal to the given timestamp.
    OffsetDateTime filterPostDatetimeGt = OffsetDateTime.now(); // Return only resources with a created-at greater than the given timestamp.
    try {
      TransactionsListBalanceChangesResponse result = client
              .transactions
              .listBalanceChanges(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .include(include)
              .filterPostDatetimeLte(filterPostDatetimeLte)
              .filterPostDatetimeLt(filterPostDatetimeLt)
              .filterPostDatetimeGte(filterPostDatetimeGte)
              .filterPostDatetimeGt(filterPostDatetimeGt)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountTransactions());
      System.out.println(result.getLinks());
      System.out.println(result.getIncluded());
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionsApi#listBalanceChanges");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<TransactionsListBalanceChangesResponse> response = client
              .transactions
              .listBalanceChanges(bankAccountId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .include(include)
              .filterPostDatetimeLte(filterPostDatetimeLte)
              .filterPostDatetimeLt(filterPostDatetimeLt)
              .filterPostDatetimeGte(filterPostDatetimeGte)
              .filterPostDatetimeGt(filterPostDatetimeGt)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionsApi#listBalanceChanges");
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
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **include** | **String**| For each transaction returned, include its payment (if one exists) in the response under the &#x60;included&#x60; attribute. | [optional] [enum: payment] |
| **filterPostDatetimeLte** | **OffsetDateTime**| Return only resources with a created-at less than or equal to the given timestamp. | [optional] |
| **filterPostDatetimeLt** | **OffsetDateTime**| Return only resources with a created-at less than the given timestamp. | [optional] |
| **filterPostDatetimeGte** | **OffsetDateTime**| Return only resources with a created-at greater than or equal to the given timestamp. | [optional] |
| **filterPostDatetimeGt** | **OffsetDateTime**| Return only resources with a created-at greater than the given timestamp. | [optional] |

### Return type

[**TransactionsListBalanceChangesResponse**](TransactionsListBalanceChangesResponse.md)

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

