# PayeesApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDetails**](PayeesApi.md#getDetails) | **GET** /v0/payees/{payee-id} | Get payee |
| [**listLegalPersonPayees**](PayeesApi.md#listLegalPersonPayees) | **GET** /v0/legal-persons/{legal-person-id}/bank/payees | List legal person payees |
| [**registerNewPayee**](PayeesApi.md#registerNewPayee) | **POST** /v0/legal-persons/{legal-person-id}/bank/payees | Create payee |
| [**updatePayee**](PayeesApi.md#updatePayee) | **PATCH** /v0/payees/{payee-id} | Update payee |


<a name="getDetails"></a>
# **getDetails**
> PayeesGetDetailsResponse getDetails(payeeId).execute();

Get payee

Yields payee details

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PayeesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String payeeId = "payeeId_example";
    try {
      PayeesGetDetailsResponse result = client
              .payees
              .getDetails(payeeId)
              .execute();
      System.out.println(result);
      System.out.println(result.getPayeeUrl());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAccountHolder());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getBankId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getPayeeStatus());
      System.out.println(result.getCountryCode());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#getDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PayeesGetDetailsResponse> response = client
              .payees
              .getDetails(payeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#getDetails");
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
| **payeeId** | **String**|  | |

### Return type

[**PayeesGetDetailsResponse**](PayeesGetDetailsResponse.md)

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

<a name="listLegalPersonPayees"></a>
# **listLegalPersonPayees**
> PayeesListLegalPersonPayeesResponse listLegalPersonPayees(legalPersonId).sort(sort).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();

List legal person payees

Lists payees belonging to the legal person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PayeesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String legalPersonId = "legalPersonId_example";
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    try {
      PayeesListLegalPersonPayeesResponse result = client
              .payees
              .listLegalPersonPayees(legalPersonId)
              .sort(sort)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getPayees());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#listLegalPersonPayees");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PayeesListLegalPersonPayeesResponse> response = client
              .payees
              .listLegalPersonPayees(legalPersonId)
              .sort(sort)
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
      System.err.println("Exception when calling PayeesApi#listLegalPersonPayees");
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
| **legalPersonId** | **String**|  | |
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |

### Return type

[**PayeesListLegalPersonPayeesResponse**](PayeesListLegalPersonPayeesResponse.md)

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

<a name="registerNewPayee"></a>
# **registerNewPayee**
> PayeesRegisterNewPayeeResponse registerNewPayee(legalPersonId, payeesRegisterNewPayeeRequest).execute();

Create payee

Registers a new payee for the customer

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PayeesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String accountHolder = "accountHolder_example"; // The name of the [account holder](http://docs.griffin.com).
    String accountNumber = "accountNumber_example"; // Must be a UK BBAN.
    String bankId = "bankId_example"; // Must be a UK Sort Code.
    String legalPersonId = "legalPersonId_example";
    try {
      PayeesRegisterNewPayeeResponse result = client
              .payees
              .registerNewPayee(accountHolder, accountNumber, bankId, legalPersonId)
              .execute();
      System.out.println(result);
      System.out.println(result.getPayeeUrl());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAccountHolder());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getBankId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getPayeeStatus());
      System.out.println(result.getCountryCode());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#registerNewPayee");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PayeesRegisterNewPayeeResponse> response = client
              .payees
              .registerNewPayee(accountHolder, accountNumber, bankId, legalPersonId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#registerNewPayee");
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
| **legalPersonId** | **String**|  | |
| **payeesRegisterNewPayeeRequest** | [**PayeesRegisterNewPayeeRequest**](PayeesRegisterNewPayeeRequest.md)|  | |

### Return type

[**PayeesRegisterNewPayeeResponse**](PayeesRegisterNewPayeeResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |

<a name="updatePayee"></a>
# **updatePayee**
> PayeesUpdatePayeeResponse updatePayee(payeeId, payeesUpdatePayeeRequest).execute();

Update payee

Updates an existing payee.  A payee can be deactivated by updating the &#x60;payee-status&#x60; of an active payee to &#x60;deactivated&#x60;. Any attempt to create or submit a payment to a deactivated payee will fail.  A 422 is served when attempting to deactivate an already-deactivated payee.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PayeesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String payeeStatus = "deactivated";
    String payeeId = "payeeId_example";
    try {
      PayeesUpdatePayeeResponse result = client
              .payees
              .updatePayee(payeeStatus, payeeId)
              .execute();
      System.out.println(result);
      System.out.println(result.getPayeeUrl());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAccountHolder());
      System.out.println(result.getLegalPersonUrl());
      System.out.println(result.getBankId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getAccountUrl());
      System.out.println(result.getPayeeStatus());
      System.out.println(result.getCountryCode());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#updatePayee");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PayeesUpdatePayeeResponse> response = client
              .payees
              .updatePayee(payeeStatus, payeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PayeesApi#updatePayee");
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
| **payeeId** | **String**|  | |
| **payeesUpdatePayeeRequest** | [**PayeesUpdatePayeeRequest**](PayeesUpdatePayeeRequest.md)|  | |

### Return type

[**PayeesUpdatePayeeResponse**](PayeesUpdatePayeeResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **422** |  |  -  |
| **500** |  |  -  |

