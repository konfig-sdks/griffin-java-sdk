# EventsApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllOrganizationEvents**](EventsApi.md#getAllOrganizationEvents) | **GET** /v0/organizations/{organization-id}/events |  |
| [**getEvent**](EventsApi.md#getEvent) | **GET** /v0/events/{event-id} |  |


<a name="getAllOrganizationEvents"></a>
# **getAllOrganizationEvents**
> EventsGetAllOrganizationEventsResponse getAllOrganizationEvents(organizationId).sort(sort).pageSize(pageSize).pageBefore(pageBefore).pageAfter(pageAfter).filterEventTypeEq(filterEventTypeEq).filterCreatedAtLte(filterCreatedAtLte).filterCreatedAtLt(filterCreatedAtLt).filterCreatedAtGte(filterCreatedAtGte).filterCreatedAtGt(filterCreatedAtGt).execute();



List all events for an organization

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EventsApi;
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
    String sort = "-created-at"; // 
    Long pageSize = 56L; // 
    byte[] pageBefore = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    byte[] pageAfter = djE6NL0DfDTSUk67KJKCi-L5Zg; // A base64 encoded opaque string returned in paginated responses.
    String filterEventTypeEq = "decision-created"; // The type of webhook event. Usually has the form {resource}-{operation}, e.g. payment-updated
    OffsetDateTime filterCreatedAtLte = OffsetDateTime.now(); // Return only events with a created-at less than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtLt = OffsetDateTime.now(); // Return only events with a created-at less than the given timestamp.
    OffsetDateTime filterCreatedAtGte = OffsetDateTime.now(); // Return only events with a created-at greater than or equal to the given timestamp.
    OffsetDateTime filterCreatedAtGt = OffsetDateTime.now(); // Return only events with a created-at greater than the given timestamp.
    try {
      EventsGetAllOrganizationEventsResponse result = client
              .events
              .getAllOrganizationEvents(organizationId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterEventTypeEq(filterEventTypeEq)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .execute();
      System.out.println(result);
      System.out.println(result.getEvents());
      System.out.println(result.getLinks());
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getAllOrganizationEvents");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EventsGetAllOrganizationEventsResponse> response = client
              .events
              .getAllOrganizationEvents(organizationId)
              .sort(sort)
              .pageSize(pageSize)
              .pageBefore(pageBefore)
              .pageAfter(pageAfter)
              .filterEventTypeEq(filterEventTypeEq)
              .filterCreatedAtLte(filterCreatedAtLte)
              .filterCreatedAtLt(filterCreatedAtLt)
              .filterCreatedAtGte(filterCreatedAtGte)
              .filterCreatedAtGt(filterCreatedAtGt)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getAllOrganizationEvents");
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
| **sort** | **String**|  | [optional] [enum: -created-at, created-at] |
| **pageSize** | **Long**|  | [optional] |
| **pageBefore** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **pageAfter** | **byte[]**| A base64 encoded opaque string returned in paginated responses. | [optional] |
| **filterEventTypeEq** | **String**| The type of webhook event. Usually has the form {resource}-{operation}, e.g. payment-updated | [optional] [enum: decision-created, payment-created, transaction-created, verification-updated, admission-updated, verification-created, account-status-updated, submission-created, test-event, admission-created, account-status-created, submission-updated] |
| **filterCreatedAtLte** | **OffsetDateTime**| Return only events with a created-at less than or equal to the given timestamp. | [optional] |
| **filterCreatedAtLt** | **OffsetDateTime**| Return only events with a created-at less than the given timestamp. | [optional] |
| **filterCreatedAtGte** | **OffsetDateTime**| Return only events with a created-at greater than or equal to the given timestamp. | [optional] |
| **filterCreatedAtGt** | **OffsetDateTime**| Return only events with a created-at greater than the given timestamp. | [optional] |

### Return type

[**EventsGetAllOrganizationEventsResponse**](EventsGetAllOrganizationEventsResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Fetch all organization events |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |

<a name="getEvent"></a>
# **getEvent**
> EventsGetEventResponse getEvent(eventId).execute();



Get an event

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EventsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String eventId = "eventId_example";
    try {
      EventsGetEventResponse result = client
              .events
              .getEvent(eventId)
              .execute();
      System.out.println(result);
      System.out.println(result.getEventUrl());
      System.out.println(result.getEventType());
      System.out.println(result.getEventPayload());
      System.out.println(result.getCreatedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getEvent");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EventsGetEventResponse> response = client
              .events
              .getEvent(eventId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getEvent");
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
| **eventId** | **String**|  | |

### Return type

[**EventsGetEventResponse**](EventsGetEventResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Fetch an event |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |

