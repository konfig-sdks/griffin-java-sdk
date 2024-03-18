# LegalPersonHistoryApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listEvents**](LegalPersonHistoryApi.md#listEvents) | **GET** /v0/legal-persons/{legal-person-id}/history |  |


<a name="listEvents"></a>
# **listEvents**
> LegalPersonHistoryListEventsResponse listEvents(legalPersonId).pageSize(pageSize).pageAfter(pageAfter).pageBefore(pageBefore).execute();



Lists history of events for the given legal person.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LegalPersonHistoryApi;
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
    Long pageSize = 56L; // 
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    try {
      LegalPersonHistoryListEventsResponse result = client
              .legalPersonHistory
              .listEvents(legalPersonId)
              .pageSize(pageSize)
              .pageAfter(pageAfter)
              .pageBefore(pageBefore)
              .execute();
      System.out.println(result);
      System.out.println(result.getLegalPersonHistory());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalPersonHistoryApi#listEvents");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LegalPersonHistoryListEventsResponse> response = client
              .legalPersonHistory
              .listEvents(legalPersonId)
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
      System.err.println("Exception when calling LegalPersonHistoryApi#listEvents");
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
| **pageSize** | **Long**|  | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |

### Return type

[**LegalPersonHistoryListEventsResponse**](LegalPersonHistoryListEventsResponse.md)

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

