# NavigationApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**globalPathsFetch**](NavigationApi.md#globalPathsFetch) | **GET** /v0/index | Index |


<a name="globalPathsFetch"></a>
# **globalPathsFetch**
> NavigationGlobalPathsFetchResponse globalPathsFetch().execute();

Index

Contains various global URL paths. Follow &#x60;api-key-url&#x60; to discover your &#x60;organization-url&#x60;.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.NavigationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    try {
      NavigationGlobalPathsFetchResponse result = client
              .navigation
              .globalPathsFetch()
              .execute();
      System.out.println(result);
      System.out.println(result.getOrganizationsUrl());
      System.out.println(result.getUsersUrl());
      System.out.println(result.getRolesUrl());
      System.out.println(result.getSessionUrl());
      System.out.println(result.getApiKeyUrl());
      System.out.println(result.getOrganizationUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling NavigationApi#globalPathsFetch");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<NavigationGlobalPathsFetchResponse> response = client
              .navigation
              .globalPathsFetch()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling NavigationApi#globalPathsFetch");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters
This endpoint does not need any parameter.

### Return type

[**NavigationGlobalPathsFetchResponse**](NavigationGlobalPathsFetchResponse.md)

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

